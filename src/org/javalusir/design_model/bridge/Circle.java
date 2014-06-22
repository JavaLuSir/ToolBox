package org.javalusir.design_model.bridge;

public class Circle implements Shape{
	
	private double x, y, radius;
	private Draw draw;
	
	public Circle(double x, double y, double radius, Draw draw) {

		this.x = x;
		this.y = y;
		this.radius = radius;
		this.draw = draw;
	}

	@Override
	public void draw() {
		draw.drawShape();
		
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public Draw getDraw() {
		return draw;
	}

	public void setDraw(Draw draw) {
		this.draw = draw;
	}
	
}
