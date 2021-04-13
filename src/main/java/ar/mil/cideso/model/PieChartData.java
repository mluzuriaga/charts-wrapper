package ar.mil.cideso.model;

import java.util.Objects;

public class PieChartData {

    private final String category;
    private final Long value;

    public PieChartData(
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

        PieChartData that = (PieChartData) object;
        return Objects.equals(
                category,
                that.category);

    }

    @Override
    public int hashCode() {
        return Objects.hash(value, category);
    }
}
