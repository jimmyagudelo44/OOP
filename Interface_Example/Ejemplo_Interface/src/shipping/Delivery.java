package shipping;

public abstract class Delivery {

	protected int code;
	protected double weight;
	protected String origin;
	protected String destiny;
	
	public Delivery(int code, double weight, String origin, String destiny) {
		this.code = code;
		this.weight = weight;
		this.origin = origin;
		this.destiny = destiny;
	}

	public Delivery() {
		
	}
	
	public int getCode() {
		return code;
	}
	
	public void setCode(int code) {
		this.code = code;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public String getDestiny() {
		return destiny;
	}
	
	public void setDestiny(String destiny) {
		this.destiny = destiny;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	@Override
	public String toString() {
		return "Delivery [code=" + code + ", weight=" + weight + "kg, destiny=" + destiny + "]";
	}

	@Override
	public boolean equals(Object o) {
		if(((Delivery)o).getCode() == code)
			return true;
		else
			return false;
	}
	
	public abstract double totalCost();
	
}
