package ar.mil.cideso.charts;

import ar.mil.cideso.model.ChartData;
import javafx.scene.Node;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CidesoSimpleBarCidesoChart extends CidesoChart {

    private final Set<ChartData> barChartDataSet;

    public CidesoSimpleBarCidesoChart(
            String chartTitle,
            Set<ChartData> barChartDataSet
    ) {

        super(chartTitle);
        this.barChartDataSet = barChartDataSet;

    }

    @Override
    public Node getChart() {

        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();

        final javafx.scene.chart.BarChart<String, Number> barChart = new javafx.scene.chart.BarChart<>(
                xAxis,
                yAxis);

        barChart.setTitle(chartTitle);

        barChartDataSet.forEach(
                barChartData -> {

                    XYChart.Series serie = new XYChart.Series();
                    serie.setName(barChartData.getCategory());
                    serie.getData().addAll(
                            new XYChart.Data<>(
                                    barChartData.getCategory(),
                                    barChartData.getValue()));

                    barChart.getData().add(serie);

                });

        return wrapInCard(
                chartTitle,
                barChart);

    }

}
