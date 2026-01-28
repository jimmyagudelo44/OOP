package figuraGeometrica;

class Circle extends Figure{
	
	private double radius;

	Circle(String name, int sideNumber, double radius) {
		super(name, sideNumber);
		this.radius = radius;
		this.sideNumber = 1;
	}

	double getRadius() {
		return radius;
	}

	void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public String toString() {
		return "circle [radius=" + radius + "]";
	}
	
	double perimeter() {
		return 2*Math.PI*radius;
	}
	
	double area() {
		return Math.PI*radius*radius;
	}
	
}
