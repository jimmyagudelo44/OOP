package function;

import repository.DeliveryRepository;
import shipping.*;
import java.util.Scanner;

public class DeliveryCentral {
	
	private static Scanner KB = new Scanner(System.in);
	private static int code = 0;
	
	public static void listDeliveries() {
		DeliveryRepository.printDeliveries();
	}
	
	public static double totalCost() {
		return DeliveryRepository.totalCost();
	}
	
	public static double insuranceCost() {
		return DeliveryRepository.totalCost();
	}
	
	public static void updateState(State state, int code) {
		DeliveryRepository.updateState(state, code);
	}

	public static void createDelivery() {
		
		System.out.print("Introduce el peso: ");
		double weight = KB.nextDouble();	KB.nextLine();
		System.out.print("Introduce el origen: ");
		String origin = KB.nextLine();
		System.out.print("Introduce el destino: ");
		String destiny = KB.nextLine();
		
		boolean exit = false;
		while(!exit) {
			
			Graphic.deliveryType();
			System.out.print("Selecciona: ");
			int option = KB.nextInt();
			switch(option) {
				case 1->{
					DeliveryRepository.createDelivery(
							createStandardDelivery(code++, weight, origin, destiny)); 
					exit = true;
				}case 2->{
					DeliveryRepository.createDelivery(
							createUrgentDelivery(code++, weight, origin, destiny)); 
					exit = true;
				}case 3->{
					DeliveryRepository.createDelivery(
							createFrozenDelivery(code++, weight, origin, destiny)); 
					exit = true;
				}default ->
					System.err.println("Opcion no valida");
			}
		}
		System.out.println("Nuevo envio creado: ");
		System.err.println(DeliveryRepository.delivery[code-1]);
	}
	
	private static StandardDelivery createStandardDelivery(int code,
			double weight, String origin, String destiny) {
		
		System.out.print("Introduce el numero de dias estimados: ");
		int estimatedDays = KB.nextInt();	KB.nextLine();
		return new StandardDelivery(code, weight, origin, destiny, estimatedDays);
	}
	
	private static UrgentDelivery createUrgentDelivery(int code, 
			double weight, String origin, String destiny) {
		
		System.out.print("Introduce el coste extra: ");
		double extraCost = KB.nextDouble();	KB.nextLine();
		return new UrgentDelivery(code++, weight, origin, destiny, extraCost);
	}
	
	private static FrozenDelivery createFrozenDelivery(int code,
			double weight, String origin, String destiny) {
		
		System.out.print("Introduce la temperatura: ");
		double temperature = KB.nextDouble();	KB.nextLine();
		return new FrozenDelivery(code++, weight, origin, destiny, temperature);
	}
	
	public static void printDeliveries() {
		listDeliveries();
	}
	
	public static void printTotalCost() {
		System.err.println("Coste total de los envios: "+DeliveryRepository.totalCost()+"€");
	}

	public static void printInsuranceTotalCost() {
		System.err.println("Coste total de los seguros de los envios: "+DeliveryRepository.insuranceCost()+"€");
	}

	public static void updateDelivery() {
		int codeSearch;
		do {
			
			listDeliveries();
			System.out.print("Selecciona el codigo del pedido que quieras modificar: ");
			codeSearch = KB.nextInt();	KB.nextLine();
			
			if(!DeliveryRepository.searchDelivery(codeSearch))
				System.err.println("No hay ningun pedido con ese codigo");
		}while(!DeliveryRepository.searchDelivery(codeSearch));
		
		System.out.print("Introduce el nuevo peso: ");
		double weight = KB.nextDouble();	KB.nextLine();
		System.out.print("Introduce el nuevo origen: ");
		String origin = KB.nextLine();
		System.out.print("Introduce el nuevo destino: ");
		String destiny = KB.nextLine();
		
		Delivery d = null;
		
		Graphic.deliveryType();
		int option;
		do {
			System.out.print("Selecciona: ");
			option = KB.nextInt();
			switch(option) {
				case 1->
					d = createStandardDelivery(codeSearch, weight, origin, destiny);
				case 2->
					d = createUrgentDelivery(codeSearch, weight, origin, destiny);
				case 3->
					d = createFrozenDelivery(codeSearch, weight, origin, destiny);
				default->{
					option = -1;
					System.err.println("Opcion no disponible");
				}
			}
		}while(option == -1);
		
		State state = null;
		if(DeliveryRepository.readDelivery(codeSearch) instanceof TrackableDelivery)
			state = ((TrackableDelivery) DeliveryRepository.readDelivery(codeSearch)).getState();
		DeliveryRepository.updateDelivery(d);
		if(DeliveryRepository.readDelivery(codeSearch) instanceof TrackableDelivery)
			((TrackableDelivery) DeliveryRepository.readDelivery(codeSearch)).setState(state);
		
		System.out.println("Envio con codigo "+codeSearch+" actualizado: ");
		System.err.println(d);
	}
	
	static void updateState() {
		
		int codeSearch;
		do {
			
			printDeliveries();
			System.out.print("Introduce el codigo del pedido que quieras cambiar: ");
			codeSearch = KB.nextInt();	KB.nextLine();
			
			if(!DeliveryRepository.searchDelivery(codeSearch))
				System.err.println("No hay ningun pedido con ese codigo");
		}while(!DeliveryRepository.searchDelivery(codeSearch));
		
		State state;
		do {
			System.out.print("Introduce el nuevo estado del envio (Creado, enviado, recibido, "
					+ "devuelto): ");
			state = State.readState();
			if(state == null)
				System.err.println("Estado incorrecto");
		}while(state == null);
		
		DeliveryRepository.updateState(state, codeSearch);
		System.out.println("Estado del envio con codigo "+codeSearch+" cambiado: ");
		System.err.println(DeliveryRepository.readDelivery(codeSearch));
	}
	
}
