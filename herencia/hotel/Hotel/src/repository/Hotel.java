package repository;

import java.time.LocalDate;
import java.util.Arrays;
import booking.Reservation;
import rooms.FamiliarRoom;
import rooms.Room;


public class Hotel {
	
	public static Room[] room = new Room[0];
	public static Reservation[] reservation = new Reservation[0];
	
	public static void createRoom(Room r) {
		Room[] aux = room;
		room = new Room[aux.length+1];
		for(int i = 0 ; i<aux.length ; i++)
			room[i] = aux[i];
		room[aux.length] = r;
	}
	
	public static void createReservation(Reservation r) {
		Reservation[] aux = reservation;
		reservation = new Reservation[aux.length+1];
		for(int i = 0 ; i<aux.length ; i++)
			reservation[i] = aux[i];
		reservation[aux.length] = r;
	}
	
	public static Room readRoom(int roomNumber) {
		boolean found = false;
		Room r = null;
		for(int i = 0 ; i<room.length && !found; i++)
			if(room[i].getRoomNumber() == roomNumber) {
				r = room[i];
				found = true;
			}
		return r;
	}
	
	public static Reservation readReservation(LocalDate date, Room[] bookedRoom) {
		boolean found = false;
		Reservation r = null;
		for(int i = 0 ; i<reservation.length && !found ; i++)
			if(Arrays.equals(reservation[i].getBookedRoom(), bookedRoom) 
					&& reservation[i].getDate().equals(date)) {
				r = reservation[i];
				found = true;
			}
		return r;
	}
	
	public static void updateRoom(int roomNumber, int bedCounter, double pricePerNight) {
		boolean found = false;
		for(int i = 0 ; i<room.length && !found ; i++)
			if(room[i].getRoomNumber() == roomNumber) {
				room[i] = new Room(roomNumber, bedCounter, pricePerNight);
				found = true;
			}
	}
	
	public static void updateReservation(LocalDate date, Room[] bookedRoom, int guestCounter) {
		boolean found = false;
		for(int i = 0 ; i<reservation.length && !found ; i++) 
			if(Arrays.equals(bookedRoom, reservation[i].getBookedRoom()) 
					&& date.equals(reservation[i].getDate()) ) {
				reservation[i] = new Reservation(date, guestCounter);
				found = true;
			}
	}
	
	public static void deleteReservation(Reservation r) {
		Reservation[] aux = new Reservation[reservation.length-1];
		boolean found = false;
		for(int i = 0 ; i<aux.length ; i++) {
			if(reservation[i].equals(r))
				found = true;
			if(!found)
				aux[i] = reservation[i];
			else
				aux[i] = reservation[i+1];
		}
		reservation = aux;
	}
	
	/**
	 * este metodo se debe usar al principio del programa en caso de que se quiera un numero maximo 
	 * de habitaciones distintas al que se ha puesto
	 * @param roomCounter, numero de habitaciones maxima del hotel
	 */
	public static void initializeRooms(int roomCounter) {
		room = new Room[roomCounter];
	}
	
	public static void randomRoomGenerator(int roomCounter) {
		
		initializeRooms(roomCounter);
		
		int roomNumber = 0;
		
		for(int i = 0 ; i<roomCounter ; i++) {
			double pricePerNight = (double) ( (int) (Math.random() * 10000) )/100;
			int rng = (int)(Math.random()*10);
			int bedCounter = rng == 0? 1 : rng;
			room[i] = new Room(roomNumber++, bedCounter, pricePerNight);
		}
	}
	
	public static boolean checkAvailability(LocalDate date, int guestCounter) {
		
		boolean avaible = false;
		
		Room[] aux = roomsAvaibleOnDate(date);
		
		int occupancy = 0;
		for(Room r : aux)
			occupancy += r instanceof FamiliarRoom? r.spotAvaible() : ((FamiliarRoom)r).spotAvaible();
		
		if(aux.length > 0 && occupancy >= guestCounter)
			avaible = true;
			
		return avaible;
	}
	
	public static Room[] roomsBookedOnDate(LocalDate date) {
		Room[] aux = new Room[0];
		for(int i = 0 ; i<reservation.length ; i++)
			if(reservation[i].getDate().equals(date))
				aux = aumentAuxRoomWithArray(aux, reservation[i].getBookedRoom());
		return aux;
	}
	
	public static Room[] roomsAvaibleOnDate(LocalDate date) {
		
		Room[] aux1 = room;
		Room[] aux2 = roomsBookedOnDate(date);
		
		for(int i = 0 ; i<aux1.length ; i++)
			for(int c = 0 ; c<aux2.length ; c++)
				if(aux1[i].equals(aux2[c]))
					aux1 = reduceAuxRoom(aux1, aux2[c]);
		
		return aux1;
	}
	
	private static Room[] aumentAuxRoomWithArray(Room[] r1, Room[] r2) {
		Room[] aux = new Room[r1.length+r2.length];
		boolean limit = false;
		for(int i = 0, j = 0 ; i<aux.length ; i++) {
			if(i == r1.length-1)
				limit = true;
			if(!limit)
				aux[i] = r1[i];
			else
				aux[i] = r2[j++];
		}
		return aux;
	}
	
	private static Room[] aumentAuxRoomWithRoom(Room[] room, Room r) {
		Room[] aux = room;
		room = new Room[aux.length+1];
		for(int i = 0 ; i<aux.length ; i++)
			room[i] = aux[i];
		room[aux.length] = r;
		return room;
	}
	
	private static Room[] reduceAuxRoom(Room[] room, Room r) {
		Room[] aux = new Room[room.length-1];
		boolean found = false;
		for(int i = 0 ; i<aux.length ; i++) {
			if(room[i].equals(r))
				found = true;
			if(!found)
				aux[i] = room[i];
			else
				aux[i] = room[i+1];
		}
		return aux;
	}
	
	public static boolean freeRoom(Room r) {
		boolean found = false;
		for(int i = 0 ; i<reservation.length && !found ; i++)
			for(int c = 0 ; c<reservation[i].getBookedRoom().length && !found ; c++)
				if(reservation[i].getBookedRoom()[c].equals(r))
					found = true;
		return !found;
	}
	
	public static boolean freeRoomOnDate(LocalDate date, Room r) {
		boolean found = false;
		for(int i = 0 ; i<reservation.length ; i++)
			if(reservation[i].getDate().equals(date))
				for(int c = 0 ; c<reservation[i].getBookedRoom().length ; c++)
					if(reservation[i].getBookedRoom()[c].equals(r))
						found = true;
		return !found;
	}
	
	/**
	 * 
	 * @param date
	 * @return Si hay al menos una habitacion en la fecha del parametro, devuelve true
	 */
	public static boolean anyRoomAvaibleOnDate(LocalDate date) {
		boolean found = false;
		for(int i = 0 ; i<room.length && !found ; i++)
			if(freeRoomOnDate(date, room[i]))
				found = true;
		return found;
	}
	
	public static void makeReservation(LocalDate date, int guestCounter) {
		
		Room[] aux1 = roomsAvaibleOnDate(date);
		Room[] aux2 = new Room[0];
		
		int capacity = guestCounter;
		
		for(int i = 0 ; i<aux1.length && capacity>0 ; i++)
			
			if(aux1[i] instanceof FamiliarRoom? capacity - ((FamiliarRoom)aux1[i]).spotAvaible() >= 0 
					: capacity - aux1[i].spotAvaible() >= 0) {
				
				aux2 = aumentAuxRoomWithRoom(aux2, aux1[i]);
				capacity -= aux1[i] instanceof FamiliarRoom? ((FamiliarRoom)aux1[i]).spotAvaible()
						: aux1[i].spotAvaible();
			}
		
		createReservation(new Reservation(date, aux2, guestCounter));
	}
	
	public static void printAllRooms() {
		for(Room r : room)
			System.err.println(r);
	}
	
	public static void printAllRoomsFromReservation(Reservation r) {
		for(Room x : r.getBookedRoom())
			System.err.println(x);
	}
	
	public static void printAllReservations() {
		for(Reservation r : reservation)
			System.err.println(r);
	}
	
	public static void printReservationsWithPosition() {
		int counter = 0;
		for(Reservation r : reservation)
			System.err.println(""+ (counter++)+"º: " + r);
	}
	
	public static boolean roomExist(int roomNumber) {
		boolean found = false;
		for(int i = 0 ; i<room.length && !found ; i++)
			if(room[i].getRoomNumber() == roomNumber)
				found = true;
		return found;
	}
	
}
