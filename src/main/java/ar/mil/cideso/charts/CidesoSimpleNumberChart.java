package ar.mil.cideso.charts;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class CidesoSimpleNumberChart extends CidesoChart {

    private final String value;

    public CidesoSimpleNumberChart(
            String chartTitle,
            String value) {

        super(chartTitle);

        this.value = value;

    }

    @Override
    public Node getChart() {

        VBox textContainer = new VBox();

        Text text = new Text();
        text.setText(value);
        text.setStroke(null);
        text.setFill(Color.BLACK);
        text.setFont(Font.font ("Verdana", 40));

        textContainer.getChildren().add(text);
        textContainer.setAlignment(Pos.CENTER);
        textContainer.setFillWidth(true);
        textContainer.setPadding(new Insets(70,10,10,10));

        return wrapInCard(
                chartTitle,
                textContainer);

    }

}
