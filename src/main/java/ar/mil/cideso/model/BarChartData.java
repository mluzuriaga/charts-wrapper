package ar.mil.cideso.model;

import java.util.List;

public class BarChartData {

    private final String serieName;
    private final List<ChartData> serieData;

    public BarChartData(
            String serieName,
            List<ChartData> serieData) {

        this.serieName = serieName;
        this.serieData = serieData;

    }

    public String getSerieName() {
        return serieName;
    }

    public List<ChartData> getSerieData() {
        return serieData;
    }

}
