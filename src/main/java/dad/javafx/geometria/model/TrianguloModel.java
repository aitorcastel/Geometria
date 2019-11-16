package dad.javafx.geometria.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyDoubleWrapper;
import javafx.beans.property.SimpleDoubleProperty;

public class TrianguloModel {
	private DoubleProperty base;
	private DoubleProperty altura;
	private ReadOnlyDoubleWrapper area;
	private ReadOnlyDoubleWrapper perimetro;

	public TrianguloModel(Double base, Double altura) {
		this.base = new SimpleDoubleProperty(this, "base", base);
		this.altura = new SimpleDoubleProperty(this, "altura", altura);
		this.area = new ReadOnlyDoubleWrapper(this, "area");
		this.area.bind(this.base.multiply(this.altura).divide(2));
		
		// como nuestro triangulo es equilatero
		this.perimetro = new ReadOnlyDoubleWrapper(this, "perimetro");
		this.perimetro.bind(this.base.multiply(3));
		
	}

	public TrianguloModel() {
		this(0.0, 0.0);
	}

	public DoubleProperty baseProperty() {
		return this.base;
	}

	public double getBase() {
		return this.baseProperty().get();
	}

	public void setBase(final double base) {
		this.baseProperty().set(base);
	}

	public DoubleProperty alturaProperty() {
		return this.altura;
	}

	public double getAltura() {
		return this.alturaProperty().get();
	}

	public void setAltura(final double altura) {
		this.alturaProperty().set(altura);
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
