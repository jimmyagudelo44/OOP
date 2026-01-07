package t23;

class Item {
	private int code;
	private String name;
	private double price;
	static double tax;
	static boolean itemExist;
	
	Item(int code, String name, double price){
		this.code = code;
		this.name = name;
		this.price = price;
	}

	void setCode(int code) {
		this.code = code;
	}
	
	int getCode() {
		return code;
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	double getPrice() {
		return price;
	}

	void setPrice(double price) {
		this.price = price;
	}

	public String toString() {
		return "Item [code=" + code + ", name=" + name + ", price=" + price + "€]";
	}
	
	double cost() {
		return price+(price*(tax/100));
	}
	
	boolean itemInsideOrder() {
		boolean inside = false;
		for(int i = 0 ; i<Container.purchase.length ; i++)
			if(Container.purchase[i].OrderHasSpecificItem(code))
				inside = true;
		return inside;
	}
	
	boolean itemInsideClient() {
		boolean inside = false;
		for(int i = 0 ; i<Container.costumer.length && !inside ; i++)
			if(Container.costumer[i].searchForItem(code))
				inside = true;
		return inside;
	}
}
