package rooms;

public class FamiliarRoom extends Room{

	private int doubleBedCounter;
	
	public FamiliarRoom(int roomNumber, int bedCounter, double pricePerNight, int doubleBedCounter) {
		super(roomNumber, bedCounter, pricePerNight);
		this.doubleBedCounter = doubleBedCounter;
	}

	public int getDoubleBedCounter() {
		return doubleBedCounter;
	}

	public void setDoubleBedCounter(int doubleBedCounter) {
		this.doubleBedCounter = doubleBedCounter;
	}
	
	@Override
	public int spotAvaible() {
		return bedCounter + doubleBedCounter*2;
	}
	
}
