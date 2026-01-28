package figuraGeometrica;

class Square extends Figure{

	private double side;

	Square(String name, int sideNumber, double side) {
		super(name, sideNumber);
		this.side = side;
		this.sideNumber = 4;
	}

	double getSide() {
		return side;
	}

	void setSide(double side) {
		this.side = side;
	}

	@Override
	public String toString() {
		return "Square [side=" + side + "]";
	}
	
	double perimeter() {
		return side*4;
	}
	
	double area() {
		return side*side;
	}
	
}
