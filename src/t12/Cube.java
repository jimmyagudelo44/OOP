package t12;

class Cube {

	double side;

	double surface() {
		return 6*(side*side);
	}
	
	double volume() {
		return Math.pow(side, 3);
	}
}
