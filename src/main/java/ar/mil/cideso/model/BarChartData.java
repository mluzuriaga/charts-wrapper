package ar.mil.cideso.model;

import lombok.Data;

import java.util.List;

@Data
public class BarChartData {

    private final String serieName;
    private final List<ChartData> serieData;

    public BarChartData(
            String serieName,
            List<ChartData> serieData) {

        this.serieName = serieName;
        this.serieData = serieData;

    }

}
