package ar.mil.cideso;

import ar.mil.cideso.model.BarChartData;
import ar.mil.cideso.model.ChartData;
import ar.mil.cideso.model.dto.EfectivosData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CidesoDataChartBuilder {

    protected List<BarChartData> getEfectivosData(
            EfectivosData efectivosAlta,
            EfectivosData efectivosBaja
    ) {

        List<BarChartData> barChartData = new ArrayList<>();

        BarChartData alta = new BarChartData(
                "Alta",
                new ArrayList<>(
                        Arrays.asList(
                                new ChartData(efectivosAlta.getOficialSuperior(), "Of. Sup."),
                                new ChartData(efectivosAlta.getOficialJefe(), "Of. J."),
                                new ChartData(efectivosAlta.getOficialSubalterno(), "Of. Sub."),
                                new ChartData(efectivosAlta.getSuboficialSuperior(), "Sub. Sup."),
                                new ChartData(efectivosAlta.getSuboficialSubalterno(), "Sub. Sub."),
                                new ChartData(efectivosAlta.getSoldadoVoluntario(), "Sol. Vol."),
                                new ChartData(efectivosAlta.getAgenteCivil(), "Ag. Civ."))));
        barChartData.add(alta);

        BarChartData baja = new BarChartData(
                "Baja",
                new ArrayList<>(
                        Arrays.asList(
                                new ChartData(-efectivosBaja.getOficialSuperior(), "Of. Sup."),
                                new ChartData(-efectivosBaja.getOficialJefe(), "Of. J."),
                                new ChartData(-efectivosBaja.getOficialSubalterno(), "Of. Sub."),
                                new ChartData(-efectivosBaja.getSuboficialSuperior(), "Sub. Sup."),
                                new ChartData(-efectivosBaja.getSuboficialSubalterno(), "Sub. Sub."),
                                new ChartData(-efectivosBaja.getSoldadoVoluntario(), "Sol. Vol."),
                                new ChartData(-efectivosBaja.getAgenteCivil(), "Ag. Civ."))));
        barChartData.add(baja);

        return barChartData;

    }

    protected List<ChartData> getChartListData(
            Integer alta,
            Integer baja) {

        List<ChartData> chartDataAlta = new ArrayList<>();

        chartDataAlta.add(new ChartData(alta, "Disponible"));
        chartDataAlta.add(new ChartData(baja, "Faltante"));

        return chartDataAlta;

    }

}
