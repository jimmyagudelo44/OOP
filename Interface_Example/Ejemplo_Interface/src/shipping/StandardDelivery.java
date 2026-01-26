package shipping;

public class StandardDelivery extends TrackableDelivery {

	private int estimatedDays;

	public StandardDelivery(int code, double weight, String origin, String destiny, int estimatedDays) {
		super(code, weight, origin, destiny);
		this.estimatedDays = estimatedDays;
	}
	
	public int getEstimatedDays() {
		return estimatedDays;
	}


	public void setEstimatedDays(int estimatedDays) {
		this.estimatedDays = estimatedDays;
	}


	public State getState() {
		return state;
	}


	public void setState(State state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "StandardDelivery [estimatedDays=" + estimatedDays + ", state=" + state + ", code=" + code + ", weight="
				+ weight + "kg, origen=" + origin + ", destiny=" + destiny + "]";
	}

	@Override
	public double totalCost() {
		return estimatedDays <= 2? 3 + 1.2*weight + 2.5 : 3 + 1.2*weight;
	}
	
}
