package t23;

class Interface {
	
	static void mainMenu() {
		System.out.println();
		System.err.println("MENU PRINCIPAL");
		System.out.println("1. Añadir");
		if(Item.itemExist || Order.orderExist || Client.clientExist) {
			System.out.println("2. Eliminar");
			System.out.println("3. Modificar");
			if(((Client.clientExist && Order.orderExist) || (Order.orderExist && Item.itemExist)) 
					&& !(Container.allInsideAllClients() && Container.allInsideAllProducts()))
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
			inside = Container.allInsideAllProducts();
		if(!inside)
			System.out.println("2. Vincular Producto a Pedido");
		System.out.println("3. Salir");
		System.out.println();
	}
	//5
	static void unLink() {
		System.out.println();
		System.out.println("1. Devincular Pedido a Cliente");
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
	/**
	 * Este metodo solo funciona con numeros menores a 10. Si el valor no es valido devuelve -1
	 * @param option
	 * @return
	 */
	static int select(String option) {
		int selection = -1;
		if(option.charAt(0)>=48 && option.charAt(0)<=57)
			for(int i = 47 ; i<option.charAt(0) ; i++)
				selection++;
		return selection;
	}
	
	static boolean noCharOnSelect(String option) {
		boolean noChar = true;
		for(int i = 0 ; i<option.length() && noChar ; i++)
			if(!(option.charAt(0)>=48 && option.charAt(0)<=57))
				noChar = false;
		return noChar;
	}
	
	static void allClients() {
		for(int i = 0 ; i<Container.costumer.length ; i++)
			System.out.println(Container.costumer[i]);
	}
	
	static void allOrders() {
		for(int i = 0 ; i<Container.purchase.length ; i++)
			System.out.println(Container.purchase[i]);
	}
	
	static void allItems() {
		for(int i = 0 ; i<Container.product.length ; i++)
			System.out.println(Container.product[i]);
	}
	
	static void allClientWithOrder(int code) {
		for(int i = 0 ; i<Container.costumer.length ; i++)
			if(Container.costumer[i].searchForOrder(code))
				System.out.println(Container.costumer[i]);
	}
	
}
