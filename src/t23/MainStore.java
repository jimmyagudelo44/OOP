package t23;

class MainStore {

	public static void main(String[] args) {
	
		java.util.Scanner KB = new java.util.Scanner(System.in);
		
		System.err.println("Tienda jimmu's electronics");
		
		Container.costumer = new Client[0];
		Container.purchase = new Order[0];
		Container.product = new Item[0];
		Client.clientExist = false;
		Item[] alpha = new Item[0];
		Item.itemExist = false;
		Item.tax = 1;
		Order[] beta = new Order[0];
		Order.orderExist = false;
		int codeItem = 0;
		int codeOrder = 0;

		boolean exit = false;
		while(!exit) {
			Interface.mainMenu();
			System.out.print("Selecciona: ");
			int option = Interface.select(KB.nextLine());
			switch(option) {
				case 1->{
					while(!exit) {
						Interface.add();
						System.out.print("Selecciona: ");
						option = Interface.select(KB.nextLine());
						switch(option) {
							case 1->{
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
								Container.increaseClient(new Client(id, name, beta));
								System.err.println("Nuevo Cliente: "
										+Container.costumer[Container.costumer.length-1]);
								Client.clientExist = true;
							}
							case 2->{
								System.out.print("Introduce la descripcion del pedido: ");
								String description = KB.nextLine();
								Container.increaseOrder(new Order(codeOrder++, description, alpha));
								System.err.println("Nuevo pedido: "
										+Container.purchase[Container.purchase.length-1]);
								Order.orderExist = true;
							}
							case 3->{
								System.out.print("Introduce el nombre del producto: ");
								String name = KB.nextLine();
								System.out.print("Introduce el precio del producto: ");
								double price = KB.nextDouble();	KB.nextLine();
								Container.increaseItem(new Item(codeItem++, name, price));
								System.err.println("Nuevo pedido: "+Container.product[Container.product.length-1]);
								Item.itemExist = true;
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
					exit = false;
				}
				case 2->{
					while(!exit) {
						Interface.delete();
						System.out.print("Selecciona: ");
						option = Interface.select(KB.nextLine());
						switch(option) {
							case 1->{
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
							case 2->{
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
								codeOrder--;
								if(Container.purchase.length == 0)
									Order.orderExist = false;
								if(!Container.orderArranged())
									Container.arrangeOrder();
							}
							case 3->{
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
								if(Container.product.length == 0)
									Item.itemExist = false;
								if(!Container.itemArranged())
									Container.arrangedItem();
							}
							case 4->{
								System.err.println("IVA eliminado");
								Item.tax = 0;
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
					exit = false;
				}
				case 3->{
					while(!exit) {
						Interface.modify();
						System.out.print("Selecciona: ");
						option = Interface.select(KB.nextLine());
						switch(option) {
							case 1->{
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
								while(!exit) {
									Interface.modifyClient();
									System.out.print("Selecciona: ");
									option = Interface.select(KB.nextLine());
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
								exit = false;
							}
							case 2->{
								int code = -1;
								while(!Container.orderFound(code)) {
									Interface.allOrders();
									System.out.print("Introduce el codigo del pedido "
											+ "que quieras modificar: ");
									code = KB.nextInt();	KB.nextLine();
									if(!Container.orderFound(code))
										System.err.println("No hay ningun pedido con este "
												+ "codigo. Intentalo de nuevo");
								}
								System.err.println("Modificando pedido: "+Container.searchOrder(code));
								System.out.println("Introduce la nueva descripcion del pedido: ");
								String description = KB.nextLine();
								Container.searchOrder(code).setDescription(description);
								System.err.println("Descripcion cambiada: "+Container.searchOrder(code));
							}
							case 3->{
								
							}
							case 4->{
								System.out.println("Introduce el nuevo IVA: ");
								Item.tax = KB.nextDouble();
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
					exit = false;
				}
				case 4->{
					while(!exit) {
						Interface.link();
						System.out.print("Selecciona: ");
						option = Interface.select(KB.nextLine());
						switch(option) {
							case 1->{
								String id;
								boolean inside;
								do{
									Interface.allClients();
									System.out.print("Introduce el DNI del Cliente: ");
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
										System.err.println("ERROR. Este cliente ya tiene todos "
												+ "los items de la tienda");
									}
								}while(!Container.clientFound(id) || inside);
								int code;
								boolean coincidence;
								do{
									Interface.allOrders();
									System.out.print("Introduce el codigo del pedido "
											+ "que quieras meter: ");
									code = KB.nextInt();	KB.nextLine();
									if(!Container.orderFound(code))
										System.err.println("No hay ningun pedido con este "
												+ "codigo. Intentalo de nuevo");
									coincidence = false;
									for(int i = 0 ; i<Container.searchClient(id).getPurchase()
											.length && !coincidence; i++)
										if(Container.searchClient(id).searchForOrder(code))
											coincidence = true;
									if(coincidence)
										System.err.println("Este cliente ya tiene ese pedido. "
												+ "Intentalo de nuevo");
								}while(!Container.orderFound(code) || coincidence);
								Container.searchClient(id).addOrder(Container.searchOrder(code));
								System.err.println("Pedido con codigo "+Container
										.searchOrder(code).getCode()+" vinculado a "
										+Container.searchClient(id).getName());
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
					exit = false;
				}
				case 5->{
					while(!exit) {
						Interface.unLink();
						System.out.print("Selecciona: ");
						option = Interface.select(KB.nextLine());
						switch(option) {
							case 1->{
								int code;
								do {
									Interface.allOrders();
									System.out.print("Introduce el codigo del pedido que "
											+ "quieras desvincular: ");
									code = KB.nextInt();	KB.nextLine();
									if(!Container.orderFound(code))
										System.err.println("No hay ningun codigo con ese pedido. "
												+ "Intentalo de nuevo");
								}while(!Container.orderFound(code));
								String id;
								do {
									Interface.allClientWithOrder(code);
									System.out.print("Introduce el dni del cliente al que le quieres "
											+ "desvincular este pedido: ");
									id = KB.nextLine();
								}while(!Container.clientFound(id));
								Container.searchClient(id).deleteOrder(code);
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
					exit = false;
				}
				case 6->{
					while(!exit) {
						Interface.show();
						System.out.print("Selecciona: ");
						option = Interface.select(KB.nextLine());
						switch(option) {
							case 1->{
								while(!exit) {
									Interface.allClients();
									Interface.showClients();
									System.out.print("Selecciona: ");
									option = Interface.select(KB.nextLine());
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
												System.err.println("Mostrando pedidos de: "
														+Container.searchClient(id).getName());
												for(int i = 0 ; i<Container
														.searchClient(id).getPurchase().length ; i++)
													System.out.println(Container.searchClient(id)
															.getPurchase()[i]);
											}
											else
												System.err.println("Este cliente no tiene pedidos");
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
								exit = false;
							}
							case 2->{
								while(!exit) {
									Interface.allOrders();
									Interface.showOrders();
									System.out.print("Selecciona: ");
									option = Interface.select(KB.nextLine());
									switch(option) {
										case 1->{
											int code;
											do {
												System.out.print("Introduce el codigo del pedido al que le quieras ver "
														+ "sus productos");
												code = KB.nextInt();
												if(!Container.orderFound(code))
													System.err.println("No hay ningun pedido con ese codigo. Intentalo de nuevo");
											}while(!Container.orderFound(code));
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
											System.err.println("Clientes que tienen el pedido con el codigo "
													+Container.searchOrder(code).getCode());
											boolean found = false;
											for(int i = 0 ; i<Container.costumer.length ; i++)
												if(Container.costumer[i].searchForOrder(code)) {
													System.out.println(Container.costumer[i]);
													found = true;
												}
											if(!found)
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
								exit = false;
							}
							case 3->{
								Interface.allItems();
								Interface.showItems();
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
					exit = false;
				}
				case 7->{
					exit = true;
					System.err.println("FINALIZANDO PROGRAMA. GRACIAS POR VISITAR JIMMU'S "
							+ "ELECTRONICS. またお願いします...");
				}
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
