package t13;

import java.util.Scanner;

class MainCoffee {

	public static void main(String[] args) {
	
		Scanner KB = new Scanner(System.in);
		
		CoffeeMachine cafe = new CoffeeMachine();
		System.out.println();
		
		boolean exit = false;
		
		while(!exit) {
			
			System.out.println("Capacidad maxima de la cafetera: "+cafe.capMax+"L");
			System.out.println("Capacidad actual de la cafetera: "+cafe.currentCap+"L");
			System.out.println("1.Servir taza");
			System.out.println("2.Agregar cafe");
			System.out.println("3.Llenar cafetera");
			System.out.println("4.Vaciar cafetera");
			System.out.println("5.Salir");
			System.out.print("Introduce una opcion: ");
			int option = KB.nextInt();
			
			switch(option) {
				case 1 -> {
					
					System.out.print("Introduce la capacidad maxima de la taza: ");
					double cupMax;
					while((cupMax = KB.nextDouble())<0) 
						System.err.println("ERROR. La cantidad no puede ser menor a 0. "
								+ "Intentelo de nuevo");
					double cup = cafe.serve(cupMax);
					if(cup==cupMax)
						System.out.println("Se ha llenado la taza");
					else
						System.out.println("Cafe que se ha podido meter a la taza: "+cup+"L");
					System.out.println();
					
				}case 2 -> {
					
					System.out.print("Introduce la cantidad del cafe que tiene el recipiente: ");
					double recipient;
					while((recipient = KB.nextDouble())<0)
						System.err.println("ERROR. El tamaño del recipiente no puede ser"
								+ "menor que 0");
					recipient = cafe.add(recipient);
					if(recipient==0)
						System.out.println("Se ha vaciado el recipiente");
					else
						System.out.println("Cafe que queda en el recipiente: "+recipient);
					System.out.println();
					
				}case 3 -> {
					cafe.full();
					System.out.println();
				}case 4 -> {
					cafe.empty();
					System.out.println();
				}case 5 -> {
					exit = true;
					System.err.println("FINALIZANDO PROGRAMA. Hasta luego");
					System.out.println();
				}default -> {
					System.err.println("ERROR. El numero no entra dentro de las opciones."
							+ "Intentelo de nuevo");
				}
			}
		}
	}
	
}
