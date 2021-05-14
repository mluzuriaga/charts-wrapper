import ar.mil.cideso.CidesoDashboard;
import ar.mil.cideso.model.BarChartData;
import ar.mil.cideso.model.ChartData;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * En este test se crea cada grafico por separado, de acuerdo a la necesidad para representar los datos
 */
public class TestGraficosPorSeparado extends Application {

    public static void main(
            String[] args) {

        Application.launch(args);

    }

    @Override
    public void start(
            Stage primaryStage) {

        List<Node> tiles = new ArrayList<>();

        // RACIONES
        Node raciones = CidesoDashboard.getInstance().getSimpleStringChart(
                "Raciones",
                "10");
        tiles.add(raciones);

        // AGUA
        Node agua = CidesoDashboard.getInstance().getSimpleStringChart(
                "Agua",
                "100");
        tiles.add(agua);

        // RADIO ALCANCE
        Node radioAlcance = CidesoDashboard.getInstance().getSimpleStringChart(
                "Radio Alcance",
                "200");
        tiles.add(radioAlcance);

        // ARMAMENTO PRINCIPAL
        Node armamentoPrincipal = CidesoDashboard.getInstance().getDonutChart(
                "Armamento Principal",
                this.getArmamentoPrincipalData());
        tiles.add(armamentoPrincipal);

        // ARMAMENTO SECUNDARIO
        Node armamentoSecundario = CidesoDashboard.getInstance().getDonutChart(
                "Armamento Secundario",
                this.getArmamentoSecundarioData());
        tiles.add(armamentoSecundario);

        // EFECTIVOS
        Node efectivos = CidesoDashboard.getInstance().getBarChart(
                "Efectivos",
                this.getEfectivosData());
        tiles.add(efectivos);

        // MUNICION
        Node municion = CidesoDashboard.getInstance().getPieChart(
                "Municion",
                this.getMunicionData());
        tiles.add(municion);

        // VEHICULOS
        Node vehiculos = CidesoDashboard.getInstance().getPieChart(
                "Vehiculos",
                this.getVehiculosData());
        tiles.add(vehiculos);

        // COMBUSTIBLE
        Node combustible = CidesoDashboard.getInstance().getPieChart(
                "Combustible",
                this.getCombustibleData());
        tiles.add(combustible);

        // DASHBOARD COMPLETO
        CidesoDashboard cidesoDashboard = CidesoDashboard.getInstance();
        cidesoDashboard.getDashboardPane(
                "Vista General (Br. Mec. XI)",
                1366,
                768,
                tiles)
                .show();

    }

    private List<ChartData> getArmamentoPrincipalData() {

        List<ChartData> chartDataAlta = new ArrayList<>();

        chartDataAlta.add(new ChartData(10, "Alta"));
        chartDataAlta.add(new ChartData(1, "Baja"));

        return chartDataAlta;

    }

    private List<ChartData> getArmamentoSecundarioData() {

        List<ChartData> chartDataAlta = new ArrayList<>();

        chartDataAlta.add(new ChartData(20, "Alta"));
        chartDataAlta.add(new ChartData(10, "Baja"));

        return chartDataAlta;

    }

    private List<BarChartData> getEfectivosData() {

        List<BarChartData> barChartData = new ArrayList<>();

        BarChartData oficialSuperior = new BarChartData(
                "Oficial Superior",
                new ArrayList<>(
                        Arrays.asList(
                                new ChartData(10, "Alta"),
                                new ChartData(16, "Baja")
                        )));
        barChartData.add(oficialSuperior);

        BarChartData oficialJefe = new BarChartData(
                "Oficial Jefe",
                new ArrayList<>(
                        Arrays.asList(
                                new ChartData(20, "Alta"),
                                new ChartData(11, "Baja")
                        )));
        barChartData.add(oficialJefe);

        BarChartData oficialSubalterno = new BarChartData(
                "Oficial Subalterno",
                new ArrayList<>(
                        Arrays.asList(
                                new ChartData(1, "Alta"),
                                new ChartData(5, "Baja")
                        )));
        barChartData.add(oficialSubalterno);

        BarChartData suboficialSuperior = new BarChartData(
                "SubOficial Superior",
                new ArrayList<>(
                        Arrays.asList(
                                new ChartData(30, "Alta"),
                                new ChartData(41, "Baja")
                        )));
        barChartData.add(suboficialSuperior);

        BarChartData suboficialSubalterno = new BarChartData(
                "SubOficial Subalterno",
                new ArrayList<>(
                        Arrays.asList(
                                new ChartData(10, "Alta"),
                                new ChartData(1, "Baja")
                        )));
        barChartData.add(suboficialSubalterno);

        BarChartData soldadoVoluntario = new BarChartData(
                "Soldado Voluntario",
                new ArrayList<>(
                        Arrays.asList(
                                new ChartData(24, "Alta"),
                                new ChartData(19, "Baja")
                        )));
        barChartData.add(soldadoVoluntario);

        BarChartData agenteCivil = new BarChartData(
                "Agente civil",
                new ArrayList<>(
                        Arrays.asList(
                                new ChartData(10, "Alta"),
                                new ChartData(1, "Baja")
                        )));
        barChartData.add(agenteCivil);

        return barChartData;

    }

    private List<ChartData> getMunicionData() {

        List<ChartData> chartDataAlta = new ArrayList<>();

        chartDataAlta.add(new ChartData(20, "Principal Alta"));
        chartDataAlta.add(new ChartData(10, "Principal Baja"));
        chartDataAlta.add(new ChartData(40, "Secundaria Alta"));
        chartDataAlta.add(new ChartData(20, "Secundaria Baja"));

        return chartDataAlta;

    }

    private List<ChartData> getVehiculosData() {

        List<ChartData> chartDataAlta = new ArrayList<>();

        chartDataAlta.add(new ChartData(20, "Combate Alta"));
        chartDataAlta.add(new ChartData(10, "Combate Baja"));
        chartDataAlta.add(new ChartData(40, "General Alta"));
        chartDataAlta.add(new ChartData(20, "General Baja"));

        return chartDataAlta;

    }

    private List<ChartData> getCombustibleData() {

        List<ChartData> chartDataAlta = new ArrayList<>();

        chartDataAlta.add(new ChartData(20, "Nafta Alta"));
        chartDataAlta.add(new ChartData(10, "Nafta Baja"));
        chartDataAlta.add(new ChartData(40, "Diesel Alta"));
        chartDataAlta.add(new ChartData(20, "Diesel Baja"));

        return chartDataAlta;

    }

}
