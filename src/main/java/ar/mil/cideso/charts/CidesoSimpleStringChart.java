package ar.mil.cideso.charts;

import ar.mil.cideso.model.enums.CidesoChartColor;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class CidesoSimpleStringChart extends CidesoChart {

    private final String unit;
    private final String value;
    private final CidesoChartColor cidesoChartColor;

    public CidesoSimpleStringChart(
            String chartTitle,
            CidesoChartColor cidesoChartColor,
            String value,
            String unit) {

        super(chartTitle);

        this.unit = unit;
        this.value = value;
        this.cidesoChartColor = cidesoChartColor;

    }

    @Override
    public Node getChart() {

        VBox cardContainer = new VBox();
        cardContainer.setFillWidth(true);
        cardContainer.setAlignment(Pos.CENTER);

        // BODY
        HBox cardBody = new HBox();
        cardBody.setFillHeight(true);
        cardBody.setAlignment(Pos.CENTER);
        VBox.setVgrow(cardBody, Priority.ALWAYS);
        cardBody.setStyle("-fx-background-color: " + this.cidesoChartColor.getRgbPrimaryColor());

        // TEXTO
        Text bodyText = new Text();
        bodyText.setStroke(null);
        bodyText.setText(this.value);
        bodyText.setFill(Color.GRAY);
        bodyText.setFont(Font.font("Verdana", 40));
        cardBody.getChildren().add(bodyText);

        cardContainer.getChildren().add(cardBody);

        // FOOTER
        HBox cardFooter = new HBox();
        Text footerText = new Text();
        footerText.setStroke(null);
        footerText.setFill(Color.GRAY);
        footerText.setText(this.unit);
        footerText.setFont(Font.font("Verdana", 14));
        cardFooter.setMaxHeight(30);
        cardFooter.setFillHeight(true);
        cardFooter.setPadding(new Insets(10, 10, 10, 10));
        cardFooter.setStyle("-fx-background-color: " + this.cidesoChartColor.getRgbSecondaryColor());
        cardFooter.getChildren().add(footerText);
        cardContainer.getChildren().add(cardFooter);

        return wrapInCard(
                this.chartTitle,
                cardContainer);

    }

}
