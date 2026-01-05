package t23;

import java.util.Arrays;

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
			total += purchase[i]+" -- ";
		return total;
	}
	
	public String toString() {
		return "Client [DNI=" + id + ", nombre=" + name + ", pedidos=" + purchase.length + "]";
	}

	boolean searchForOrder(int code) {
		boolean found = false;
		for(int i = 0 ; i<purchase.length && !found ; i++)
			if(purchase[i].getCode() == code)
				found = true;
		return found;
	}
	
	Order getOrderbyCode(int code) {
		boolean found = false;
		int orderSelected = 0;
		for(int i = 0 ; i<purchase.length && !found ; i++)
			if(purchase[i].getCode() == code) {
				found = true;
				orderSelected = i;
			}
		return purchase[orderSelected];
	}
	
	Order getOrderbyItemCode(int code) {
		boolean found = false;
		int orderSelected = 0;
		for(int i = 0 ; i<purchase.length && !found ; i++)
			for(int c = 0 ; c<purchase[i].getProduct().length && !found ; c++)
				if(purchase[i].getProduct()[c].getCode() == code) {
					orderSelected = i;
					found = true;
				}
		return purchase[orderSelected];
	}
	
	boolean searchForItem(int code) {
		boolean found = false;
		for(int i = 0 ; i<purchase.length ; i++)
			for(int c = 0 ; c<purchase[i].getProduct().length ; c++)
				if(purchase[i].getItemAt(c).getCode() == code)
					found = true;
		return found;
	}
	
	double bill() {
		double total = 0;
		for(int i = 0 ; i<purchase.length ; i++)
			total += purchase[i].totalCost();
		return total;
	}
	
	Order getPurchaseAt(int position) {
		return purchase[position];
	}
	
}
