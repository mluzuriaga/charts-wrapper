package ar.mil.cideso;

import ar.mil.cideso.model.BarChartData;
import ar.mil.cideso.model.ChartData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CidesoCharts {

    public PieChart getPieChart(
            String title,
            Set<ChartData> chartDataSet
    ) {

        ObservableList<PieChart.Data> observableList = FXCollections.observableArrayList();
        for (ChartData chartData : chartDataSet)
            observableList.add(
                    new PieChart.Data(
                            chartData.getCategory(),
                            chartData.getValue()));

        PieChart pieChart = new PieChart(observableList);
        pieChart.setTitle(title);
        return pieChart;

    }

    public BarChart<String,Number> getBarChart(
            String title,
            Set<BarChartData> barChartDataSet
    ) {

        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();

        final BarChart<String,Number> barChart = new BarChart<>(
                xAxis,
                yAxis);

        barChart.setTitle(title);

        barChartDataSet.forEach(
                barChartData -> {

                    XYChart.Series serie = new XYChart.Series();
                    serie.setName(barChartData.getSerieName());

                    List<XYChart.Data> dataSet = barChartData.getSerieData()
                            .stream()
                            .map(
                                    chartData -> new XYChart.Data<>(
                                            chartData.getCategory(),
                                            chartData.getValue()))
                            .collect(Collectors.toList());
                    serie.getData().addAll(dataSet);

                    barChart.getData().add(serie);

                });

        return barChart;

    }

}
