package t14;

import java.util.Scanner;

class Point {

	Scanner KB = new Scanner(System.in);
	
	double x;
	double y;
	
	Point(){
		System.out.print("Introduce la coordenada x: ");
		x = KB.nextDouble();
		System.out.print("Introduce la coordenada y: ");
		y = KB.nextDouble();
	}
	
	double distance(Point punto) {
		return Math.sqrt(Math.pow(x-punto.x, 2)
				+Math.pow(y-punto.y, 2));
	}
	
}
