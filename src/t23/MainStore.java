package t23;

class MainStore {

	public static void main(String[] args) {
	
		java.util.Scanner KB = new java.util.Scanner(System.in);
		
		Client[] costumer = new Client[50];
		int counterCostumer = 0;
		int tax = 10;
		Item[] alpha = new Item[0];
		Order[] beta = new Order[0];
		int codeItem = 0;
		int codeOrder = 0;
		
		boolean exit = false;
		while(!exit) {
			System.out.println("1. Modificar IVA");
			System.out.println("2. Insertar nuevo cliente");
			if(counterCostumer>0) {
				System.out.println("3. Introducir un pedido para un cliente");
				System.out.println("4. Introducir Item a un pedido");
				System.out.println("5. Modificar pedidos para cliente ");
				System.out.println("6. Mostrar pedidos de un cliente");
				System.out.println("7. Eliminar Item");
				System.out.println("8. Cliente con mas monto gastado");
				System.out.println("9. Mostrar todos los Items");
				System.out.println("10. Mostrar todos los pedidos");
				System.out.println("11. Mostrar todos los clientes");
				System.out.println("12. Salir");
			}
			System.out.print("Selecciona: ");
			int option = KB.nextInt();	KB.nextLine();
			System.out.println();
			switch(option) {
				case 1->{
					System.out.print("Introduce el nuevo IVA: ");
					tax = KB.nextInt();
				}
				case 2->{
					System.out.print("Introduce el nombre del cliente: ");
					String name = KB.nextLine();
					System.out.print("Introduce el DNI del cliente: ");
					String id = KB.nextLine();
					costumer[counterCostumer++] = new Client(id, name, beta);
				}
				case 3->{
					System.out.print("Introduce la descripcion del pedido: ");
					String description = KB.nextLine();
					Order newPurchase = new Order(codeOrder++, description, alpha);
					boolean found = false;
					int costumerSelected = 0;
					while(!found) {
						System.out.print("Introduce el DNI del cliente al "
								+ "que le quieras añadir el pedido: ");
						String id = KB.nextLine();
						for(int i = 0 ; i<counterCostumer && !found ; i++)
							if(costumer[i].getId().contains(id)) {
								costumerSelected = i;
								found = true;
							}
						if(!found)
							System.err.println("ERROR. No existe ningun cliente con "
									+ "este DNI. Intentalo de nuevo");
					}
					costumer[costumerSelected].addOrder(newPurchase);
				}
				case 4->{
					System.out.print("Introduce el nombre del articulo: ");
					String name = KB.nextLine();
					System.out.print("Introduce el precio del articulo: ");
					double price = KB.nextDouble();
					boolean found = false;
					int costumerSelected = 0;
					int purchaseSelected = 0;
					while(!found) {
						System.out.print("Ahora introduce el codigo del pedido al "
								+ "que le quieras agregar el articulo: ");
						int code = KB.nextInt();
						for(int i = 0 ; i<counterCostumer && !found ; i++)
							for(int c = 0 ; c<costumer[i].getPurchase().length && !found ; c++)
								if(costumer[i].getPurchaseAt(c).getCode() == code) {
									found = true;
									costumerSelected = i;
									purchaseSelected = c;
								}
						if(!found)
							System.err.println("ERROR. No se ha encontrado ningun pedido "
									+ "con este codigo. Intentalo de nuevo");
					}
					costumer[costumerSelected].getPurchaseAt(purchaseSelected)
					.addItem(new Item(codeItem++, name, price));
				}
				case 5->{
					boolean found = false;
					int costumerSelected = 0;
					int purchaseSelected = 0;
					while(!found) {
						System.out.print("Introduce el codigo del pedido "
								+ "que quieras modificar: ");
						int code = KB.nextInt();	KB.nextLine();
						for(int i = 0 ; i<counterCostumer && !found ; i++)
							for(int c = 0 ; c<costumer[i].getPurchase().length && !found ; c++)
								if(costumer[i].getPurchaseAt(c).getCode() == code) {
									costumerSelected = i;
									purchaseSelected = c;
									found = true;
								}
						if(!found)
							System.err.println("ERROR. No se ha encontrado ningun pedido con "
									+ "ese codigo. Intentelo de nuevo");
					}
					System.out.print("Introduce la nueva descripcion del pedido: ");
					String description = KB.nextLine();
					costumer[costumerSelected].getPurchaseAt(purchaseSelected)
					.setDescription(description);
				}
				case 6->{
					boolean found = false;
					int costumerSelected = 0;
					while(!found) {
						System.out.print("Introduce el DNI del cliente al "
								+ "que le quieras añadir el pedido: ");
						String id = KB.nextLine();
						for(int i = 0 ; i<counterCostumer && !found ; i++)
							if(costumer[i].getId().contains(id)) {
								costumerSelected = i;
								found = true;
							}
						if(!found)
							System.err.println("ERROR. No existe ningun cliente con "
									+ "este DNI. Intentalo de nuevo");
					}
					System.out.println("pedidos de "+costumer[costumerSelected].getName()+": "
							+costumer[costumerSelected].allOrdersToString());
				}
				case 7->{
					boolean found = false;
					int costumerSelected = 0;
					int purchaseSelected = 0;
					int productSelected = 0;
					int code = 0;
					while(!found) {
						System.out.print("Ahora introduce el codigo del item "
								+ "que quieras eliminar: ");
						code = KB.nextInt();
						for(int i = 0 ; i<counterCostumer && !found ; i++)
							for(int c = 0 ; c<costumer[i].getPurchase().length && !found ; c++)
								for(int f = 0 ; f<costumer[i].getPurchaseAt(c)
										.getProduct().length && !found ; f++)
									if(costumer[i].getPurchaseAt(c)
											.getItemAt(f).getCode() == code) {
										costumerSelected = i;
										purchaseSelected = c;
										found = true;
									}
						if(!found)
							System.err.println("ERROR. No se ha encontrado ningun item "
									+ "con este codigo. Intentalo de nuevo");
					}
					costumer[costumerSelected].getPurchaseAt(purchaseSelected).deleteItem(code);
				}
				case 8->{
					double bestAmount = 0;
					int bestCostumer = 0;
					for(int i = 0 ; i<counterCostumer ; i++)
						if(costumer[i].bill(tax) > bestAmount) {
							bestAmount = costumer[i].bill(tax);
							bestCostumer = i;
						}
					System.out.println("El cliente con la factura mas alta es "
							+costumer[bestCostumer].getName()+" con un monto total de "
									+bestAmount+"€");
				}
				case 9->{
					for(int i = 0 ; i<counterCostumer ; i++)
						for(int c = 0 ; c<costumer[i].getPurchase().length ; c++)
							System.out.println(costumer[i].getPurchaseAt(c).allItemsToString());
				}
				case 10->{
					for(int i = 0 ; i<counterCostumer ; i++)
						System.out.println(costumer[i].allOrdersToString());
				}
				case 11->{
					for(int i = 0 ; i<counterCostumer ; i++)
						System.out.println(costumer[i].clientToString());
				}
				case 12->{
					exit = true;
					System.err.println("FINALIZANDO PROGRAMA... HASTA LUEGO");
				}
				default->
					System.err.println("ERROR. No hay ninguna opcion con ese valor. "
							+ "Intentelo de nuevo");
			}
			System.out.println();
		}
	}
	
}
