package t23;

import java.util.Scanner;

public class Operation {
	
	//1
	static void create(Item[] alpha, Order[] beta) {
		Scanner KB = new Scanner(System.in);
		int option;
		boolean exit = false;
		while(!exit) {
			Interface.add();
			System.out.print("Selecciona: ");
//			option = KB.readInt();
			option = Interface.select(KB.nextLine());
			switch(option) {
				case 1->{
					createClient(beta);
				}
				case 2->{
					createOrder(alpha);
				}
				case 3->{
					createItem();
				}
				case 4->
					exit = true;
				default->{
					System.err.println("ERROR. Esta opcion no esta disponible. "
							+ "Intentelo de nuevo");
				}
				case -1->{
					System.err.println("ERROR. EL VALOR INTRODUCIDO NO ES VALIDO. "
							+ "Intentelo de nuevo");
				}
			}
		}
	}
	
	private static void createClient(Order[] beta) {
		Scanner KB = new Scanner(System.in);
		System.out.print("Ahora introduce su nombre: ");
		String name = KB.nextLine();
		String id;
		do{
			System.out.print("Introduce el DNI del Cliente: ");
			id = KB.nextLine();
			if(Container.clientFound(id))
				System.err.println("ERROR. No puede haber "
						+ "2 DNIs iguales. Intentalo de nuevo: ");
		}while(Container.clientFound(id));
		Client c = new Client(id, name, beta);
		Container.increaseClient(c);
		System.err.println("Nuevo Cliente: "
				+Container.costumer[Container.costumer.length-1]);
		Client.clientExist = true;
	}
	
	private static void createOrder(Item[] alpha) {
		Scanner KB = new Scanner(System.in);
		System.out.print("Introduce la descripcion del pedido: ");
		String description = KB.nextLine();
		Container.increaseOrder(new Order(MainStore.codeOrder++, description, alpha));
		System.err.println("Nuevo pedido: "
				+Container.purchase[Container.purchase.length-1]);
		Order.orderExist = true;
	}
	
	private static void createItem() {
		Scanner KB = new Scanner(System.in);
		System.out.print("Introduce el nombre del producto: ");
		String name = KB.nextLine();
		System.out.print("Introduce el precio del producto: ");
		double price = KB.nextDouble();	KB.nextLine();
		Container.increaseItem(new Item(MainStore.codeItem++, name, price));
		System.err.println("Nuevo producto: "+Container.product[Container.product.length-1]);
		Item.itemExist = true;
	}
	
	//2
	static void delete() {
		Scanner KB = new Scanner(System.in);
		int option;
		boolean exit = false;
		while(!exit) {
			Interface.delete();
			System.out.print("Selecciona: ");
			option = Interface.select(KB.nextLine());
			switch(option) {
				case 1->{
					deleteClient();
				}
				case 2->{
					deleteOrder();
				}
				case 3->{
					deleteItem();
				}
				case 4->{
					System.err.println("IVA eliminado");
					Item.TAX = 0;
				}
				case 5->
					exit = true;
				default->
					System.err.println("ERROR. Esta opcion no esta disponible. "
							+ "Intentelo de nuevo");
				case -1->
					System.err.println("ERROR. EL VALOR INTRODUCIDO NO ES VALIDO. "
							+ "Intentelo de nuevo");
			}
		}
	}
	
	private static void deleteClient() {
		Scanner KB = new Scanner(System.in);
		String id;
		do{
			Interface.allClients();
			System.out.print("Introduce el id de la persona que "
					+ "quieres eliminar: ");
			id = KB.nextLine();
			if(Container.clientFound(id))
				System.err.println("Cliente eliminado: "
						+ Container.searchClient(id));
			if(!Container.clientFound(id))
				System.err.println("No existe ningun cliente con este "
						+ "DNI. Intentalo de nuevo");
		}while(!Container.clientFound(id));
		Container.decreaseClient(id);
		if(Container.costumer.length == 0)
			Client.clientExist = false;
	}
	
	private static void deleteOrder() {
		Scanner KB = new Scanner(System.in);
		int code;
		do{
			Interface.allOrders();
			System.out.print("Introduce el codigo del pedido "
					+ "que quieras eliminar: ");
			code = KB.nextInt();	KB.nextLine();
			if(!Container.orderFound(code))
				System.err.println("No hay ningun pedido con este "
						+ "codigo. Intentalo de nuevo");
		}while(!Container.orderFound(code));
		System.err.println("Pedido eliminado: "+Container.searchOrder(code));
		Container.decreaseOrder(code);
		MainStore.codeOrder--;
		if(Container.purchase.length == 0)
			Order.orderExist = false;
		Container.arrangeOrder();
	}
	
	private static void deleteItem() {
		Scanner KB = new Scanner(System.in);
		int code;
		do {
			Interface.allItems();
			System.out.print("Introduce el codigo del item que quieras eliminar: ");
			code = KB.nextInt();	KB.nextLine();
			if(!Container.itemFound(code))
				System.err.println("No se ha encontrado ningun item con ese codigo. "
						+ "Intentalo de nuevo");
		}while(!Container.itemFound(code));
		System.err.println("producto eliminado: "+Container.searchItem(code));
		Container.decreaseItem(code);
		MainStore.codeItem--;
		if(Container.product.length == 0)
			Item.itemExist = false;
		Container.arrangeItem();
	}
	
	//3
	static void modify() {
		Scanner KB = new Scanner(System.in);
		boolean exit = false;
		while(!exit) {
			Interface.modify();
			System.out.print("Selecciona: ");
			int option = Interface.select(KB.nextLine());
			switch(option) {
				case 1->{
					modifyClient();
				}
				case 2->{
					modifyOrder();
				}
				case 3->{
					modifyItem();
				}
				case 4->{
					System.out.println("Introduce el nuevo IVA: ");
					Item.TAX = KB.nextDouble();		KB.nextLine();
				}
				case 5->
					exit = true;
				default->
					System.err.println("ERROR. Esta opcion no esta disponible. "
							+ "Intentelo de nuevo");
				case -1->
					System.err.println("ERROR. EL VALOR INTRODUCIDO NO ES VALIDO. "
							+ "Intentelo de nuevo");
			}
		}
	}
	
	private static void modifyClient() {
		Scanner KB = new Scanner(System.in);
		String id;
		do{
			Interface.allClients();
			System.out.print("Introduce el DNI del cliente al "
				+ "que quieras modificar: ");
			id = KB.nextLine();
			if(!Container.clientFound(id))
				System.err.println("No hay ningun cliente con "
						+ "ese DNI. Intentalo de nuevo");
		}while(!Container.clientFound(id));
		System.err.println("MODIFICANDO CLIENTE : "+Container.searchClient(id));
		boolean exit = false;
		while(!exit) {
			Interface.modifyClient();
			System.out.print("Selecciona: ");
			int option = Interface.select(KB.nextLine());
			switch(option) {
				case 1->{
					System.out.print("Introduce el nuevo nombre: ");
					String name = KB.nextLine();
					Container.searchClient(id).setName(name);
					System.err.println("Nombre cambiado: "
							+Container.searchClient(id));
				}
				case 2->{
					System.out.print("Introduce el nuevo DNI: ");
					String dni;
					do{
						System.out.print("Introduce el DNI del Cliente: ");
						dni = KB.nextLine();
						if(Container.clientFound(dni))
							System.err.println("ERROR. No puede haber "
									+ "2 DNIs iguales. Intentalo de nuevo: ");
					}while(Container.clientFound(dni));
					Container.searchClient(id).setId(dni);
					System.err.println("DNI cambiado: "
							+Container.searchClient(dni));
					id = dni;
				}
				case 3->
					exit = true;
				default->
					System.err.println("ERROR. Esta opcion no esta disponible. "
							+ "Intentelo de nuevo");
			}
		}
	}
	
	private static void modifyOrder() {
		Scanner KB = new Scanner(System.in);
		int code;
		do {
			Interface.allOrders();
			System.out.print("Introduce el codigo del pedido "
					+ "que quieras modificar: ");
			code = KB.nextInt();	KB.nextLine();
			if(!Container.orderFound(code))
				System.err.println("No hay ningun pedido con este "
						+ "codigo. Intentalo de nuevo");
		}while(!Container.orderFound(code));
		System.err.println("Modificando pedido: "+Container.searchOrder(code));
		System.out.println("Introduce la nueva descripcion del pedido: ");
		String description = KB.nextLine();
		Container.searchOrder(code).setDescription(description);
		System.err.println("Descripcion cambiada: "+Container.searchOrder(code));
	}
	
	private static void modifyItem() {
		Scanner KB = new Scanner(System.in);
		int code;
		do {
			Interface.allItems();
			System.out.print("Introduce el codigo del Item que quieras modificar: ");
			code = KB.nextInt();	KB.nextLine();
			if(!Container.itemFound(code))
				System.err.println("No se ha encontrado ningun item con este codigo. "
						+ "Intenalo de nuevo");
		}while(!Container.itemFound(code));
		System.err.println("Modificando pedido: "+Container.searchItem(code));
		boolean exit = false;
		while(!exit) {
			Interface.modifyItem();
			System.out.print("Selecciona: ");
			int option = Interface.select(KB.nextLine());
			switch(option) {
				case 1->{
					System.out.print("Introduce el nuevo nombre: ");
					String name = KB.nextLine();
					Container.searchItem(code).setName(name);
					System.out.println("Nombre cambiado: "+Container.searchItem(code));
				}
				case 2->{
					System.out.print("Introduce el nuevo precio: ");
					double price = KB.nextDouble();	KB.nextLine();
					Container.searchItem(code).setPrice(price);
					System.out.println("Precio cambiado: "+Container.searchItem(code));
				}
				case 3->
					exit = true;
				default->
					System.err.println("ERROR. Esta opcion no esta disponible. "
							+ "Intentelo de nuevo");
			}
		}
	}
	
	//4
	static void link() {
		Scanner KB = new Scanner(System.in);
		boolean exit = false;
		while(!exit) {
			Interface.link();
			System.out.print("Selecciona: ");
			int option = Interface.select(KB.nextLine());
			switch(option) {
				case 1->{
					linkOrderToClient();
				}
				case 2->{
					linkItemToOrder();
				}
				case 3->
					exit = true;
				default->
					System.err.println("ERROR. Esta opcion no esta disponible. "
							+ "Intentelo de nuevo");
				case -1->
					System.err.println("ERROR. EL VALOR INTRODUCIDO NO ES VALIDO. "
							+ "Intentelo de nuevo");
			}
		}
	}
	
	private static void linkOrderToClient() {
		Scanner KB = new Scanner(System.in);
		String id;
		boolean inside;
		do{
			Interface.allClients();
			System.out.print("Introduce el DNI del Cliente al que le quieras vincular "
					+ "el pedido: ");
			id = KB.nextLine();
			inside = false;
			if(!Container.clientFound(id))
				System.err.println("ERROR. No se ha encontrado a nadie "
						+ "con ese DNI. Intentelo de nuevo");
			else {
			if(Container.searchClient(id).getPurchase().length 
					== Container.purchase.length)
				inside = true;
			if(inside)
				System.err.println("Este cliente ya tiene todos "
						+ "los items existentes vinculados");
			}
		}while(!Container.clientFound(id) || inside);
		int code;
		do{
			Interface.allOrders();
			System.out.print("Introduce el codigo del pedido "
					+ "que quieras meter: ");
			code = KB.nextInt();	KB.nextLine();
			if(!Container.orderFound(code))
				System.err.println("No hay ningun pedido con este "
						+ "codigo. Intentalo de nuevo");
			else if(Container.searchClient(id).searchForOrder(code))
				System.err.println("Este cliente ya tiene ese pedido. "
						+ "Intentalo de nuevo con otro");
		}while(!Container.orderFound(code) 
				|| Container.searchClient(id).searchForOrder(code));
		Container.searchClient(id).addOrder(Container.searchOrder(code));
		System.err.println("Pedido con codigo "+Container
				.searchOrder(code).getCode()+" vinculado a "
				+Container.searchClient(id).getName());
	}
	
	private static void linkItemToOrder() {
		Scanner KB = new Scanner(System.in);
		int codePurchase;
		boolean inside;
		do {
			Interface.allOrders();
			System.out.print("Introduce el codigo del pedido al que le quieras "
					+ "vincular el producto: ");
			codePurchase = KB.nextInt();
			inside = false;
			if(!Container.orderFound(codePurchase))
				System.err.println("No hay ningun pedido con este codigo. "
						+"Intentalo de nuevo");
			else {
				if(Container.searchOrder(codePurchase).getProduct().length 
						== Container.product.length)
					inside = true;
				if(inside)
					System.err.println("Este pedido ya tiene todos los items "
							+ "existentes vinculados");
			}
		}while(!Container.orderFound(codePurchase) || inside);
		int codeProduct;
		System.err.println("Vinculando producto a pedido: "+Container.searchOrder(codePurchase));
		do {
			Interface.allItems();
			System.out.print("Introduce el codigo del producto que le quieras meter "
					+ "al pedido: ");
			codeProduct = KB.nextInt();	KB.nextLine();
			if(!Container.itemFound(codeProduct))
				System.err.println("No hay ningun pedido con este codigo. Intentalo de nuevo");
			if(Container.searchOrder(codePurchase).orderHasSpecificItem(codeProduct))
				System.err.println("Este pedido ya tiene este producto. "
						+ "Intentalo de nuevo con otro");
		}while(!Container.itemFound(codeProduct) 
				|| Container.searchOrder(codePurchase).orderHasSpecificItem(codeProduct));
		Container.searchOrder(codePurchase).addItem(Container.searchItem(codeProduct));
		System.err.println("Producto con codigo: "+Container.searchItem(codeProduct).getCode()
				+ " añadido al pedido con codigo: "+Container.searchOrder(codePurchase).getCode()); 
	}
	
	//5
	static void unlink() {
		Scanner KB = new Scanner(System.in);
		boolean exit = false;
		while(!exit) {
			Interface.unLink();
			System.out.print("Selecciona: ");
			int option = Interface.select(KB.nextLine());
			switch(option) {
				case 1->{
					unlinkOrderFromClient();
				}
				case 2->{
					unlinkItemFromOrder();
				}
				case 3->
					exit = true;
				default->
					System.err.println("ERROR. Esta opcion no esta disponible. "
							+ "Intentelo de nuevo");
				case -1->
					System.err.println("ERROR. EL VALOR INTRODUCIDO NO ES VALIDO. "
							+ "Intentelo de nuevo");
			}
		}
	}
	
	private static void unlinkOrderFromClient() {
		Scanner KB = new Scanner(System.in);
		int code;
		boolean inside = false;
		do {
			Interface.allOrders();
			System.out.print("Introduce el codigo del pedido que quieras desvincular: ");
			code = KB.nextInt();	KB.nextLine();
			if(!Container.orderFound(code))
				System.err.println("No hay ningun codigo con ese pedido. Intentelo de nuevo");
			else if(!Container.searchOrder(code).orderInsideClient())
				System.err.print("Este pedido no esta vinculado a ningun cliente. Intentelo de nuevo");
			else
				inside = true;
			
		}while(!Container.orderFound(code) || !inside);
		String id;
		boolean has = false;
		do {
			Interface.allClientWithOrder(code);
			System.out.print("Introduce el dni del cliente al que le quieres desvincular este pedido: ");
			id = KB.nextLine();
			if(!Container.clientFound(id))
				System.err.println("No hay ningun cliente con este DNI. Intentelo de nuevo");
			else if(!Container.searchClient(id).searchForOrder(code))
				System.err.println("Este cliente no tiene el pedido seleccionado. Intentalo de nuevo");
			else
				has = true;
		}while(!Container.clientFound(id) || !has);
		Container.searchClient(id).deleteOrder(code);
		System.err.println("Pedido con codigo: "+code+ " desvinculado del cliente "
				+Container.searchClient(id).getName());
	}
	
	private static void unlinkItemFromOrder() {
		Scanner KB = new Scanner(System.in);
		int codeProduct;
		boolean inside = false;
		do {
			Interface.itemsInsideAnOrder();
			System.out.print("Introduce el codigo del producto que quieras desvincular: ");
			codeProduct = KB.nextInt();		KB.nextLine();
			if(!Container.itemFound(codeProduct))
				System.err.println("No hay ningun producto con este codigo. Intentelo de nuevo");
			else if(!Container.searchItem(codeProduct).itemInsideOrder())
				System.err.println("Este producto no esta vinculado a ningun pedido. Intentelo de nuevo");
			else
				inside = true;
		}while(!Container.itemFound(codeProduct) || !inside);
		int codePurchase;
		boolean has;
		do {
			Interface.allOrdersWithItem(codeProduct);
			System.out.print("Introduce el codigo del pedido al que le quieras quitar el producto seleccionado: ");
			codePurchase = KB.nextInt();	KB.nextLine();
			has = false;
			if(!Container.orderFound(codePurchase))
				System.err.println("No hay ningun pedido con este codigo. Intentalo de nuevo");
			else if(!Container.searchOrder(codePurchase).orderHasSpecificItem(codeProduct))
				System.err.println("Este pedido no tiene el producto seleccionado. Intentalo de nuevo");
			else
				has = true;
		}while(!Container.orderFound(codePurchase) || !has);
		Container.searchOrder(codePurchase).deleteItem(codeProduct);
		System.err.println("Producto con codigo: "+codeProduct+" desvinculado "
				+"del pedido con codigo: "+codePurchase);
	}
	
	//6
	static void show() {
		Scanner KB = new Scanner(System.in);
		boolean exit = false;
		while(!exit) {
			Interface.show();
			System.out.print("Selecciona: ");
			int option = Interface.select(KB.nextLine());
			switch(option) {
				case 1->{
					showClients();
				}
				case 2->{
					showOrders();
				}
				case 3->{
					showItems();
				}
				case 5->
					exit = true;
				default->
					System.err.println("ERROR. Esta opcion no esta disponible. "
							+ "Intentelo de nuevo");
				case -1->
					System.err.println("ERROR. EL VALOR INTRODUCIDO NO ES VALIDO. "
							+ "Intentelo de nuevo");
			}
		}
	}
	
	private static void showClients() {
		Scanner KB = new Scanner (System.in);
		boolean exit = false;
		while(!exit) {
			Interface.allClients();
			Interface.showClients();
			System.out.print("Selecciona: ");
			int option = Interface.select(KB.nextLine());
			switch(option) {
				case 1->{
					String id;
					do {
						System.out.print("Introduce el DNI del cliente al "
								+ "que le quieras ver sus pedidos: ");
						id = KB.nextLine();
						if(!Container.clientFound(id))
							System.err.println("No hay ningun cliente con "
									+ "este DNI. Intentalo de nuevo");
					}while(!Container.clientFound(id));
					if(Container.searchClient(id).hasOrders()) {
						System.err.println("Mostrando pedidos de: "+Container.searchClient(id).getName());
						Interface.allOrdersFromClient(id);
					}
					else
						System.err.println("Este cliente no tiene pedidos");
				}
				case 2->{
					String id;
					do {
						System.out.print("Introduce el DNI del cliente al que le quieras ver sus productos: ");
						id = KB.nextLine();
						if(!Container.clientFound(id))
							System.err.println("No hay ningun cliente con "
									+ "este DNI. Intentalo de nuevo");
					}while(!Container.clientFound(id));
					if(Container.searchClient(id).hasItems()) {
						System.err.println("Mostrando productos de "+Container.searchClient(id).getName());
						Interface.allItemsFromClient(id);	
					}
					else
						System.err.println("Este cliente no tiene productos");
				}
				case 3->
					exit = true;
				default->
					System.err.println("ERROR. Esta opcion no esta disponible. "
						+ "Intentelo de nuevo");
				case -1->
					System.err.println("ERROR. EL VALOR INTRODUCIDO NO ES VALIDO. "
						+ "Intentelo de nuevo");
			}
		}
	}
	
	private static void showOrders() {
		Scanner KB = new Scanner (System.in);
		boolean exit = false;
		while(!exit) {
			Interface.allOrders();
			Interface.showOrders();
			System.out.print("Selecciona: ");
			int option = Interface.select(KB.nextLine());
			switch(option) {
				case 1->{
					int code;
					do {
						System.out.print("Introduce el codigo del pedido al que le quieras ver "
								+ "sus productos");
						code = KB.nextInt();	KB.nextLine();
						if(!Container.orderFound(code))
							System.err.println("No hay ningun pedido con ese codigo. Intentalo de nuevo");
					}while(!Container.orderFound(code));
					if(Container.searchOrder(code).hasItems()) {
						System.err.println("Mostrando productos del pedido con codigo: "+code);
						Interface.allItemsFromOrder(code);	
					}
					else
						System.err.println("Este pedido no tiene productos");
				}
				case 2->{
					int code;
					do {
						System.out.print("Introduce el codigo del pedido al que le quieras ver "
								+ "los clientes que lo poseen: ");
						code = KB.nextInt();	KB.nextLine();
						if(!Container.orderFound(code))
							System.err.println("No hay ningun pedido con ese codigo. Intentalo de nuevo");
					}while(!Container.orderFound(code));
					if(Container.searchOrder(code).orderInsideClient()) {
						System.err.println("Clientes que tienen el pedido con el codigo "+code);
						Interface.allClientWithOrder(code);
					}
					else
						System.err.println("Este pedido no esta vinculado a ningun cliente");
				}
				case 3->
					exit = true;
				default->
					System.err.println("ERROR. Esta opcion no esta disponible. "
						+ "Intentelo de nuevo");
				case -1->
					System.err.println("ERROR. EL VALOR INTRODUCIDO NO ES VALIDO. "
						+ "Intentelo de nuevo");
			}
		}
	}
	
	private static void showItems() {
		Scanner KB = new Scanner(System.in);
		boolean exit = false;
		while(!exit) {
			Interface.allItems();
			Interface.showItems();
			System.out.print("Selecciona: ");
			int option = Interface.select(KB.nextLine());
			switch(option) {
				case 1->{
					int code;
					do {
						System.out.print("Introduce el codigo del producto al que le quieras ver sus productos: ");
						code = KB.nextInt();	KB.nextLine();
						if(!Container.itemFound(code))
							System.err.println("No hay ningun producto con este codigo. Intentelo de nuevo");
					}while(!Container.itemFound(code));
					if(Container.searchItem(code).itemInsideOrder()) {
						System.err.println("Mostrando los pedidos que tengan el producto de codigo "+code);
						Interface.allOrdersWithItem(code);
					}
					else
						System.err.println("Este producto no esta vinculado a ningun pedido");
				}
				case 2->{
					int code;
					do {
						System.out.print("Introduce el codigo del producto al que le quieras ver sus productos: ");
						code = KB.nextInt();	KB.nextLine();
						if(!Container.itemFound(code))
							System.err.println("No hay ningun producto con este codigo. Intentelo de nuevo");
					}while(!Container.itemFound(code));
					if(Container.searchItem(code).itemInsideClient()) {
						System.err.println("Mostrando los clientes que tengan el producto de codigo "+code);
						Interface.allClientsWithItem(code);
					}
					else
						System.err.println("Este producto no esta vinculado a ningun cliente");
				}
				case 3->
				exit = true;
				default->
					System.err.println("ERROR. Esta opcion no esta disponible. "
						+ "Intentelo de nuevo");
				case -1->
					System.err.println("ERROR. EL VALOR INTRODUCIDO NO ES VALIDO. "
						+ "Intentelo de nuevo");
			}
		}
	}
	
}
