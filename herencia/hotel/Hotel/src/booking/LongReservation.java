package booking;

import java.time.LocalDate;
import rooms.Room;

public class LongReservation extends Reservation{
	
	private LocalDate checkout;
	
	public LongReservation(LocalDate checkin, Room[] room, int guestCounter, LocalDate checkout) {
		super(checkin, room, guestCounter);
		this.checkout = checkout;
	}
	
	@Override
	public boolean checkDate(LocalDate date) {
		return false;
		//to do
	}

}
