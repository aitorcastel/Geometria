package dad.javafx.geometria.controllers;

import dad.javafx.geometria.model.CirculoModel;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.converter.NumberStringConverter;

public class CirculoController extends VBox {
	
	// view
	
	private TextField radioText;
	
	private Label areaLabel;
	private Label perimetroLabel;
	
	private Circle circleShape;
	
	// model
	
	//private DoubleProperty radio = new SimpleDoubleProperty(20);
	private CirculoModel circuloModel = new CirculoModel(20.0);
	

	public CirculoController() {
		super();
		
		radioText = new TextField();
		
		HBox radioBox = new HBox(5, new Label("Radio:"), radioText);
		radioBox.setAlignment(Pos.BASELINE_CENTER);
		
		circleShape = new Circle();
		circleShape.setFill(Color.RED);
		circleShape.setStroke(Color.DARKBLUE);
		circleShape.setStrokeWidth(2);
		
		// area y perimetro añadido
		
		areaLabel = new Label("[?] Sin definir");
		HBox areaBox = new HBox(5, new Label("Área:"), areaLabel);
		areaBox.setAlignment(Pos.BASELINE_CENTER);
		
		perimetroLabel = new Label("[?] Sin definir");
		HBox perimetroBox = new HBox(5, new Label("Perímetro:"), perimetroLabel);
		perimetroBox.setAlignment(Pos.BASELINE_CENTER);
		
		// ----------------------------------------------
		
		this.setSpacing(5);
		this.setAlignment(Pos.TOP_CENTER);
		this.getChildren().addAll(radioBox, circleShape, areaBox, perimetroBox);
		this.setPadding(new Insets(5));
		
		// bindeo modelo y vista 
		
		radioText.textProperty().bindBidirectional(circuloModel.radioProperty(), new NumberStringConverter());
		//radioText.textProperty().bindBidirectional(radio, new NumberStringConverter());
		//circleShape.radiusProperty().bind(radio);	
		circleShape.radiusProperty().bind(circuloModel.radioProperty());
		
		//areaLabel.textProperty().bind(circuloModel.areaProperty().asString());
		//perimetroLabel.textProperty().bind(circuloModel.perimetroProperty().asString());
		
		// con valores truncados 
		
		areaLabel.textProperty().bind(Bindings.format("%,.2f",circuloModel.areaProperty()));
		perimetroLabel.textProperty().bind(Bindings.format("%,.2f", circuloModel.perimetroProperty()));
		
		
	}
	
}
