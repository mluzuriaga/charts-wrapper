package ar.mil.cideso.charts;

import ar.mil.cideso.charts.external.SimpleSectionGauge;
import eu.hansolo.medusa.Section;
import javafx.scene.Node;
import javafx.scene.paint.Color;

public class CidesoGaugeChart extends CidesoChart {

    private final String unit;
    private final int criticalEnd;
    private final int normalStart;
    private final int normalEnd;
    private final int optimalStart;
    private final Double value;

    public CidesoGaugeChart(
            String chartTitle,
            String unit,
            int criticalEnd,
            int normalStart,
            int normalEnd,
            int optimalStart,
            Double value
    ) {

        super(chartTitle);

        this.unit = unit;
        this.criticalEnd = criticalEnd;
        this.normalStart = normalStart;
        this.normalEnd = normalEnd;
        this.optimalStart = optimalStart;
        this.value = value;

    }

    @Override
    public Node getChart() {

        SimpleSectionGauge gaugeChart = new SimpleSectionGauge(
                chartTitle,
                unit,
                0,
                100,
                Color.rgb(69, 106, 207),
                Color.rgb(150, 150, 150, 0.25),
                true,
                new Section(optimalStart, 100, Color.rgb(69, 207, 109)),
                new Section(normalStart, normalEnd, Color.rgb(239, 215, 80)),
                new Section(0, criticalEnd, Color.rgb(239, 96, 80)));
        gaugeChart.setValue(value);

        return wrapInCard(
                chartTitle,
                gaugeChart);

    }

}
