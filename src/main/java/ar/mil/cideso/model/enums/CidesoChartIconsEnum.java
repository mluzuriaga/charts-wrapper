package ar.mil.cideso.model.enums;

public enum CidesoChartIconsEnum {

    AGUA("ar.mil.cideso.charts/agua.png"),
    RACIONES("raciones.png"),
    RADIO_ALCANCE("radioAlcance.png");

    private final String iconPath;

    private CidesoChartIconsEnum(
            String iconPath) {

        this.iconPath = iconPath;

    }

    public String getIconPath() {
        return this.iconPath;
    }

}
