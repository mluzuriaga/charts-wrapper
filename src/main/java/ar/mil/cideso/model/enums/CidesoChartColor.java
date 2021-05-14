package ar.mil.cideso.model.enums;

public enum CidesoChartColor {

    DEFAULT("#f5efef", "#dcdbdb"),
    GREEN("#41af29", "#25890e"),
    BLUE("#2344aa", "#0e2a89"),
    YELLOW("#ecc727", "#c9a00d"),
    RED("#b82323", "#a00a0a");

    private final String rgbPrimaryColor;
    private final String rgbSecondaryColor;

    CidesoChartColor(
            String rgbPrimaryColor,
            String rgbSecondaryColor) {

        this.rgbPrimaryColor = rgbPrimaryColor;
        this.rgbSecondaryColor = rgbSecondaryColor;

    }

    public String getRgbPrimaryColor() {
        return this.rgbPrimaryColor;
    }

    public String getRgbSecondaryColor() {
        return this.rgbSecondaryColor;
    }

}
