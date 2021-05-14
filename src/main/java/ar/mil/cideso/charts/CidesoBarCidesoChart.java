package ar.mil.cideso.charts;

import ar.mil.cideso.model.BarChartData;
import javafx.scene.Node;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.util.List;
import java.util.stream.Collectors;

public class CidesoBarCidesoChart extends CidesoChart {

    private final List<BarChartData> barChartDataSet;

    public CidesoBarCidesoChart(
            String chartTitle,
            List<BarChartData> barChartDataSet
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
                    serie.setName(barChartData.getSerieName());

                    List<XYChart.Data> dataSet = barChartData.getSerieData()
                            .stream()
                            .map(
                                    chartData -> new XYChart.Data<>(
                                            chartData.getDescription(),
                                            chartData.getValue()))
                            .collect(Collectors.toList());
                    serie.getData().addAll(dataSet);

                    barChart.getData().add(serie);

                });

        return wrapInCard(
                chartTitle,
                barChart);

    }

}
