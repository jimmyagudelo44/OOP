package t23;

class Client {
	
	private String id;
	private String name;
	private Order[] purchase;
	
	Client(String id, String name, Order[] purchase) {
		this.id = id;
		this.name = name;
		this.purchase = purchase;
	}

	String getId() {
		return id;
	}
	
	void setId(String id) {
		this.id = id;
	}
	String getName() {
		return name;
	}
	void setName(String name) {
		this.name = name;
	}
	Order[] getPurchase() {
		return purchase;
	}
	void setPurchases(Order[] purchase) {
		this.purchase = purchase;
	}
	
	void addOrder(Order purchase) {
		Order[] aux = new Order[this.purchase.length];
		for(int i = 0 ; i<this.purchase.length ; i++)
			aux[i] = this.purchase[i];
		this.purchase = new Order[aux.length+1];
		for(int i = 0 ; i<aux.length ; i++)
			this.purchase[i] = aux[i];
		this.purchase[this.purchase.length-1] = purchase;
	}
	
	void deleteOrder(int code) {
		int orderSelected = 0;
		boolean found = false;
		for(int i = 0 ; i<purchase.length && !found; i++)
			if(purchase[i].getCode() == code) {
				orderSelected = i;
				found = true;
			}
		Order[] aux = new Order[purchase.length-1];
		boolean coincidence = false;
		for(int i = 0 ; i<aux.length ; i++) {
			if(purchase[i].getCode() == orderSelected)
				coincidence = true;
			if(!coincidence)
				aux[i] = purchase[i];
			else
				aux[i] = purchase[i+1];
		}
		purchase = new Order[aux.length];
		for(int i = 0 ; i<purchase.length ; i++)
			purchase[i] = aux[i];
	}
	
	String allOrdersToString() {
		String total = "";
		for(int i = 0 ; i<purchase.length ; i++)
			total += purchase[i].orderToString()+" -- ";
		return total;
	}
	
	String clientToString() {
		String total = "";
		for(int i = 0 ; i<purchase.length ; i++)
			total += "-- "+purchase[i].orderToString()+" --";
		return "Nombre: "+name+", DNI: "+id+", pedidos: "+total;
	}
	
	boolean searchForItem(int code) {
		boolean found = false;
		for(int i = 0 ; i<purchase.length ; i++)
			for(int c = 0 ; c<purchase[i].getProduct().length ; c++)
				if(purchase[i].getItemAt(c).getCode() == code)
					found = true;
		return found;
	}
	
	double bill(double tax) {
		double total = 0;
		for(int i = 0 ; i<purchase.length ; i++)
			total += purchase[i].totalCost(tax);
		return total;
	}
	
	Order getPurchaseAt(int position) {
		return purchase[position];
	}
	
}
