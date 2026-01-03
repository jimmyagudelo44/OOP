package t22;

class Client {

	private String name;
	private String id;
	private Order[] purchases;
	
	Client(String name, String id, Order[] purchases) {
		this.name = name;
		this.id = id;
		this.purchases = purchases;
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	String getId() {
		return id;
	}

	void setId(String id) {
		this.id = id;
	}

	Order[] getPurchases() {
		return purchases;
	}

	void setPurchases(Order[] purchases) {
		this.purchases = purchases;
	}
	
	/**
	 * Este metodo solo se debe de utilizar a la hora de crear un cliente
	 */
	void resetPurchases() {
		for(int i = 0 ; i<purchases.length ; i++)
			purchases[i] = new Order(-1); 
	}
	
	int purchaseCounter() {
		int counter = 0;
		for(int i = 0 ; i<purchases.length ; i++)
			if(purchases[i].getCode()!=-1)
				counter++;
		return counter;
	}
	
	boolean checkPurchase(Order purchase) {
		boolean found = false;
		for(int i = 0 ; i<this.purchases.length ; i++)
			if(this.purchases[i].getCode() == purchase.getCode())
				found = true;
		return found;
	}
	
	/**
	 * Asegurarse de que los pedidos esten reseteados
	 * @return Devuelve los atributos del cliente mas todos los pedidos realizados que no sean -1
	 */
	String clientToString() {
		String total = "";
		boolean found = false;
		for(int i = 0 ; i<purchases.length ; i++)
			if(purchases[i].getCode()!=-1) {
				total += purchases[i].orderToStringNoClients()+" || ";
				found = true;
			}
		if(found)
			return "nombre: "+name+", DNI: "+id+", Pedidos: "+total;
		else
			return "nombre: "+name+", DNI: "+id+", --0 pedidos--";
	}
	
	Order purchaseAt(int position){
		return purchases[position];
	}
	
	void setPurchaseAt(int position, Order purchase) {
		this.purchases[position] = purchase;
	}
	
	double bill() {
		double total = 0;
		for(int i = 0 ; i<purchases.length ; i++)
			total += purchases[i].getPrice();
		return total;
	}
}
