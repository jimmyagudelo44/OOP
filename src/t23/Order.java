package t23;

class Order {
	private int code;
	private String description;
	private Item[] product;
	
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
	
	void addItem(Item product) {
		Item[] aux = new Item[this.product.length];
		for(int i = 0 ; i<this.product.length ; i++)
			aux[i] = this.product[i];
		this.product = new Item[aux.length+1];
		for(int i = 0 ; i<aux.length ; i++)
			this.product[i] = aux[i];
		this.product[this.product.length-1] = product;
	}
	
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
	
	String orderToString() {
		String total = "";
		for(int i = 0 ; i<product.length ; i++)
			total += product[i].getName()+" || ";
		return "codigo: "+code+", descripcion: "+description+", productos: "+total;
	}
	
	Item getItemAt(int position) {
		return product[position];
	}
	
	double totalCost(double tax) {
		double total = 0;
		for(int i = 0 ; i<product.length ; i++)
			total += product[i].getPrice()+(product[i].getPrice()*(tax/100));
		return total;
	}
	
	String allItemsToString() {
		String total = "";
		for(int i = 0 ; i<product.length ; i++)
			total += product[i].itemToString()+" \\";
		return total;
	}
	
}
