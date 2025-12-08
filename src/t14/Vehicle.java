package t14;

import java.util.Scanner;

class Vehicle {

	Scanner KB = new Scanner(System.in);
	
	double cost;
	
	Vehicle(){
		System.out.print("Introduce el costo por km: ");
		cost = KB.nextDouble();
	}
	
	double route(Point[] punto) {
		double distance = 0;
		for(int i = 0 ; i<punto.length-1 ; i++)
			distance += punto[i].distance(punto[i+1]);
		return distance;
	}
	
}
