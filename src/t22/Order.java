package t22;

class Order {

	private String description;
	private double price;
	private int code;
	private Client[] costumer;
	private boolean discountApplied;
	
	Order(int code){
		this.code = code;
	}
	
	Order(String description, double price, int code, Client[] costumer){
		this.description = description;
		this.price = price;
		this.code = code;
		this.costumer = costumer;
		discountApplied = false;
	}
	
	String getDescription() {
		return description;
	}
	
	void setDescription(String description) {
		this.description = description;
	}

	double getPrice() {
		return price;
	}

	void setPrice(double price) {
		this.price = price;
	}

	int getCode() {
		return code;
	}

	void setCode(int code) {
		this.code = code;
	}
	
	boolean getDiscountApplied() {
		return discountApplied;
	}
	
	void setDiscountApplied(boolean discountApplied) {
		this.discountApplied = discountApplied;
	}
	
	void modifyDescription(String description) {
		this.description = description;
	}
	
	/**
	 * 
	 * @param percentage porcentaje del descuento que se quiera aplicar
	 */
	void discount(double percentage) {
		price -= (percentage/100)*price; 
	}
	
	String orderToString() {
		if(costumer.length==0)
			return description+", "+price+"€, codigo: "+code;
		else {
			String total = "";
			for(int i = 0 ; i<costumer.length ; i++)
				total += costumer[i].getName()+" || ";
			return description+", "+price+"€, codigo: "+code+", Compradores: "+total;
		}
	}
	
	String orderToStringNoClients() {
		return description+", "+price+"€, codigo: "+code;
	}
	
	void addCostumer(Client costumer) {
		if(this.costumer.length==0) {
			this.costumer = new Client[1];
			this.costumer[0] = costumer;
		}
		else {
			Client[] aux = new Client[this.costumer.length];
			for(int i = 0 ; i<this.costumer.length ; i++)
				aux[i] = this.costumer[i];
			this.costumer = new Client[aux.length+1];
			for(int i = 0 ; i<this.costumer.length-1 ; i++)
				this.costumer[i] = aux[i];
			this.costumer[this.costumer.length-1] = costumer;
		}
	}
	
	int counterCostumer() {
		return costumer.length;
	}
	
}
