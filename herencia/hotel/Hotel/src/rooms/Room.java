package rooms;

public class Room {

	protected int roomNumber;
	protected int bedCounter;
	protected double pricePerNight;
	
	public Room(int roomNumber, int bedCounter, double pricePerNight) {
		this.roomNumber = roomNumber;
		this.bedCounter = bedCounter;
		this.pricePerNight = pricePerNight;
	}
	
	public int getRoomNumber() {
		return roomNumber;
	}
	
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	public int getBedCounter() {
		return bedCounter;
	}

	public void setBedCounter(int bedCounter) {
		this.bedCounter = bedCounter;
	}

	public double getPricePerNight() {
		return pricePerNight;
	}

	public void setPricePerNight(double pricePerNight) {
		this.pricePerNight = pricePerNight;
	}

	@Override
	public boolean equals(Object o) {
		if(roomNumber == ((Room)o).getRoomNumber())
			return true;
		else
			return false;
	}
	
	@Override
	public String toString() {
		return "Room [roomNumber=" + roomNumber + ", bedCounter=" + bedCounter + ", pricePerNight=" + pricePerNight
				+ "€]";
	}

	public int spotAvaible() {
		return bedCounter;
	}
	
}
