package ar.mil.cideso;

import ar.mil.cideso.charts.*;
import ar.mil.cideso.model.BarChartData;
import ar.mil.cideso.model.ChartData;
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
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CidesoDashboard {

    private static CidesoDashboard cidesoDashboardInstance;

    public static CidesoDashboard getInstance() {

        if (Objects.isNull(cidesoDashboardInstance))
            cidesoDashboardInstance = new CidesoDashboard();

        return cidesoDashboardInstance;

    }

    public CidesoDashboard() {

    }

    /**
     * Grafico de torta
     *
     * @param chartTitle - titulo del grafico de torta
     * @param dataSet    - datos para graficar. Cada ChartData recibe el valor, y que representa el valor
     * @return -
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
     * Grafico de anillo
     *
     * @param chartTitle - titulo del grafico de anillo
     * @param dataSet    - datos para graficar. Cada ChartData recibe el valor, y que representa el valor
     * @return -
     */
    public Node getDonutChart(
            String chartTitle,
            List<ChartData> dataSet) {

        return new CidesoDonutChart(
                chartTitle,
                dataSet).getChart();

    }

    /**
     * Grafico de barras
     *
     * @param chartTitle      - titulo del grafico de barras
     * @param barChartDataSet - se reciben las series de barras a mostrar. La serie tiene un nombre y una lista de ChartData
     * @return -
     */
    public Node getBarChart(
            String chartTitle,
            List<BarChartData> barChartDataSet
    ) {

        return new CidesoBarCidesoChart(
                chartTitle,
                barChartDataSet).getChart();

    }

    /**
     * Grafico para mostrar solo un numero o texto
     *
     * @param chartTitle - titulo del grafico
     * @param value      - valor
     * @return -
     */
    public Node getSimpleStringChart(
            String chartTitle,
            String value) {

        CidesoSimpleStringChart cidesoSimpleStringChart = new CidesoSimpleStringChart(
                chartTitle,
                CidesoChartColor.DEFAULT,
                value);
        return cidesoSimpleStringChart.getChart();

    }

    private Node getGaugeChart(
            String chartTitle,
            String unit,
            int criticalEnd,
            int normalStart,
            int normalEnd,
            int optimalStart,
            Double value
    ) {

        CidesoGaugeChart cidesoGaugeChart = new CidesoGaugeChart(
                chartTitle,
                unit,
                criticalEnd,
                normalStart,
                normalEnd,
                optimalStart,
                value);
        return cidesoGaugeChart.getChart();

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

        rootPane.getChildren().add(scrollPane);

        rootPane.setAlignment(Pos.CENTER);
        rootPane.setFillWidth(false);

        rootPane.widthProperty().addListener(
                (o, oldValue, newValue) ->
                        tp.setPrefColumns(Math.min(tp.getChildren().size(),
                                Math.max(1, (int) (newValue.doubleValue() / tp.getPrefTileWidth())))));

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
     * @param data       - datos recibidos y usados en el orden en que se mandaron en la foto
     * @return -
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
        List<BarChartData> barChartData = new ArrayList<>();
        BarChartData oficialSuperior = new BarChartData(
                "Oficial Superior",
                new ArrayList<>(
                        Arrays.asList(
                                new ChartData(data.get(0), "Alta"),
                                new ChartData(data.get(1), "Baja")
                        )));
        barChartData.add(oficialSuperior);

        BarChartData oficialJefe = new BarChartData(
                "Oficial Jefe",
                new ArrayList<>(
                        Arrays.asList(
                                new ChartData(data.get(2), "Alta"),
                                new ChartData(data.get(3), "Baja")
                        )));
        barChartData.add(oficialJefe);

        BarChartData oficialSubalterno = new BarChartData(
                "Oficial Subalterno",
                new ArrayList<>(
                        Arrays.asList(
                                new ChartData(data.get(4), "Alta"),
                                new ChartData(data.get(5), "Baja")
                        )));
        barChartData.add(oficialSubalterno);

        BarChartData suboficialSuperior = new BarChartData(
                "SubOficial Superior",
                new ArrayList<>(
                        Arrays.asList(
                                new ChartData(data.get(6), "Alta"),
                                new ChartData(data.get(7), "Baja")
                        )));
        barChartData.add(suboficialSuperior);

        BarChartData suboficialSubalterno = new BarChartData(
                "SubOficial Subalterno",
                new ArrayList<>(
                        Arrays.asList(
                                new ChartData(data.get(8), "Alta"),
                                new ChartData(data.get(9), "Baja")
                        )));
        barChartData.add(suboficialSubalterno);

        BarChartData soldadoVoluntario = new BarChartData(
                "Soldado Voluntario",
                new ArrayList<>(
                        Arrays.asList(
                                new ChartData(data.get(10), "Alta"),
                                new ChartData(data.get(11), "Baja")
                        )));
        barChartData.add(soldadoVoluntario);

        BarChartData agenteCivil = new BarChartData(
                "Agente civil",
                new ArrayList<>(
                        Arrays.asList(
                                new ChartData(data.get(12), "Alta"),
                                new ChartData(data.get(13), "Baja")
                        )));
        barChartData.add(agenteCivil);
        tiles.add(
                this.getBarChart(
                        "Efectivos",
                        barChartData));


        // ARMAMENTO
        List<ChartData> armamentoPrincipalData = new ArrayList<>();
        armamentoPrincipalData.add(new ChartData(data.get(14), "Alta"));
        armamentoPrincipalData.add(new ChartData(data.get(15), "Baja"));
        tiles.add(
                this.getDonutChart(
                        "Armamento Principal",
                        armamentoPrincipalData));

        List<ChartData> armamentoSecundarioData = new ArrayList<>();
        armamentoSecundarioData.add(new ChartData(data.get(16), "Alta"));
        armamentoSecundarioData.add(new ChartData(data.get(17), "Baja"));
        tiles.add(
                this.getDonutChart(
                        "Armamento Secundario",
                        armamentoSecundarioData));


        // MUNICION
        List<ChartData> municionData = new ArrayList<>();
        municionData.add(new ChartData(data.get(18), "Principal Alta"));
        municionData.add(new ChartData(data.get(19), "Principal Baja"));
        municionData.add(new ChartData(data.get(20), "Secundaria Alta"));
        municionData.add(new ChartData(data.get(21), "Secundaria Baja"));
        tiles.add(
                this.getPieChart(
                        "Municion",
                        municionData));


        // VEHICULOS
        List<ChartData> vehiculosData = new ArrayList<>();
        vehiculosData.add(new ChartData(data.get(22), "Combate Alta"));
        vehiculosData.add(new ChartData(data.get(23), "Combate Baja"));
        vehiculosData.add(new ChartData(data.get(24), "General Alta"));
        vehiculosData.add(new ChartData(data.get(25), "General Baja"));
        tiles.add(
                this.getPieChart(
                        "Vehiculos",
                        vehiculosData));


        // COMBUSTIBLE
        List<ChartData> combustibleData = new ArrayList<>();
        combustibleData.add(new ChartData(data.get(26), "Nafta Alta"));
        combustibleData.add(new ChartData(data.get(27), "Nafta Baja"));
        combustibleData.add(new ChartData(data.get(28), "Diesel Alta"));
        combustibleData.add(new ChartData(data.get(29), "Diesel Baja"));
        tiles.add(
                this.getPieChart(
                        "Combustible",
                        combustibleData));


        Integer raciones = data.get(30);
        tiles.add(
                this.getSimpleStringChart(
                        "Raciones",
                        raciones.toString()));

        Integer agua = data.get(31);
        tiles.add(
                this.getSimpleStringChart(
                        "Agua",
                        agua.toString()));

        Integer radioAccion = data.get(32);
        tiles.add(
                this.getSimpleStringChart(
                        "Radio Alcance",
                        radioAccion.toString()));

        return tiles;

    }

}