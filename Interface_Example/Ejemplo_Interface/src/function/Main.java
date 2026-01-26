package function;

import java.util.Scanner;

import shipping.Delivery;

public class Main {
	
	private static Scanner KB = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.err.println("Brownie's big Deliveries (BBD)");
		
		boolean exit = false;
		while(!exit) {
			
			Graphic.mainMenu();
			System.out.print("Selecciona: ");
			int select = KB.nextInt();	KB.nextLine();
			
			switch(select) {
				case 1->
					DeliveryCentral.createDelivery();
				case 2->
					DeliveryCentral.printDeliveries();
				case 3->
					DeliveryCentral.printTotalCost();
				case 4->
					DeliveryCentral.printInsuranceTotalCost();
				case 5->
					DeliveryCentral.updateDelivery();
				case 6->
					DeliveryCentral.updateState();
				case 7->{
					exit = true;
					System.err.println("XAU <3");
				}default->
					System.err.println("Opcion no valida");
			}
			
		}
		
	}

}
