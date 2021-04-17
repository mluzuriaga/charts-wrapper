package ar.mil.cideso.model;

import java.util.Objects;
import java.util.Set;

public class BarChartData {

    private final String serieName;
    private final Set<ChartData> serieData;

    public BarChartData(
            String serieName,
            Set<ChartData> serieData) {

        this.serieName = serieName;
        this.serieData = serieData;

    }

    public String getSerieName() {
        return this.serieName;
    }

    public Set<ChartData> getSerieData() {
        return this.serieData;
    }

    @Override
    public boolean equals(
            Object object) {

        if (this == object)
            return true;

        if (object == null
                || getClass() != object.getClass())
            return false;

        BarChartData barChartData = (BarChartData) object;
        return Objects.equals(
                serieName,
                barChartData.serieName);

    }

    @Override
    public int hashCode() {
        return Objects.hash(serieName);
    }

}
