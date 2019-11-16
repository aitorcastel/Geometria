package dad.javafx.geometria.controllers;

import dad.javafx.geometria.model.HexagonoModel;
import dad.javafx.geometria.shapes.Hexagon;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.converter.NumberStringConverter;

public class HexagonoController extends VBox {
	
	// view
	
	private TextField radioText;
	private Hexagon hexagonShape;
	
	private Label areaLabel, perimetroLabel;
	
	// model
	
	//private DoubleProperty radio = new SimpleDoubleProperty(20);
	private HexagonoModel hexagonoModel = new HexagonoModel(20.0);

	public HexagonoController() {
		super();
		
		radioText = new TextField();
		
		HBox radioBox = new HBox(5, new Label("Apotema:"), radioText);
		radioBox.setAlignment(Pos.BASELINE_CENTER);
		
		// area y perimetro añadido
		
		areaLabel = new Label("[?] Sin definir");
		HBox areaBox = new HBox(5, new Label("Área:"), areaLabel);
		areaBox.setAlignment(Pos.BASELINE_CENTER);
		
		perimetroLabel = new Label("[?] Sin definir");
		HBox perimetroBox = new HBox(5, new Label("Perímetro:"), perimetroLabel);
		perimetroBox.setAlignment(Pos.BASELINE_CENTER);
		
		hexagonShape = new Hexagon();
		hexagonShape.setFill(Color.RED);
		hexagonShape.setStroke(Color.DARKBLUE);
		hexagonShape.setStrokeWidth(2);
		
		this.setSpacing(5);
		this.setAlignment(Pos.TOP_CENTER);
		this.getChildren().addAll(radioBox, hexagonShape, areaBox, perimetroBox);
		this.setPadding(new Insets(5));
		
		// bindeo modelo y vista 
		radioText.textProperty().bindBidirectional(hexagonoModel.apotemaProperty(), new NumberStringConverter());
		hexagonShape.radiusProperty().bind(hexagonoModel.apotemaProperty());	
		
		areaLabel.textProperty().bind(Bindings.format("%,.2f",hexagonoModel.areaProperty()));
		perimetroLabel.textProperty().bind(Bindings.format("%,.2f", hexagonoModel.perimetroProperty()));
		
		
	}
	
}
