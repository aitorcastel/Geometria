package dad.javafx.geometria.shapes;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.shape.Polygon;

public class Triangle extends Polygon {

	private DoubleProperty base;
	private DoubleProperty height;

	public Triangle(double base, double height) {
		super();
		this.base = new SimpleDoubleProperty(this, "base", base);
		this.height = new SimpleDoubleProperty(this, "height", height);
		
		this.base.addListener((o, ov, nv) -> init());
		this.height.addListener((o, ov, nv) -> init());
	}

	public Triangle() {
		this(0, 0);
	}
	
	private void init() {
		getPoints().clear();
		getPoints().addAll(base.get() / 2, 0.0);
		getPoints().addAll(0.0, height.get());
		getPoints().addAll(base.get(), height.get());
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

	public DoubleProperty heightProperty() {
		return this.height;
	}

	public double getHeight() {
		return this.heightProperty().get();
	}

	public void setHeight(final double height) {
		this.heightProperty().set(height);
	}

}
