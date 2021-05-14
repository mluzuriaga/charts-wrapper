package ar.mil.cideso.model;

import lombok.Data;

@Data
public class ChartData {

    private final Integer value;
    private final String description;

    public ChartData(
            Integer value,
            String description) {

        this.value = value;
        this.description = description;

    }

}
