package t12;

class Circle {

	double radius;

	double perimeter() {
		return Math.PI*radius*2;
	}
	
	double area() {
		return Math.PI*(radius*radius);
	}
}
