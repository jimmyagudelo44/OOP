package shipping;

import interfaces.Insurable;

public class FrozenDelivery extends Delivery implements Insurable {

	private double temperature;

	public FrozenDelivery(int code, double weight, String origin, String destiny, double temperature) {
		super(code, weight, origin, destiny);
		this.temperature = temperature;
	}
	
	public FrozenDelivery() {

	}
	
	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	@Override
	public String toString() {
		return "FrozenDelivery [temperature=" + temperature + "º, code=" + code + ", weight=" + weight + "kg, origen="
				+ origin + ", destiny=" + destiny + "]";
	}

	@Override
	public double totalCost() {
		return temperature < 0? 6 + 2.5*weight + 4 : 6 + 2.5*weight;
	}

	@Override
	public double insuranceCost() {
		return 1.5 + weight * 0.8;
	}
	
}
