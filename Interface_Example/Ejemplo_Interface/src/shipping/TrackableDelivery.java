package shipping;

public abstract class TrackableDelivery extends Delivery{
	
	protected State state = State.CREADO;

	public TrackableDelivery() {
		super();
	}

	public TrackableDelivery(int code, double weight, String origin, String destiny) {
		super(code, weight, origin, destiny);
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public State obtainState() {
		return state;
	}
	
	public void updateState(State state) {
		this.state = state;
	}
	
	public abstract double totalCost();

}
