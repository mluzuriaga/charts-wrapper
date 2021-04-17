import ar.mil.cideso.CidesoCharts;
import ar.mil.cideso.model.BarChartData;
import ar.mil.cideso.model.ChartData;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.HashSet;

public class Test extends Application {

    public static void main(
            String[] args) {

        Application.launch(args);

    }

    @Override
    public void start(
            Stage primaryStage) {

        //StackPane stackPane = this.setPieChart();
        StackPane stackPane = this.setBarChart();

        primaryStage.setTitle("Charts Example");
        primaryStage.setScene(new Scene(stackPane, 250, 150));
        primaryStage.show();

    }

    private StackPane setPieChart() {

        CidesoCharts cidesoCharts = new CidesoCharts();

        HashSet<ChartData> chartData = new HashSet<>();
        chartData.add(new ChartData("Grapefruit", 13L));
        chartData.add(new ChartData("Oranges", 25L));
        chartData.add(new ChartData("Plums", 10L));
        chartData.add(new ChartData("Pears", 22L));
        chartData.add(new ChartData("Apples", 30L));

        StackPane pane = new StackPane();
        pane.getChildren().add(
                cidesoCharts.getPieChart(
                        "Titulo",
                        chartData));

        return pane;

    }

    private StackPane setBarChart() {

        CidesoCharts cidesoCharts = new CidesoCharts();

        HashSet<BarChartData> barChartData = new HashSet<>();

        HashSet<ChartData> chartData2003 = new HashSet<>();
        chartData2003.add(new ChartData("Grapefruit", 13L));
        chartData2003.add(new ChartData("Oranges", 25L));
        barChartData.add(
                new BarChartData(
                        "2003",
                        chartData2003));

        HashSet<ChartData> chartData2004 = new HashSet<>();
        chartData2004.add(new ChartData("Grapefruit", 6L));
        chartData2004.add(new ChartData("Oranges", 15L));
        barChartData.add(
                new BarChartData(
                        "2004",
                        chartData2004));

        StackPane pane = new StackPane();
        pane.getChildren().add(
                cidesoCharts.getBarChart(
                        "Titulo",
                        barChartData));

        return pane;

    }

}
