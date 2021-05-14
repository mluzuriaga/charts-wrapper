package ar.mil.cideso.model;

public class ChartData {

    private final Integer value;
    private final String description;

    public ChartData(
            Integer value,
            String description) {

        this.value = value;
        this.description = description;

    }

    public Integer getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

}
