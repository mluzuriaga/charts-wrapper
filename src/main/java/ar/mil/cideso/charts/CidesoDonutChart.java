package ar.mil.cideso.charts;

import ar.mil.cideso.charts.external.DoughnutChart;
import ar.mil.cideso.model.ChartData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.chart.PieChart;

import java.util.List;

public class CidesoDonutChart extends CidesoChart {

    private final List<ChartData> chartDataSet;

    public CidesoDonutChart(
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

        DoughnutChart doughnutChart = new DoughnutChart(observableList);
        doughnutChart.setTitle("Total: " + total);

        return wrapInCard(
                chartTitle,
                doughnutChart);

    }

}
