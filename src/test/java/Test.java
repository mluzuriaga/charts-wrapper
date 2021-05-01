import ar.mil.cideso.CidesoDashboard;
import ar.mil.cideso.model.BarChartData;
import ar.mil.cideso.model.ChartData;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Test extends Application {

    public static void main(
            String[] args) {

        Application.launch(args);

    }

    @Override
    public void start(
            Stage primaryStage) {

        List<Node> tiles = new ArrayList<>();

        Node feoperativa = CidesoDashboard.getCidesoDashboardInstance().getGaugeChart(
                "F. E. Operativa",
                "%",
                52,
                53,
                75,
                76,
                59.0);
        tiles.add(feoperativa);

        Node armamentoSecundario = CidesoDashboard.getCidesoDashboardInstance().getGaugeChart(
                "Armamento Secundario",
                "%",
                47,
                48,
                76,
                77,
                95.0);
        tiles.add(armamentoSecundario);

        Node presupuestoFuerzas = CidesoDashboard.getCidesoDashboardInstance().getPieChart(
                "Presupuesto",
                this.getPresupuestoFuerzas());
        tiles.add(presupuestoFuerzas);

        Node tropasDesplegadas = CidesoDashboard.getCidesoDashboardInstance().getBarChart(
                "Tropas Desplegadas",
                this.getTropasDesplegadaData());
        tiles.add(tropasDesplegadas);

        Node raciones = CidesoDashboard.getCidesoDashboardInstance().getSimpleNumberChart(
                "Raciones",
                "1499");
        tiles.add(raciones);

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

    private HashSet<BarChartData> getTropasDesplegadaData() {

        HashSet<BarChartData> barChartData = new HashSet<>();

        HashSet<ChartData> chartData2003 = new HashSet<>();
        chartData2003.add(new ChartData("Ejército", 18000L));
        chartData2003.add(new ChartData("Fuerza Aérea", 500L));
        chartData2003.add(new ChartData("Armada", 400L));
        barChartData.add(
                new BarChartData(
                        "2003",
                        chartData2003));

        HashSet<ChartData> chartData2004 = new HashSet<>();
        chartData2004.add(new ChartData("Ejército", 10000L));
        chartData2004.add(new ChartData("Fuerza Aérea", 800L));
        chartData2004.add(new ChartData("Armada", 2000L));
        barChartData.add(
                new BarChartData(
                        "2004",
                        chartData2004));

        return barChartData;

    }

}
