package ar.mil.cideso;

import ar.mil.cideso.model.PieChartData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

import java.util.Set;

public class CidesoCharts {

    public PieChart getPieChart(
            String title,
            Set<PieChartData> pieChartDataList
    ) {

        ObservableList<PieChart.Data> observableList = FXCollections.observableArrayList();
        for (PieChartData pieChartData : pieChartDataList)
            observableList.add(
                    new PieChart.Data(
                            pieChartData.getCategory(),
                            pieChartData.getValue()));

        PieChart pieChart = new PieChart(observableList);
        pieChart.setTitle(title);
        return pieChart;

    }

}
