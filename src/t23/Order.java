package t23;

class Order {
	private int code;
	private String description;
	private Item[] product;
	static boolean orderExist;
	
	Order(int code, String description, Item[] product) {
		this.code = code;
		this.description = description;
		this.product = product;
	}
	int getCode() {
		return code;
	}
	void setCode(int code) {
		this.code = code;
	}
	String getDescription() {
		return description;
	}
	void setDescription(String description) {
		this.description = description;
	}
	Item[] getProduct() {
		return product;
	}
	void setProduct(Item[] product) {
		this.product = product;
	}
	
	/**
	 * añade un producto ampliando +1 la longitud del array
	 * @param product
	 */
	void addItem(Item product) {
		Item[] aux = new Item[this.product.length];
		for(int i = 0 ; i<this.product.length ; i++)
			aux[i] = this.product[i];
		this.product = new Item[aux.length+1];
		for(int i = 0 ; i<aux.length ; i++)
			this.product[i] = aux[i];
		this.product[this.product.length-1] = product;
	}
	
	/**
	 * borra un producto reduciendo -1 la longitud del array
	 * @param code
	 */
	void deleteItem(int code) {
		Item[] aux = new Item[product.length-1];
		int productSelected = 0;
		for(int i = 0 ; i<product.length ; i++)
			if(product[i].getCode() == code)
				productSelected = i;
		boolean coincidence = false;
		for(int i = 0 ; i<aux.length ; i++) {
			if(product[i].getCode() == product[productSelected].getCode())
				coincidence = true;
			if(!coincidence)
				aux[i] = product[i];
			else
				aux[i] = product[i+1];
		}
		product = new Item[aux.length];
		for(int i = 0 ; i<product.length ; i++)
			product[i] = aux[i];
	}
	
	double totalCost() {
		double total = 0;
		for(int i = 0 ; i<product.length ; i++)
			total += product[i].cost();
		return total;
	}
	
	String allItemsToString() {
		String total = "";
		for(int i = 0 ; i<product.length ; i++)
			total += product[i]+" -- ";
		return "productos de el pedido "+description+": "+total;
	}
	
	public String toString() {
		return "Order [codigo=" + code + ", descripcion=" + description
				+ ", productos=" + product.length + "]";
	}
	
	/**
	 * 
	 * @return si el pedido tiene al menos un producto true
	 */
	boolean hasItems() {
		if(product.length >= 1)
			return true;
		else
			return false;
	}
	
	boolean orderHasSpecificItem(int code) {
		boolean inside = false;
		for(int i = 0 ; i<product.length && !inside; i++)
			if(product[i].getCode() == code)
				inside = true;
		return inside;
	}
	
	/**
	 * 
	 * @return si hay algun cliente que tenga este pedido true
	 */
	boolean orderInsideClient() {
		boolean inside = false;
		for(int i = 0 ; i<Container.costumer.length && !inside ; i++)
			if(Container.costumer[i].searchForOrder(code))
				inside = true;
		return inside;
	}

}