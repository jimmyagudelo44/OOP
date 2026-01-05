package t23;

class Container {

	static Client[] costumer;
	static Order[] purchase;
	static Item[] product;
	
	static void increaseClient() {
		Client[] aux = costumer;
		costumer = new Client[aux.length+1];
		for(int i = 0 ; i<aux.length ; i++)
			costumer[i] = aux[i];
	}
	
	static void increaseItem() {
		Item[] aux = product;
		product = new Item[aux.length+1];
		for(int i = 0 ; i<aux.length ; i++)
			product[i] = aux[i];
	}
	
	static void increaseOrder() {
		Order[] aux = purchase;
		purchase = new Order[aux.length+1];
		for(int i = 0 ; i<aux.length ; i++)
			purchase[i] = aux[i];
	}
	
	static void decreaseClient(String id) {
		Client[] aux = new Client[costumer.length-1];
		boolean found = false;
		for(int i = 0 ; i<aux.length ; i++) {
			if(costumer[i].getId().equals(id))
				found = true;
			if(!found)
				aux[i] = costumer[i];
			else
				aux[i] = costumer[i+1];
		}
		costumer = aux;
	}
	
	static void decreaseOrder(int code){
		Order[] aux = new Order[purchase.length-1];
		boolean found = false;
		for(int i = 0 ; i<aux.length ; i++) {
			if(purchase[i].getCode() == code)
				found = true;
			if(!found)
				aux[i] = purchase[i];
			else
				aux[i] = purchase[i+1];
		}
		purchase = aux;
	}
	
	static boolean orderArranged() {
		boolean arranged = true;
		int scale = 0;
		for(Order o : purchase)
			if(o.getCode() != scale++)
				arranged = false;
		return arranged;
	}
	
	static void arrangeOrder() {
		boolean found = false;
		int selected = 0;
		int scale = 0;
		for(int i = 0 ; i<purchase.length && !found; i++)
			if(purchase[i].getCode() != scale++) {
				found = true;
				selected = i;
			}
		found = false;
		for(int i = 0 ; i<purchase.length ; i++) {
			if(i == selected)
				found = true;
			if(found)
				purchase[i].setCode(purchase[i].getCode()-1);
		}
	}
	
	static boolean clientFound(String id) {
		boolean found = false;
		for(int i = 0 ; i<costumer.length ; i++)
			if(costumer[i].getId().equals(id))
				found = true;
		return found;
	}
	
	static Client searchClient(String id) {
		boolean found = false;
		Client selected = null;
		for(int i = 0 ; i<costumer.length && !found ; i++)
			if(costumer[i].getId().equals(id)) {
				found = true;
				selected = costumer[i];
			}
		return selected;
	}
	
	static boolean orderFound(int code) {
		boolean found = false;
		for(int i = 0 ; i<purchase.length && !found ; i++)
			if(purchase[i].getCode() == code)
				found = true;
		return found;
	}
	
	static Order searchOrder(int code) {
		boolean found = false;
		Order selected = null;
		for(int i = 0 ; i<purchase.length && !found ; i++)
			if(purchase[i].getCode() == code) {
				found = true;
				selected = purchase[i];
			}
		return selected;
	}
	
	static boolean itemFound(int code) {
		boolean found = false;
		for(int i = 0 ; i<product.length && !found ; i++)
			if(product[i].getCode() == code)
				found = true;
		return found;
	}
	
	static Item searchItem(int code) {
		boolean found = false;
		Item selected = null;
		for(int i = 0 ; i<product.length && !found ; i++)
			if(product[i].getCode() == code) {
				found = true;
				selected = product[i];
			}
		return selected;
	}
	
}
