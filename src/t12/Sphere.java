package t12;

class Sphere {

	double radius;
	
	double surface() {
		return 4*Math.PI*(radius*radius);
	}
	
	double volume() {
		return (4*Math.PI*(Math.pow(radius, 3)))/3;
	}
}
