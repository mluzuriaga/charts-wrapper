package ar.mil.cideso.charts;

import ar.mil.cideso.model.ChartData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.chart.PieChart;

import java.util.Set;

public class CidesoPieChart extends CidesoChart {

    private final Set<ChartData> chartDataSet;

    public CidesoPieChart(
            String chartTitle,
            Set<ChartData> chartDataSet
    ) {

        super(chartTitle);
        this.chartDataSet = chartDataSet;

    }

    @Override
    public Node getChart() {

        ObservableList<PieChart.Data> observableList = FXCollections.observableArrayList();
        for (ChartData chartData : chartDataSet)
            observableList.add(
                    new PieChart.Data(
                            chartData.getCategory(),
                            chartData.getValue()));

        PieChart pieChart = new PieChart(observableList);
        pieChart.setTitle(chartTitle);

        return wrapInCard(
                chartTitle,
                pieChart);

    }

}
