package operations;

import java.util.Scanner;
import repository.Hotel;

public class Main {
	
	private static Scanner KB = new Scanner(System.in);
	
	public static void main(String[] args) {

		Operation.welcome();
		
		boolean exit = false;
		while(!exit) {
			
			System.out.println();
			System.out.println("1. Mostrar habitaciones");
			System.out.println("2. Mostrar reservas");
			System.out.println("3. Crear reserva");
			System.out.println("4. Añadir habitacion a reserva");
			System.out.println("5. Crear reserva aleatoria por fecha y numero de personas");
			System.out.println("6. Salir");
			
			System.out.print("Selecciona: ");
			int option = KB.nextInt();	KB.nextLine();
			
			switch(option) {
			
				case 1->
					Operation.printRooms();
					
				case 2->
					Operation.printReservations();
					
				case 3->
					Operation.bookRoom();
					
				case 4->
					Operation.linkRoomToReservation();
					
				case 5->
					Operation.bookRoomByDateAndNumberOfGuests();
				
				case 6->{
					System.err.println("またねー　( ́⌒ .̫ ⌒ ̀)੭");
					exit = true;
					
				}default ->
					System.err.println("No hay opcion disponible");
					
			}
			System.out.println();
		}
		
	}

}
