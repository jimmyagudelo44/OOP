package t23;

class Interface {
	
	static void mainMenu() {
		System.err.println("MENU PRINCIPAL");
		System.out.println("1. Añadir");
		if(Item.itemExist || Order.orderExist || Client.clientExist) {
			System.out.println("2. Eliminar");
			System.out.println("3. Modificar");
		}
		System.out.println("4. Vincular");
		System.out.println("5. Desvincular");
		System.out.println("6. Mostrar");
		System.out.println("7. Salir");
	}
	//1
	static void add() {
		System.err.println("MENU ADICION");
		System.out.println("1. Añadir Cliente");
		if(Client.clientExist) {
			System.out.println("2. Añadir Pedido");
				if(Order.orderExist)
					System.out.println("3. Añadir Producto");
		}
		System.out.println("4. Salir");
	}
	//2
	static void delete() {
		System.err.println("MENU ELIMINACION");
		if(Client.clientExist) {
			System.out.println("1. Eliminar Cliente");
			if(Order.orderExist) {
				System.out.println("2. Eliminar Pedido");
				if(Item.itemExist)
					System.out.println("3. Eliminar Producto");
			}
		}
		System.out.println("4. Eliminar IVA");
		System.out.println("5. Salir");
	}
	//3
	static void modify() {
		System.err.println("MENU MODIFICACION");
		if(Client.clientExist) {
			System.out.println("1. Modificar Cliente");
			if(Order.orderExist) {
				System.out.println("2. Modificar Pedido");
				if(Item.itemExist)
					System.out.println("3. Modificar Producto");
			}
		}
		System.out.println("4. Modificar IVA");
		System.out.println("5. Salir");
	}
	//3.1
	static void modifyClient() {
		System.out.println("1. Modificar nombre");
		System.out.println("2. Modificar DNI");
		System.out.println("3. Salir");
	}
	//4
	static void link() {
		System.out.println("1. Vincular Pedido a Cliente");
		System.out.println("2. Vincular Producto a Pedido");
		System.out.println("3. Salir");
	}
	static void unLink() {
		System.out.println("1. Devincular Pedido a Cliente");
		System.out.println("2. Desvincular Producto a Pedido");
		System.out.println("3. Salir");
	}
	//6
	static void show() {
		System.err.println("MENU VISUALIZACION");
		if(Client.clientExist) {
			System.out.println("1. Mostrar Clientes");
			if(Order.orderExist) {
				System.out.println("2. Mostrar Pedidos");
				if(Item.itemExist)
					System.out.println("3. Mostrar Productos");
			}
		}
		System.out.println("4. Mostrar IVA");
		System.out.println("5. Salir");
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
	
}
