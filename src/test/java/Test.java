import ar.mil.cideso.CidesoDashboard;
import ar.mil.cideso.model.BarChartData;
import ar.mil.cideso.model.ChartData;
import ar.mil.cideso.model.ChartTypeEnum;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test extends Application {

    public static void main(
            String[] args) {

        Application.launch(args);

    }

    @Override
    public void start(
            Stage primaryStage) {

        List<Node> tiles = new ArrayList<>();

        /*// FE OPERATIVA
        Node feoperativa = CidesoDashboard.getCidesoDashboardInstance().getGaugeChart(
                "F. E. Operativa",
                "%",
                52,
                53,
                75,
                76,
                59.0);
        tiles.add(feoperativa);

        // ARMAMENTO SECUNDARIO
        Node armamentoSecundario = CidesoDashboard.getCidesoDashboardInstance().getGaugeChart(
                "Armamento Secundario",
                "%",
                47,
                48,
                76,
                77,
                95.0);
        tiles.add(armamentoSecundario);

        // PRESUPUESTO
        Node presupuestoFuerzas = CidesoDashboard.getCidesoDashboardInstance().getPieChart(
                "Presupuesto",
                this.getPresupuestoFuerzas());
        tiles.add(presupuestoFuerzas);*/

        // EFECTIVOS
        Node efectivos = CidesoDashboard.getCidesoDashboardInstance().buildChart(
                ChartTypeEnum.BAR,
                "Efectivos",
                this.getEfectivos());

        // ARMAMENTO
        Node armamento = CidesoDashboard.getCidesoDashboardInstance().buildChart(
                ChartTypeEnum.BAR,
                "Armamento",
                this.getArmamento());
        tiles.add(armamento);

        // MUNICION
        Node municion = CidesoDashboard.getCidesoDashboardInstance().buildChart(
                ChartTypeEnum.BAR,
                "Municion",
                this.getMunicion());
        tiles.add(municion);

        // VEHICULOS
        Node vehiculos = CidesoDashboard.getCidesoDashboardInstance().buildChart(
                ChartTypeEnum.BAR,
                "Vehiculos",
                this.getVehiculos());
        tiles.add(vehiculos);

        // COMBUSTIBLE
        Node combustible = CidesoDashboard.getCidesoDashboardInstance().buildChart(
                ChartTypeEnum.BAR,
                "Combustible",
                this.getCombustible());
        tiles.add(combustible);

        // RACIONES
        Node raciones = CidesoDashboard.getCidesoDashboardInstance().buildChart(
                ChartTypeEnum.SIMPLE_NUMBER,
                "Raciones",
                this.getRaciones());
        tiles.add(raciones);

        // AGUA
        Node agua = CidesoDashboard.getCidesoDashboardInstance().buildChart(
                ChartTypeEnum.SIMPLE_NUMBER,
                "Agua",
                this.getAgua());
        tiles.add(agua);

        // RADIO ALCANCE
        Node radioAlcance = CidesoDashboard.getCidesoDashboardInstance().buildChart(
                ChartTypeEnum.SIMPLE_NUMBER,
                "Radio Alcance",
                this.getRadioAlcance());
        tiles.add(radioAlcance);

        // DASHBOARD COMPLETO
        CidesoDashboard cidesoDashboard = CidesoDashboard.getCidesoDashboardInstance();
        cidesoDashboard.getDashboardPane(
                "Vista General (Br. Mec. XI)",
                1366,
                768,
                tiles)
                .show();

    }

    private HashSet<ChartData> getPresupuestoFuerzas() {

        HashSet<ChartData> chartData = new HashSet<>();
        chartData.add(new ChartData("Ejército", 130L));
        chartData.add(new ChartData("Fuerza Aérea", 70L));
        chartData.add(new ChartData("Armada", 100L));

        return chartData;

    }

    private Set<ChartData> getEfectivos() {

        Set<ChartData> chartDataAlta = new HashSet<>();

        chartDataAlta.add(new ChartData("OS", 10L));
        chartDataAlta.add(new ChartData("OJ", 18L));
        chartDataAlta.add(new ChartData("OSub", 5L));
        chartDataAlta.add(new ChartData("SS", 24L));
        chartDataAlta.add(new ChartData("SSub", 14L));
        chartDataAlta.add(new ChartData("SV", 1L));
        chartDataAlta.add(new ChartData("AC", 9L));

        return chartDataAlta;

    }

    private Set<ChartData> getArmamento() {

        Set<ChartData> chartDataAlta = new HashSet<>();

        chartDataAlta.add(new ChartData("AP", 10L));
        chartDataAlta.add(new ChartData("AS", 1L));

        return chartDataAlta;

    }

    private Set<ChartData> getMunicion() {

        HashSet<ChartData> chartDataAlta = new HashSet<>();

        chartDataAlta.add(new ChartData("MP", 100L));
        chartDataAlta.add(new ChartData("MS", 10L));

        return chartDataAlta;

    }

    private Set<ChartData> getVehiculos() {

        Set<ChartData> chartDataAlta = new HashSet<>();

        chartDataAlta.add(new ChartData("VC", 10L));
        chartDataAlta.add(new ChartData("VG", 0L));

        return chartDataAlta;

    }

    private Set<ChartData> getCombustible() {

        HashSet<ChartData> chartDataAlta = new HashSet<>();

        chartDataAlta.add(new ChartData("N", 10L));
        chartDataAlta.add(new ChartData("D", 0L));

        return chartDataAlta;

    }

    private Set<ChartData> getRaciones() {

        HashSet<ChartData> chartDataAlta = new HashSet<>();

        chartDataAlta.add(new ChartData("cnt.", 10L));

        return chartDataAlta;

    }

    private Set<ChartData> getAgua() {

        HashSet<ChartData> chartDataAlta = new HashSet<>();

        chartDataAlta.add(new ChartData("Litros", 10L));

        return chartDataAlta;

    }

    private Set<ChartData> getRadioAlcance() {

        HashSet<ChartData> chartDataAlta = new HashSet<>();

        chartDataAlta.add(new ChartData("Metros", 10L));

        return chartDataAlta;

    }

}
