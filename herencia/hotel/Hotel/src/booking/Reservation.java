package booking;

import java.time.LocalDate;
import rooms.*;

public class Reservation {

	protected LocalDate date;
	protected Room[] bookedRoom = new Room[0];
	protected int guestCounter;
	
	public Reservation(LocalDate date, int guestCounter) {
		this.date = date;
		this.guestCounter = guestCounter;
	}
	
	public Reservation(LocalDate date, Room[] bookedRoom, int guestCounter) {
		this.date = date;
		this.bookedRoom = bookedRoom;
		this.guestCounter = guestCounter;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Room[] getBookedRoom() {
		return bookedRoom;
	}

	public void setBookedRoom(Room[] bookedRoom) {
		this.bookedRoom = bookedRoom;
	}

	public int getGuestCounter() {
		return guestCounter;
	}

	public void setGuestCounter(int guestCounter) {
		this.guestCounter = guestCounter;
	}

	@Override
	public boolean equals(Object obj) {
		
		boolean equals = false;
		
		for(int i = 0 ; i < this.bookedRoom.length && !equals ; i++)
			
			for(int c = 0 ; c < ((Reservation)obj).bookedRoom.length && !equals ; c++)
				
				if( this.bookedRoom[i].equals( ((Reservation)obj).getBookedRoom()[c] ) 
						&& this.date.equals( ((Reservation)obj).getDate() ) )
								equals = true;
		return equals;
	}

	@Override
	public String toString() {
		return "Reservation [date=" + date + ", bookedRoom=" + bookedRoom.length + ", guestCounter="
				+ guestCounter + "]";
	}
	
	public boolean checkDate(LocalDate date) {
		if(date.equals(this.date))
			return true;
		else
			return false;
	}
	
	public void createRoom(Room r) {
		Room[] aux = bookedRoom;
		bookedRoom = new Room[aux.length+1];
		for(int i = 0 ; i<aux.length ; i++)
			bookedRoom[i] = aux[i];
		bookedRoom[aux.length] = r;
	}
	
}
