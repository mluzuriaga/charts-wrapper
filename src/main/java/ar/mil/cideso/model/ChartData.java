package ar.mil.cideso.model;

import java.util.Objects;

public class ChartData {

    private final String category;
    private final Long value;

    public ChartData(
            String category,
            Long value) {

        this.category = category;
        this.value = value;

    }

    public Long getValue() {
        return this.value;
    }

    public String getCategory() {
        return this.category;
    }

    @Override
    public boolean equals(
            Object object) {

        if (this == object)
            return true;

        if (object == null
                || getClass() != object.getClass())
            return false;

        ChartData chartData = (ChartData) object;
        return Objects.equals(
                category,
                chartData.category);

    }

    @Override
    public int hashCode() {
        return Objects.hash(value, category);
    }

}
