package dad.javafx.geometria.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyDoubleWrapper;
import javafx.beans.property.SimpleDoubleProperty;

public class HexagonoModel {
	private DoubleProperty apotema;

	private ReadOnlyDoubleWrapper area;
	private ReadOnlyDoubleWrapper perimetro;

	public HexagonoModel(Double apotema) {
		this.apotema = new SimpleDoubleProperty(this, "apotema", apotema);
		
		this.area = new ReadOnlyDoubleWrapper(this, "area");
		
		/*
		 * EXPLICACION DE LA FORMULA:
		 * 
		 * En el siguiente ejercicio se nos dispone el cálculo del área de un héxagono que debe ser "geométricamente
		 * simétrico", por lo que en consideración con este punto, tanto la apotema como el lado son considerados iguales.
		 * 
		 * La formula es: A= (P*a)/2 => (6(t)*a)/2
		 * 
		 * A = area
		 * P = perimetro
		 * a = longuitud de la apotema
		 * 6 hace referencia al número de lados
		 * t = longitud de cada lado
		 * 
		 * */
		
		// Esta sería la formula del area extendida
		this.area.bind( ((this.apotema.multiply(6).divide(2)).multiply(this.apotema)).divide(2) );
		
		this.perimetro = new ReadOnlyDoubleWrapper(this, "perimetro");
		this.perimetro.bind(this.apotema.multiply(6));
		
	}

	public HexagonoModel() {
		this(0.0);
	}

	public DoubleProperty apotemaProperty() {
		return this.apotema;
	}

	public double getApotema() {
		return this.apotemaProperty().get();
	}

	public void setBase(final double apotema) {
		this.apotemaProperty().set(apotema);
	}

	public javafx.beans.property.ReadOnlyDoubleProperty areaProperty() {
		return this.area.getReadOnlyProperty();
	}

	public double getArea() {
		return this.areaProperty().get();
	}	
	
	public javafx.beans.property.ReadOnlyDoubleProperty perimetroProperty() {
		return this.perimetro.getReadOnlyProperty();
	}

	public double getPerimetro() {
		return this.perimetroProperty().get();
	}
	
	



}
