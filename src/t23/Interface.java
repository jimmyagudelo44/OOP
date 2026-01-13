package t23;

class Interface {
	
	//Esta clase servira para mostrar la interfaz que vera el usuario
	
	static void mainMenu() {
		System.out.println();
		System.err.println("MENU PRINCIPAL");
		System.out.println("1. Añadir");
		if(Item.itemExist || Order.orderExist || Client.clientExist) {
			System.out.println("2. Eliminar");
			System.out.println("3. Modificar");
			if(((Client.clientExist && Order.orderExist) || (Order.orderExist && Item.itemExist)) 
					&& !(Container.allInsideAllClients() && Container.allInsideAllOrders()))
				System.out.println("4. Vincular");
			if(Container.anyOrder() || Container.anyItem())
				System.out.println("5. Desvincular");
		}
		System.out.println("6. Mostrar");
		System.out.println("7. Salir");
		System.out.println();
	}
	//1
	static void add() {
		System.out.println();
		System.err.println("MENU ADICION");
		System.out.println("1. Añadir Cliente");
		System.out.println("2. Añadir Pedido");
		System.out.println("3. Añadir Producto");
		System.out.println("4. Salir");
		System.out.println();
	}
	//2
	static void delete() {
		System.out.println();
		System.err.println("MENU ELIMINACION");
		if(Client.clientExist)
			System.out.println("1. Eliminar Cliente");
		if(Order.orderExist) 
			System.out.println("2. Eliminar Pedido");
		if(Item.itemExist)
			System.out.println("3. Eliminar Producto");
		System.out.println("4. Eliminar IVA");
		System.out.println("5. Salir");
		System.out.println();
	}
	//3
	static void modify() {
		System.out.println();
		System.err.println("MENU MODIFICACION");
		if(Client.clientExist)
			System.out.println("1. Modificar Cliente");
		if(Order.orderExist)
			System.out.println("2. Modificar Pedido");
		if(Item.itemExist)
			System.out.println("3. Modificar Producto");
		System.out.println("4. Modificar IVA");
		System.out.println("5. Salir");
		System.out.println();
	}
	//3.1
	static void modifyClient() {
		System.out.println();
		System.out.println("1. Modificar nombre");
		System.out.println("2. Modificar DNI");
		System.out.println("3. Salir");
		System.out.println();
	}
	//3.2
	static void modifyItem() {
		System.out.println();
		System.out.println("1. Modificar nombre");
		System.out.println("2. Modificar precio");
		System.out.println("3. Salir");
		System.out.println();
	}
	//4
	static void link() {
		System.out.println();
		boolean inside = true;
		if(Order.orderExist && Client.clientExist)
			inside = Container.allInsideAllClients();
		if(!inside)
			System.out.println("1. Vincular Pedido a Cliente");
		inside = true;
		if(Item.itemExist && Order.orderExist)
			inside = Container.allInsideAllOrders();
		if(!inside)
			System.out.println("2. Vincular Producto a Pedido");
		System.out.println("3. Salir");
		System.out.println();
	}
	//5
	static void unLink() {
		System.out.println();
		if(Container.anyOrder())
			System.out.println("1. Devincular Pedido a Cliente");
		if(Container.anyItem())
			System.out.println("2. Desvincular Producto a Pedido");
		System.out.println("3. Salir");
		System.out.println();
	}
	//6
	static void show() {
		System.out.println();
		System.err.println("MENU VISUALIZACION");
		if(Client.clientExist)
			System.out.println("1. Mostrar Clientes");
		if(Order.orderExist)
			System.out.println("2. Mostrar Pedidos");
		if(Item.itemExist)
			System.out.println("3. Mostrar Productos");
		System.out.println("4. Mostrar IVA");
		System.out.println("5. Salir");
		System.out.println();
	}
	//6.1
	static void showClients() {
		System.out.println();
		System.out.println("1. Mostrar pedidos de un cliente");
		System.out.println("2. Mostrar productos de un cliente");
		System.out.println("3. Salir");
		System.out.println();
	}
	//6.2
	static void showOrders() {
		System.out.println();
		System.out.println("1. Mostrar productos de un pedido");
		System.out.println("2. Mostrar a que cliente/s pertenece un pedido");
		System.out.println("3. Salir");
		System.out.println();
	}
	//6.3
	static void showItems() {
		System.out.println();
		System.out.println("1. Mostrar a que pedido/s pertenece un producto");
		System.out.println("2. Mostrar a que cliente/s pertenece un producto");
		System.out.println("3. Salir");
		System.out.println();
	}
	
//	static java.util.Scanner KB = new java.util.Scanner(System.in);
	/**
	 * Este metodo solo funciona con numeros menores a 10
	 * @param option
	 * @return int, que sera el primer caracter escrito, si no es un numero devolvera -1 
	 */
	static int select(String option) {
//		String selection = KB.nextLine();
		int selection = -1 ;
		if(option.charAt(0)>=48 && option.charAt(0)<=57)
			for(int i = 47 ; i<option.charAt(0) ; i++)
				selection++;
		return selection;
	}
	
	/**
	 * metodo no usado, ni me acuerdo que hacia pero imagino que es pa ver si has puesto un char o no
	 * @param option
	 * @return
	 */
	static boolean noCharOnSelect(String option) {
		boolean noChar = true;
		for(int i = 0 ; i<option.length() && noChar ; i++)
			if(!(option.charAt(0)>=48 && option.charAt(0)<=57))
				noChar = false;
		return noChar;
	}
	
	static void allClients() {
		System.out.println();
		for(Client c : Container.costumer)
			System.out.println(c);
		System.out.println();
	}
	
	/**
	 * Devuelve prints de clientes que tengan el pedido metido en el parametro
	 * @param code
	 */
	static void allClientWithOrder(int code) {
		System.out.println();
		for(Client c : Container.costumer)
			if(c.searchForOrder(code))
				System.out.println(c);
		System.out.println();
	}
	
	/**
	 * Devuelve prints de clientes que tengan el producto metido en el parametro
	 * @param code
	 */
	static void allClientsWithItem(int code) {
		System.out.println();
		for(Client c : Container.costumer)
			for(Order o : c.getPurchase())
				if(o.orderHasSpecificItem(code))
					System.out.println(c);
		System.out.println();
	}
	
	/**
	 * devuelve los pedidos de un cliente
	 * @param id
	 */
	static void allOrdersFromClient(String id) {
		System.out.println();
		for(int i = 0 ; i<Container.searchClient(id).getPurchase().length ; i++)
			System.out.println(Container.searchClient(id).getPurchase()[i]);
		System.out.println();
	}
	
	/**
	 * devuelve prints de los productos de un cliente
	 * @param id
	 */
	static void allItemsFromClient(String id) {
		System.out.println();
		Client c = Container.searchClient(id);
		for(int i = 0 ; i<c.getPurchase().length ; i++)
			allItemsFromOrder(c.getPurchase()[i].getCode());
		System.out.println();
	}
	
	static void allOrders() {
		System.out.println();
		for(Order o : Container.purchase)
			System.out.println(o);
		System.out.println();
	}
	
	/**
	 * devuelve prints de los pedidos que tengan el item introducido en el parametro
	 * @param code
	 */
	static void allOrdersWithItem(int code) {
		System.out.println();
		for(Order o : Container.purchase)
			if(o.orderHasSpecificItem(code))
				System.out.println(o);
		System.out.println();
	}
	
	/**
	 * devuelve prints de los productos que tenga el pedido introducido en el parametro
	 * @param code del pedido
	 */
	static void allItemsFromOrder(int code) {
		System.out.println();
		for(int i = 0 ; i<Container.searchOrder(code).getProduct().length ; i++)
			System.out.println(Container.searchOrder(code).getProduct()[i]);
		System.out.println();
	}
	
	/**
	 * prints de todos los pedidos que esten vinculados a un cliente
	 */
	static void ordersInsideAClient() {
		System.out.println();
		for(Order o : Container.purchase)
			if(o.orderInsideClient())
				System.out.println(o);
		System.out.println();
	}
	
	static void allItems() {
		System.out.println();
		for(Item i : Container.product)
			System.out.println(i);
		System.out.println();
	}
	
	/**
	 * prints de todos los pedidos que esten vinculados a un pedido
	 */
	static void itemsInsideAnOrder() {
		System.out.println();
		for(Item i : Container.product)
			if(i.itemInsideOrder())
				System.out.println(i);
		System.out.println();
	}
	
}