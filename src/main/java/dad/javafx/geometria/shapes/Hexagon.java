package dad.javafx.geometria.shapes;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.shape.Polygon;

public class Hexagon extends Polygon {

	private static final int SIDES = 6;

	private DoubleProperty radius;

	public Hexagon(double radius) {
		super();
		this.radius = new SimpleDoubleProperty(this, "radius");
		this.radius.addListener((o, ov, nv) -> init(nv.doubleValue()));
		this.radius.set(radius);
	}

	public Hexagon() {
		this(0.0);
	}
	
	private void init(double radius) {
		getPoints().clear();
		for (int i = 0; i < SIDES; i++) {
			double x = radius + radius * Math.cos(i * 2 * Math.PI / SIDES);
			double y = radius + radius * Math.sin(i * 2 * Math.PI / SIDES);
			getPoints().addAll(x, y);
		}
	}

	public DoubleProperty radiusProperty() {
		return this.radius;
	}

	public double getRadius() {
		return this.radiusProperty().get();
	}

	public void setRadius(final double radius) {
		this.radiusProperty().set(radius);
	}

}
