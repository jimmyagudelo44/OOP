package t13;

import java.util.Scanner;

class CoffeeMachine {

	double capMax;
	double currentCap;
	
	Scanner KB = new Scanner(System.in);
	
	CoffeeMachine() {
		do {
			System.out.print("Introduce la capacidad maxima de la cafetera: ");
			capMax = KB.nextDouble();
			System.out.print("Introduce la cantidad actual de cafe: ");
			currentCap = KB.nextDouble();
			if(capMax<currentCap || capMax<=0 || currentCap<0)
				System.err.println("ERROR. Las cantidades no son realistas. Intentelo de nuevo");
		}while(capMax<currentCap || capMax<=0 || currentCap<0);
	}
	
	void full() {
		currentCap = capMax;
	}
	
	void empty() {
		currentCap = 0;
	}
	/**
	 * 
	 * @param cup
	 * capacidad maxima de la taza que se quiere rellenar
	 * @return
	 * el cafe que se ha podido rellenar en la taza
	 * tambien resta el cafe que se ha metido a la taza
	 */
	double serve(double cupMax) {
		double currentCapAux = currentCap;
		if(cupMax>= currentCap) {
			currentCap = 0;
			return currentCapAux;
		}else {
			currentCap -= cupMax;
			return cupMax;
		}
	}
	
	/**
	 * 
	 * @param quantity
	 * el cafe que tiene el recipiente
	 * @return
	 * el cafe que ha quedado dentro del recipiente
	 * Tambien suma el cafe que se ha metido a la cafetera
	 */
	double add(double quantity) {
		if(capMax-currentCap>=quantity) {
			currentCap += quantity;
			quantity = 0;
		}else {
			quantity = quantity-(capMax-currentCap);
			currentCap = capMax;
		}
		return quantity;
	}
}
