package ar.mil.cideso.model;

/**
 * Par de datos utilizados para graficar
 */
public class ChartData {

    // Valor numerico
    private final Integer value;
    // Descripcion o label del valor
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
