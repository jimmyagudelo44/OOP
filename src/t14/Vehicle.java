package t14;

import java.util.Scanner;

class Vehicle {

	Scanner KB = new Scanner(System.in);
	
	double cost;
	double total;
	
	Vehicle(){
		System.out.print("Introduce el costo por km: ");
		while((cost = KB.nextDouble())<=0)
			System.err.println("ERROR. El costo no puede ser menor que 0. Introducelo de nuevo");
	}
	
	double route(Point[] punto) {
		double distance = 0;
		for(int i = 0 ; i<punto.length-1 ; i++)
			distance += punto[i].distance(punto[i+1]);
		total = cost*distance;
		return distance;
	}
	
}
