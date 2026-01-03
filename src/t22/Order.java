package t22;

class Order {

	private String description;
	private double price;
	private int code;
	
	Order(int code){
		this.code = code;
	}
	
	Order(String description, double price, int code){
		this.description = description;
		this.price = price;
		this.code = code;
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
		return description+", "+price+"€, "+code;
	}
	
	
}
