package ar.mil.cideso.charts;

import ar.mil.cideso.model.ChartData;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.Set;

public class CidesoSimpleNumberChart extends CidesoChart {

    private final String value;

    public CidesoSimpleNumberChart(
            String chartTitle,
            Set<ChartData> chartDataSet) {

        super(chartTitle);

        this.value = this.constructValue(chartDataSet);

    }

    private String constructValue(
            Set<ChartData> chartDataSet) {

        StringBuilder stringBuilder = new StringBuilder();

        chartDataSet.forEach(
                (chartData ->
                        stringBuilder
                                .append(chartData.getValue())
                                .append(" (")
                                .append(chartData.getCategory())
                                .append(" )  "))
        );

        return stringBuilder.toString();

    }

    @Override
    public Node getChart() {

        VBox textContainer = new VBox();

        Text text = new Text();
        text.setText(value);
        text.setStroke(null);
        text.setFill(Color.BLACK);
        text.setFont(Font.font("Verdana", 40));

        textContainer.getChildren().add(text);
        textContainer.setAlignment(Pos.CENTER);
        textContainer.setFillWidth(true);
        textContainer.setPadding(new Insets(70, 10, 10, 10));

        return wrapInCard(
                chartTitle,
                textContainer);

    }

}
