package ar.mil.cideso;

import ar.mil.cideso.charts.*;
import ar.mil.cideso.model.ChartData;
import ar.mil.cideso.model.dto.EfectivosData;
import ar.mil.cideso.model.enums.CidesoChartColor;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Singleton para interactuar con el panel de dashboar
 */
public class CidesoDashboard {

    private final CidesoDataChartBuilder cidesoDataChartBuilder;
    private static CidesoDashboard cidesoDashboardInstance;

    /**
     * Obtiene la instancia del dashboard
     *
     * @return - CidesoDashboard
     */
    public static CidesoDashboard getInstance() {

        if (Objects.isNull(cidesoDashboardInstance))
            cidesoDashboardInstance = new CidesoDashboard();

        return cidesoDashboardInstance;

    }

    public CidesoDashboard() {
        this.cidesoDataChartBuilder = new CidesoDataChartBuilder();
    }

    /**
     * Grafico de barras para efectivos
     *
     * @param efectivosAlta - efectivos dados de alta
     * @param efectivosBaja - efectivos dados de baja
     * @return - nodo FX
     */
    public Node getEfectivosChart(
            EfectivosData efectivosAlta,
            EfectivosData efectivosBaja
    ) {

        return new CidesoBarCidesoChart(
                "Efectivos",
                this.cidesoDataChartBuilder.getEfectivosData(
                        efectivosAlta,
                        efectivosBaja))
                .getChart();

    }

    /**
     * Grafico de anillo para 2 valores (alta/baja)
     *
     * @param chartTitle - titulo del grafico
     * @param alta       - elementos disponible o dada de alta
     * @param baja       - elementos faltante o dada de baja
     * @return - node FX
     */
    public Node getDonutChart(
            String chartTitle,
            Integer alta,
            Integer baja) {

        return new CidesoDonutChart(
                chartTitle,
                this.cidesoDataChartBuilder.getChartListData(
                        alta,
                        baja
                ))
                .getChart();

    }

    /**
     * Grafico de aguja
     *
     * @param chartTitle - titulo del grafico
     * @param alta       - elementos disponibles o dados de alta
     * @param baja       - elementos faltantes o dados de baja
     * @return - nodo FX
     */
    public Node getGaugeChart(
            String chartTitle,
            Integer alta,
            Integer baja
    ) {

        return new CidesoGaugeChart(
                chartTitle,
                alta,
                baja).getChart();

    }

    /**
     * Crea un grafico de torta
     *
     * @param chartTitle - titulo de la card sobre la que se insertara el grafico
     * @param dataSet    - datos para graficar. Cada par es valor numerico, y descripcion del valor
     * @return - nodo FX
     */
    public Node getPieChart(
            String chartTitle,
            List<ChartData> dataSet
    ) {

        return new CidesoPieChart(
                chartTitle,
                dataSet).getChart();

    }

    /**
     * Grafico para mostrar solo un numero o texto
     *
     * @param chartTitle - titulo del grafico
     * @param value      - valor
     * @param unit       - unidad del valor representado
     * @return -
     */
    public Node getSimpleStringChart(
            String chartTitle,
            String value,
            String unit) {

        CidesoSimpleStringChart cidesoSimpleStringChart = new CidesoSimpleStringChart(
                chartTitle,
                CidesoChartColor.DEFAULT,
                value,
                unit);
        return cidesoSimpleStringChart.getChart();

    }

    /**
     * Retorna el panel dashboard ya armado
     *
     * @param title      - titulo del dashboard
     * @param widthSize  - ancho
     * @param heightSize - alto
     * @param tiles      - nodos grafico a incluir en el dashboard
     * @return - nodo de JavaFX
     */
    public Stage getDashboardPane(
            String title,
            int widthSize,
            int heightSize,
            List<Node> tiles) {

        Stage primaryStage = new Stage();

        VBox rootPane = new VBox();
        rootPane.setStyle("-fx-background-color: #dbd8d8;");

        Scene sc = new Scene(rootPane, widthSize, heightSize);
        primaryStage.setScene(sc);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setStyle("-fx-background-color:transparent;");

        TilePane tp = new TilePane();
        tp.setHgap(13);
        tp.setVgap(13);
        tp.setPrefTileWidth(400);
        tp.setPrefTileHeight(350);
        tp.setPrefColumns(3);
        tp.setAlignment(Pos.TOP_LEFT);
        tp.setPadding(new Insets(20, 20, 20, 20));
        tp.setStyle("-fx-background-color: #dbd8d8;");

        scrollPane.setContent(tp);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);

        rootPane.getChildren().add(scrollPane);

        rootPane.setAlignment(Pos.CENTER);

        tiles.forEach(
                (tile) ->
                        tp.getChildren().add(tile));

        primaryStage.setTitle(title);
        return primaryStage;

    }

    /**
     * Dashboard predefinido
     *
     * @param title      - titulo del dashboard
     * @param widthSize  - ancho
     * @param heightSize - alto
     * @param data       - lista de datos numericos (Orden prefijado: ver README.md)
     * @return - stage FX
     */
    public Stage getCompleteDashboardPane(
            String title,
            int widthSize,
            int heightSize,
            List<Integer> data) {

        return this.getDashboardPane(
                title,
                widthSize,
                heightSize,
                this.getTiles(data));

    }

    private List<Node> getTiles(
            List<Integer> data) {

        List<Node> tiles = new ArrayList<>();

        // EFECTIVOS
        EfectivosData efectivosAlta = new EfectivosData();
        efectivosAlta.setOficialSuperior(data.get(0));
        efectivosAlta.setOficialJefe(data.get(2));
        efectivosAlta.setOficialSubalterno(data.get(4));
        efectivosAlta.setSuboficialSuperior(data.get(6));
        efectivosAlta.setSuboficialSubalterno(data.get(8));
        efectivosAlta.setAgenteCivil(data.get(10));
        efectivosAlta.setSoldadoVoluntario(data.get(12));

        EfectivosData efectivosBaja = new EfectivosData();
        efectivosBaja.setOficialSuperior(data.get(1));
        efectivosBaja.setOficialJefe(data.get(3));
        efectivosBaja.setOficialSubalterno(data.get(5));
        efectivosBaja.setSuboficialSuperior(data.get(7));
        efectivosBaja.setSuboficialSubalterno(data.get(8));
        efectivosBaja.setAgenteCivil(data.get(11));
        efectivosBaja.setSoldadoVoluntario(data.get(13));

        tiles.add(
                this.getEfectivosChart(
                        efectivosAlta,
                        efectivosBaja));

        // ARMAMENTO
        tiles.add(
                this.getGaugeChart(
                        "Armamento Principal",
                        14,
                        15));

        tiles.add(
                this.getGaugeChart(
                        "Armamento Secundario",
                        16,
                        30));


        // MUNICION
        tiles.add(
                this.getDonutChart(
                        "Munición Principal",
                        18,
                        19));

        tiles.add(
                this.getDonutChart(
                        "Munición Secundaria",
                        20,
                        21));


        // VEHICULOS
        List<ChartData> vehiculosData = new ArrayList<>();
        vehiculosData.add(new ChartData(data.get(22), "Combate Disponible"));
        vehiculosData.add(new ChartData(data.get(23), "Combate Faltante"));
        vehiculosData.add(new ChartData(data.get(24), "General Disponible"));
        vehiculosData.add(new ChartData(data.get(25), "General Faltante"));

        tiles.add(
                this.getPieChart(
                        "Vehículos",
                        vehiculosData));


        // COMBUSTIBLE
        List<ChartData> combustibleData = new ArrayList<>();
        combustibleData.add(new ChartData(data.get(26), "Nafta Disponible"));
        combustibleData.add(new ChartData(data.get(27), "Nafta Faltante"));
        combustibleData.add(new ChartData(data.get(28), "Diesel Disponible"));
        combustibleData.add(new ChartData(data.get(29), "Diesel Faltante"));
        tiles.add(
                this.getPieChart(
                        "Combustible",
                        combustibleData));


        Integer raciones = data.get(30);
        tiles.add(
                this.getSimpleStringChart(
                        "Raciones",
                        raciones.toString(),
                        "unidades"));

        Integer agua = data.get(31);
        tiles.add(
                this.getSimpleStringChart(
                        "Agua",
                        agua.toString(),
                        "litros"));

        Integer radioAccion = data.get(32);
        tiles.add(
                this.getSimpleStringChart(
                        "Radio Alcance",
                        radioAccion.toString(),
                        "metros"));

        return tiles;

    }

}
