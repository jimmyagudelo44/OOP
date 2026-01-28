package figuraGeometrica;

class Triangle extends Figure{

	private double side1;
	private double side2;
	private double side3;
	
	Triangle(String name, int sideNumber, double side1, double side2, double side3){
		super(name, sideNumber);
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
		this.sideNumber = 3;
	}

	double getSide1() {
		return side1;
	}

	void setSide1(double side1) {
		this.side1 = side1;
	}

	double getSide2() {
		return side2;
	}

	void setSide2(double side2) {
		this.side2 = side2;
	}

	double getSide3() {
		return side3;
	}

	void setSide3(double side3) {
		this.side3 = side3;
	}

	@Override
	public String toString() {
		return "Triangle [side1=" + side1 + ", side2=" + side2 + ", side3=" + side3 + "]";
	}
	
	double perimeter(){
		return side1+side2+side3;
	}
	
	double area() {
		return Math.sqrt(perimeter() * (perimeter()-side1) * (perimeter()-side2) * (perimeter()-side3));
	}
	
}
