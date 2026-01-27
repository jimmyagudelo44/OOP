package operations;

import repository.*;
import java.util.Scanner;

import booking.Reservation;
import rooms.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Operation {
	
	private static Scanner KB = new Scanner(System.in);

	public static void welcome() {
		System.err.println("Hell's Hotel (HH)");
		
		System.out.println("1. Generar tu mismo las habitaciones");
		System.out.println("2. Generar automaticamente habitaciones aleatorias");
		System.out.print("Seleciona: ");
		int select = KB.nextInt();	KB.nextLine();
		switch(select) {
			case 1->
				Operation.buildHotel();
			case 2->
				Operation.RandomHotel();
		}
	}
	
	public static void buildHotel() {
		
		int roomNumber = 0; 
		System.out.print("Introduce el numero de habitaciones que vas a meter");
		int roomCounter = KB.nextInt();
		
		Hotel.initializeRooms(roomCounter);
		
		for(int i = 0 ; i<Hotel.room.length ; i++) {
			
			System.out.print("Introduce el numero de camas: ");
			int bedCounter = KB.nextInt();
			
			System.out.print("Introduce el precio por noche: ");
			double pricePerNight = KB.nextDouble();	KB.nextLine();
			
			Hotel.room[i] = new Room(roomNumber++, bedCounter, pricePerNight);
		}
	}

	public static void RandomHotel() {
		System.out.print("Introduce el numero de habitaciones que quieres generar: ");
		int roomCounter = KB.nextInt();	KB.nextLine();
		Hotel.randomRoomGenerator(roomCounter);
	}

	public static void bookRoom() {
		
		System.out.print("Introduce la fecha (dd/MM/yyyy): ");
		LocalDate date;
		do {
			
			date = LocalDate.parse(dateCorrect(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			
			if(!Hotel.anyRoomAvaibleOnDate(date))
				System.err.println("No hay habitaciones disponibles en la fecha escrita");
		}while(!Hotel.anyRoomAvaibleOnDate(date));
		
		System.out.print("Introduce el numero de personas: ");
		int guestCounter = KB.nextInt();
		
		Hotel.createReservation(new Reservation(date, guestCounter));
	}
	
	private static String dateCorrect() {
		
		String word;
		boolean wrong = true;
		
		do {
			
			word = KB.nextLine();
			
			if(word.length() == 10) {
				
				for(int i = 0 ; i<word.length() ; i++)
					if(i != 2 && i!=5 && word.charAt(i) >= 48 || word.charAt(i) <= 57)
						wrong = false;
				
				if(word.charAt(2) == 47 && word.charAt(5) == 47)
					wrong = false;
				else
					wrong = true;
				
				if(!wrong) {
					
					String day = ""+word.charAt(0)+word.charAt(1);
					String month = ""+word.charAt(3)+word.charAt(4);
//					String year = ""+word.charAt(6)+word.charAt(7)+word.charAt(8)+word.charAt(9);
					
					if(Integer.parseInt(day) > 31 || Integer.parseInt(month) > 12)
						wrong = true;
				}
			}
			
			if(wrong)
				System.err.println("Formato de edad erroneo");
		}while(wrong);
		
		return word;
	}

	public static void printRooms() {
		Hotel.printAllRooms();
	}

	public static void printReservations() {
		Hotel.printAllReservations();
	}

	public static void linkRoomToReservation() {
		
		Hotel.printReservationsWithPosition();
		
		System.out.print("Introduce la posicion de la reserva a la que le quieras vincular la habitacion: ");
		int position;
		do {
			position = KB.nextInt();	KB.nextLine();
			
			if(Hotel.reservation.length == 1? position!=0 : position<0 || position > Hotel.reservation.length-1)
				System.err.println("Posicion no valida");
		}while(Hotel.reservation.length == 1? position!=0 : position<0 || position > Hotel.reservation.length-1);
		
		printRooms();
		
		System.out.print("Selecciona el numero de la habitacion que quieras vincular: ");
		int roomNumber;
		boolean fit;
		do {
			roomNumber = KB.nextInt();
			fit = true;
			
			if(!Hotel.roomExist(roomNumber))
				System.err.println("No hay ninguna habitacion con ese numero");
			else if(Hotel.readRoom(roomNumber).spotAvaible() < Hotel.reservation[position].getGuestCounter()) {
				System.err.println("Las personas no caben en esta habitacion, tan golditas");
				fit = false;
			}
		}while(!Hotel.roomExist(roomNumber) 
				|| !fit);
		
		Hotel.reservation[position].createRoom(Hotel.readRoom(roomNumber));
		System.err.println("Habitacion nº"+roomNumber+" añadida a reserva con fecha "
				+Hotel.reservation[position].getDate());
	}

	public static void bookRoomByDateAndNumberOfGuests() {
		System.out.print("Introduce la fecha: (dd/mm/yyyy): ");
		LocalDate date = LocalDate.parse(dateCorrect(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.print("Introduce el numero de personas: ");
		int guestCounter = KB.nextInt();	KB.nextLine();
		
		Hotel.makeReservation(date, guestCounter);
		
		System.err.println("Reserva con fecha "+date+", con habitacion/es: ");
		Hotel.printAllRoomsFromReservation(Hotel.reservation[Hotel.reservation.length-1]);
	}
	
}
