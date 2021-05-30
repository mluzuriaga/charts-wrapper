import ar.mil.cideso.CidesoDashboard;
import ar.mil.cideso.model.ChartData;
import ar.mil.cideso.model.dto.EfectivosData;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.util.ArrayList;
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

        // EFECTIVOS
        EfectivosData efectivosAlta = new EfectivosData();
        efectivosAlta.setOficialSuperior(10);
        efectivosAlta.setOficialJefe(20);
        efectivosAlta.setOficialSubalterno(22);
        efectivosAlta.setSuboficialSuperior(11);
        efectivosAlta.setSuboficialSubalterno(41);
        efectivosAlta.setAgenteCivil(1);
        efectivosAlta.setSoldadoVoluntario(31);

        EfectivosData efectivosBaja = new EfectivosData();
        efectivosBaja.setOficialSuperior(1);
        efectivosBaja.setOficialJefe(2);
        efectivosBaja.setOficialSubalterno(42);
        efectivosBaja.setSuboficialSuperior(19);
        efectivosBaja.setSuboficialSubalterno(1);
        efectivosBaja.setAgenteCivil(16);
        efectivosBaja.setSoldadoVoluntario(16);

        Node efectivos = CidesoDashboard.getInstance().getEfectivosChart(
                efectivosAlta,
                efectivosBaja);
        tiles.add(efectivos);

        // ARMAMENTO
        Node armamentoPrincipal = CidesoDashboard.getInstance().getGaugeChart(
                "Armamento Princpal",
                12,
                14);
        tiles.add(armamentoPrincipal);

        Node armamentoSecundario = CidesoDashboard.getInstance().getGaugeChart(
                "Armamento Princpal",
                14,
                8);
        tiles.add(armamentoSecundario);

        // MUNICION
        Node municionPrincipal = CidesoDashboard.getInstance().getDonutChart(
                "Munición Principal",
                14,
                11);
        tiles.add(municionPrincipal);

        Node municionSecundaria = CidesoDashboard.getInstance().getDonutChart(
                "Munición Secundaria",
                14,
                11);
        tiles.add(municionSecundaria);

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

        // RACIONES
        Node raciones = CidesoDashboard.getInstance().getSimpleStringChart(
                "Raciones",
                "10",
                "unidades");
        tiles.add(raciones);

        // AGUA
        Node agua = CidesoDashboard.getInstance().getSimpleStringChart(
                "Agua",
                "100",
                "litros");
        tiles.add(agua);

        // RADIO ALCANCE
        Node radioAlcance = CidesoDashboard.getInstance().getSimpleStringChart(
                "Radio Alcance",
                "200",
                "metros");
        tiles.add(radioAlcance);

        // DASHBOARD COMPLETO
        CidesoDashboard cidesoDashboard = CidesoDashboard.getInstance();
        cidesoDashboard.getDashboardPane(
                "Vista General (Br. Mec. XI)",
                1366,
                768,
                tiles)
                .show();

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
