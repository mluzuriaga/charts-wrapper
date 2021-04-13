import ar.mil.cideso.CidesoCharts;
import ar.mil.cideso.model.PieChartData;
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

        CidesoCharts cidesoCharts = new CidesoCharts();

        HashSet<PieChartData> pieChartData = new HashSet<>();
        pieChartData.add(new PieChartData("Grapefruit", 13L));
        pieChartData.add(new PieChartData("Oranges", 25L));
        pieChartData.add(new PieChartData("Plums", 10L));
        pieChartData.add(new PieChartData("Pears", 22L));
        pieChartData.add(new PieChartData("Apples", 30L));

        StackPane pane = new StackPane();
        pane.getChildren().add(
                cidesoCharts.getPieChart(
                        "Titulo",
                        pieChartData));

        primaryStage.setTitle("Charts Example");
        primaryStage.setScene(new Scene(pane, 250, 150));
        primaryStage.show();

    }

}
