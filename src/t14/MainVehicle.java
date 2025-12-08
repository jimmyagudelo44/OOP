package t14;

import java.util.Scanner;

class MainVehicle {

	public static void main(String[] args) {
		
		Scanner KB = new Scanner(System.in);

		Vehicle vehiculo = new Vehicle();

		System.out.print("Cuantos puntos tiene tu recorrido: ");
		int route;
		while((route = KB.nextInt())<2)
			System.err.println("ERROR. El recorrido tiene que tener al menos 2 puntos."
					+ "Intentalo de nuevo");
		
		Point[] punto = new Point[route];
		
		for(int i = 0 ; i<route ; i++) {
			System.out.println("Punto "+i);
			punto[i] = new Point();
		}
		
		System.out.println("El coste total de la ruta es de: "
				+(vehiculo.cost*vehiculo.route(punto))+"€");
	}
	
}
