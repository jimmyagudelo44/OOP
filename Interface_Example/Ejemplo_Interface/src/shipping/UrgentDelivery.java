package shipping;

import interfaces.Insurable;

public class UrgentDelivery extends TrackableDelivery implements Insurable {

	private double extraCharge;
	
	public UrgentDelivery(int code, double weight, String origin, String destiny, double extraCharge) {
		super(code, weight, origin, destiny);
		this.extraCharge = extraCharge;
	}

	public UrgentDelivery() {
		
	}
	
	public double getExtraCharge() {
		return extraCharge;
	}

	public void setExtraCharge(double extraCharge) {
		this.extraCharge = extraCharge;
	}

	@Override
	public String toString() {
		return "UrgentDelivery [extraCharge=" + extraCharge + "€, state=" + state + ", code=" + code + ", weight="
				+ weight + "kg, origen=" + origin + ", destiny=" + destiny + "]";
	}

	@Override
	public double totalCost() {
		return 5 + 2*weight + extraCharge;
	}
	
	@Override
	public double insuranceCost() {
		return 1.5 + weight * 0.8;
	}
	
}
