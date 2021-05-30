package ar.mil.cideso.charts;

import ar.mil.cideso.model.ChartData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.chart.PieChart;

import java.util.List;

public class CidesoPieChart extends CidesoChart {

    private final List<ChartData> chartDataSet;

    public CidesoPieChart(
            String chartTitle,
            List<ChartData> chartDataSet
    ) {

        super(chartTitle);
        this.chartDataSet = chartDataSet;

    }

    @Override
    public Node getChart() {

        long total = 0;

        ObservableList<PieChart.Data> observableList = FXCollections.observableArrayList();
        for (ChartData chartData : chartDataSet) {
            total += chartData.getValue();
            observableList.add(
                    new PieChart.Data(
                            chartData.getDescription() + " (" + chartData.getValue() + ")",
                            chartData.getValue()));
        }

        PieChart pieChart = new PieChart(observableList);
        pieChart.setLabelsVisible(false);
        pieChart.setTitle("Total: " + total);

        return wrapInCard(
                chartTitle,
                pieChart);

    }

}
