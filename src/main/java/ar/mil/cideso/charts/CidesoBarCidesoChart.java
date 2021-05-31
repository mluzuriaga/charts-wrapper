package ar.mil.cideso.charts;

import ar.mil.cideso.model.BarChartData;
import javafx.scene.Node;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
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

        final javafx.scene.chart.StackedBarChart<String, Number> barChart = new javafx.scene.chart.StackedBarChart<>(
                xAxis,
                yAxis);

        AtomicLong total = new AtomicLong();
        AtomicInteger max = new AtomicInteger();
        AtomicInteger min = new AtomicInteger();

        barChartDataSet.forEach(
                barChartData -> {

                    XYChart.Series serie = new XYChart.Series<>();
                    serie.setName(barChartData.getSerieName());

                    AtomicLong totalParcial = new AtomicLong();

                    List<XYChart.Data> dataSet = barChartData.getSerieData()
                            .stream()
                            .map(
                                    chartData -> {
                                        Integer value = chartData.getValue();
                                        if (value > max.get())
                                            max.set(value);
                                        if (value < min.get())
                                            min.set(value);
                                        totalParcial.addAndGet(value);
                                        return new XYChart.Data<>(
                                                chartData.getDescription(),
                                                value);
                                    })
                            .collect(Collectors.toList());
                    serie.getData().addAll(dataSet);

                    barChart.getData().add(serie);

                    total.addAndGet(Math.abs(totalParcial.get()));

                });

        barChart.setTitle("Total: " + total);

        yAxis.setAutoRanging(false);
        yAxis.setLowerBound(min.get());
        yAxis.setUpperBound(max.get());
        yAxis.setTickUnit(1);

        return wrapInCard(
                chartTitle,
                barChart);

    }

}
