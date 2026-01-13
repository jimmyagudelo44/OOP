package t23;

class Container {

	static Client[] costumer;
	static Order[] purchase;
	static Item[] product;
	
	/**
	 * añade un cliente ampliando +1 la longitud del array
	 * @param c 
	 */
	static void increaseClient(Client c) {
		Client[] aux = costumer;
		costumer = new Client[aux.length+1];
		for(int i = 0 ; i<aux.length ; i++)
			costumer[i] = aux[i];
		costumer[aux.length] = c;
	}
	
	/**
	 * añade un producto ampliando +1 la longitud del array
	 * @param p
	 */
	static void increaseItem(Item p) {
		Item[] aux = product;
		product = new Item[aux.length+1];
		for(int i = 0 ; i<aux.length ; i++)
			product[i] = aux[i];
		product[aux.length] = p;
	}
	
	/**
	 * añade un pedido ampliando +1 la longitud del array
	 * @param o
	 */
	static void increaseOrder(Order o) {
		Order[] aux = purchase;
		purchase = new Order[aux.length+1];
		for(int i = 0 ; i<aux.length ; i++)
			purchase[i] = aux[i];
		purchase[aux.length] = o;
	}
	
	/**
	 * borra un cliente reduciendo -1 la longitud del array
	 * @param id
	 */
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
	
	/**
	 * borra un pedido reduciendo -1 la longitud del array
	 * @param code
	 */
	static void decreaseItem(int code) {
		Item[] aux = new Item[product.length-1];
		boolean found = false;
		for(int i = 0 ; i<aux.length ; i++) {
			if(product[i].getCode() == code)
				found = true;
			if(!found)
				aux[i] = product[i];
			else
				aux[i] = product[i+1];
		}
		product = aux;
		for(int i = 0 ; i<purchase.length ; i++)
			if(purchase[i].orderHasSpecificItem(code))
				purchase[i].deleteItem(code);
	}
	
	/**
	 * borra un pedido reduciendo -1 la longitud del array
	 * @param code
	 */
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
		for(int i = 0 ; i<costumer.length ; i++)
			if(costumer[i].searchForOrder(code))
				costumer[i].deleteOrder(code);
	}
	
	/**
	 * ordena los codigos de los pedidos para que al momento de añadir otro, 
	 * ocupe el primer espacio disponible del array
	 */
	static void arrangeOrder() {
		boolean found = false;
		int selected = 0;
		int scale = 0;
		for(int i = 0 ; i<purchase.length && !found; i++)
			if(purchase[i].getCode() != scale++) {
				found = true;
				selected = i;
			}
		if(found) {
			found = false;
			for(int i = 0 ; i<purchase.length ; i++) {
				if(i == selected)
					found = true;
				if(found)
					purchase[i].setCode(purchase[i].getCode()-1);
			}
		}
	}
	
	/**
	 * ordena los codigos de los productos para que al momento de añadir otro, 
	 * ocupe el primer espacio disponible del array
	 */
	static void arrangeItem() {
		boolean found = false;
		int selected = 0;
		int scale = 0;
		for(int i = 0 ; i<product.length && !found ; i++)
			if(product[i].getCode() != scale++) {
				found = true;
				selected = i;
			}
		if(found) {
			found = false;
			for(int i = 0 ; i<product.length; i++) {
				if(i == selected)
					found = true;
				if(found)
					product[i].setCode(product[i].getCode()-1);
			}
		}
	}
	
	/**
	 * 
	 * @param id
	 * @return si el cliente existe true
	 */
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
	
	/**
	 * 
	 * @param code
	 * @return si el pedido existe true
	 */
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
	
	/**
	 * 
	 * @param code
	 * @return si el producto existe true
	 */
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
	
	/**
	 * 
	 * @return si todos los clientes tienen todos los pedidos true
	 */
	static boolean allInsideAllClients() {
		boolean inside = true;
		for(int i = 0 ; i<Container.costumer.length && inside ; i++)
			for(int c = 0 ; c<Container.purchase.length && inside ; c++)
				if(!Container.costumer[i].searchForOrder(Container.purchase[c].getCode()))
					inside = false;
		return inside;
	}
	
	/**
	 * 
	 * @return si todos los pedidos tienen todos los productos true
	 */
	static boolean allInsideAllOrders() {
		boolean inside = true;
		for(int i = 0 ; i<Container.purchase.length && inside ; i++)
			for(int c = 0 ; c<Container.product.length && inside ; c++)
				if(!Container.purchase[i].orderHasSpecificItem(Container.product[c].getCode()))
					inside = false;
		return inside;
	}

	/**
	 * 
	 * @return si hay al menos un cliente que tenga un pedido true
	 */
	static boolean anyOrder() {
		boolean has = false;
		for(int i = 0 ; i<costumer.length && !has ; i++)
			if(costumer[i].hasOrders())
				has = true;
		return has;
	}
	
	/**
	 * 
	 * @return si hay al menos un pedido que tenga un producto true
	 */
	static boolean anyItem() {
		boolean has = false;
		for(int i = 0 ; i<purchase.length && !has ; i++)
			if(purchase[i].hasItems())
				has = true;
		return has;
	}
	
}