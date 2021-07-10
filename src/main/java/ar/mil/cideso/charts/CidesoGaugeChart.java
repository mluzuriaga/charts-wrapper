package ar.mil.cideso.charts;

import ar.mil.cideso.charts.external.SimpleSectionGauge;
import eu.hansolo.medusa.Section;
import javafx.scene.Node;
import javafx.scene.paint.Color;

public class CidesoGaugeChart extends CidesoChart {

    private final Integer alta;
    private final Integer baja;

    public CidesoGaugeChart(
            String chartTitle,
            Integer alta,
            Integer baja
    ) {

        super(chartTitle);

        this.alta = alta;
        this.baja = baja;

    }

    @Override
    public Node getChart() {

        long total = this.alta + this.baja;
        long value = 0;
        if (total != 0)
            value = (this.alta * 100) / total;

        SimpleSectionGauge gaugeChart = new SimpleSectionGauge(
                chartTitle,
                "%",
                0,
                100,
                Color.rgb(69, 106, 207),
                Color.rgb(150, 150, 150, 0.25),
                true,
                new Section(0, value - 1, Color.rgb(69, 207, 109)),
                //new Section(normalStart, normalEnd, Color.rgb(239, 215, 80)),
                new Section(value + 1, 100, Color.rgb(239, 96, 80)));

        gaugeChart.setValue(value);
        gaugeChart.setTitle("Total: " + total);

        return wrapInCard(
                chartTitle,
                gaugeChart);

    }

}
