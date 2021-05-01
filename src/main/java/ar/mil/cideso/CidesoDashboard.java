package ar.mil.cideso;

import ar.mil.cideso.charts.CidesoBarCidesoChart;
import ar.mil.cideso.charts.CidesoGaugeChart;
import ar.mil.cideso.charts.CidesoPieChart;
import ar.mil.cideso.charts.CidesoSimpleNumberChart;
import ar.mil.cideso.charts.external.SimpleSectionGauge;
import ar.mil.cideso.model.BarChartData;
import ar.mil.cideso.model.ChartData;
import eu.hansolo.medusa.Section;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class CidesoDashboard {

    private static CidesoDashboard cidesoDashboardInstance;

    private CidesoDashboard() {

    }

    public static CidesoDashboard getCidesoDashboardInstance() {

        if (Objects.isNull(cidesoDashboardInstance))
            cidesoDashboardInstance = new CidesoDashboard();

        return cidesoDashboardInstance;

    }

    public Node getPieChart(
            String chartTitle,
            Set<ChartData> chartDataSet
    ) {

        CidesoPieChart cidesoPieChart = new CidesoPieChart(
                chartTitle,
                chartDataSet);
        return cidesoPieChart.getChart();

    }

    public Node getBarChart(
            String chartTitle,
            Set<BarChartData> barChartDataSet
    ) {

        CidesoBarCidesoChart cidesoBarChart = new CidesoBarCidesoChart(
                chartTitle,
                barChartDataSet);
        return cidesoBarChart.getChart();

    }

    public Node getSimpleNumberChart(
            String chartTitle,
            String value
    ) {

        CidesoSimpleNumberChart cidesoSimpleNumberChart = new CidesoSimpleNumberChart(
                chartTitle,
                value);
        return cidesoSimpleNumberChart.getChart();

    }

    public Node getGaugeChart(
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

    public Stage getDashboardPane(
            String title,
            int widthSize,
            int heightSize,
            List<Node> tiles
    ) {

        Stage primaryStage = new Stage();

        VBox rootPane = new VBox();
        rootPane.setStyle("-fx-background-color: #dbd8d8;");

        Scene sc = new Scene(rootPane, widthSize, heightSize);
        primaryStage.setScene(sc);

        TilePane tp = new TilePane();
        tp.setHgap(13);
        tp.setVgap(13);
        tp.setPrefTileWidth(400);
        tp.setPrefTileHeight(300);
        tp.setPrefColumns(3);
        tp.setAlignment(Pos.TOP_LEFT);
        rootPane.getChildren().add(tp);

        rootPane.setAlignment(Pos.CENTER);
        rootPane.setFillWidth(false);

        rootPane.widthProperty().addListener((o, oldValue, newValue) -> {
            tp.setPrefColumns(Math.min(tp.getChildren().size(),
                    Math.max(1, (int) (newValue.doubleValue() / tp.getPrefTileWidth()))));
        });

        tiles.forEach(
                (tile) ->
                        tp.getChildren().add(tile));

        primaryStage.setTitle(title);
        return primaryStage;

    }

}
