package ar.mil.cideso.charts;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public abstract class CidesoChart {

    protected String chartTitle;

    public CidesoChart(
            String chartTitle
    ) {

        this.chartTitle = chartTitle;

    }

    protected abstract Node getChart();

    protected Node wrapInCard(
            String cardTitle,
            Node content
    ) {

        VBox mainCard = new VBox();

        // Card Title
        HBox titleBox = new HBox();
        titleBox.setPadding(new Insets(12, 10, 12, 30));
        titleBox.setStyle("-fx-background-color: #dcdbdb;");
        Text label = new Text();
        label.setText(cardTitle);
        label.setFill(Color.color(0.5,0.5,0.6));
        label.setFont(Font.font(null, FontWeight.BOLD, 14));
        titleBox.getChildren().add(label);

        mainCard.getChildren().add(titleBox);
        mainCard.getChildren().add(content);
        mainCard.setStyle("-fx-background-color: #f5efef;");
        mainCard.setEffect(new DropShadow(15, Color.GRAY));

        return mainCard;

    }

}
