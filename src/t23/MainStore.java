package t23;

class MainStore {

	public static void main(String[] args) {
	
		java.util.Scanner KB = new java.util.Scanner(System.in);
		
		System.err.println("Tienda jimmu's electronics");
		
		Container.costumer = new Client[0];
		Container.purchase = new Order[0];
		Container.product = new Item[0];
		Client.clientExist = false;
		int counterCostumer = 0;
		int counterPurchase = 0;
		int counterProduct;
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
			System.out.println();
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
								Container.increaseClient();
								Container.costumer[counterCostumer] 
										= new Client(id, name, beta);
								System.out.println("Nuevo Cliente: "
										+Container.costumer[counterCostumer++]);
								Client.clientExist = true;
							}
							case 2->{
								System.out.print("Introduce la descripcion del pedido: ");
								String description = KB.nextLine();
								Container.increaseOrder();
								Container.purchase[counterPurchase] 
										= new Order(codeOrder++, description, alpha);
								System.out.println("Nuevo pedido: "
										+Container.purchase[counterPurchase++]);
								Order.orderExist = true;
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
						System.out.println();
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
									for(int i = 0 ; i<counterCostumer ; i++)
										System.out.println(Container.costumer[i]);
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
								counterCostumer--;
								if(counterCostumer==0)
									Client.clientExist = false;
							}
							case 2->{
								int code;
								do{
									for(int i = 0 ; i<counterPurchase ; i++)
										System.out.println(Container.purchase[i]);
									System.out.print("Introduce el codigo del pedido "
											+ "que quieras eliminar: ");
									code = KB.nextInt();	KB.nextLine();
									if(Container.orderFound(code))
											System.err.println("Pedido eliminado: "
													+Container.searchOrder(code));
									if(!Container.orderFound(code))
										System.err.println("No hay ningun pedido con este "
												+ "codigo. Intentalo de nuevo");
								}while(!Container.orderFound(code));
								Container.decreaseOrder(code);
								counterPurchase--;
								codeOrder--;
								if(counterPurchase==0)
									Order.orderExist = false;
								if(!Container.orderArranged())
									Container.arrangeOrder();
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
						System.out.println();
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
									for(int i = 0 ; i<counterCostumer ; i++)
										System.out.println(Container.costumer[i]);
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
									System.out.println();
								}
								exit = false;
							}
							case 2->{
								int code = -1;
								while(!Container.orderFound(code)) {
									for(int i = 0 ; i<counterPurchase ; i++)
										System.out.println(Container.purchase[i]);
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
						System.out.println();
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
								do{
									for(int i = 0 ; i<counterCostumer ; i++)
										System.out.println(Container.costumer[i]);
									System.out.print("Introduce el DNI del Cliente: ");
									id = KB.nextLine();
									if(!Container.clientFound(id))
										System.err.println("ERROR. No se ha encontrado a nadie "
												+ "con ese DNI. Intentelo de nuevo");
								}while(!Container.clientFound(id));
								int code;
								boolean coincidence;
								do{
									for(int i = 0 ; i<counterPurchase ; i++)
										System.out.println(Container.purchase[i]);
									System.out.print("Introduce el codigo del pedido "
											+ "que quieras meter: ");
									code = KB.nextInt();	KB.nextLine();
									if(!Container.orderFound(code))
										System.err.println("No hay ningun pedido con este "
												+ "codigo. Intentalo de nuevo");
									coincidence = false;
									for(int i = 0 ; i<Container.searchClient(id).getPurchase()
											.length && !coincidence; i++)
										if(Container.searchOrder(code) 
												== Container.searchClient(id).getPurchase()[i])
											coincidence = true;
									if(coincidence)
										System.err.println("Este cliente ya tiene ese pedido. "
												+ "Intentalo de nuevo");
								}while(!Container.orderFound(code) || coincidence);
								Container.searchClient(id).addOrder(Container.searchOrder(code));
								System.out.println("Pedido con codigo "+Container
										.searchOrder(code).getCode()+" añadido a "
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
						System.out.println();
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
								for(int i = 0 ; i<counterCostumer ; i++)
									System.out.println(Container.costumer[i]);
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
						System.out.println();
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
								for(int i = 0 ; i<counterCostumer ; i++)
									System.out.println(Container.costumer[i]);
							}
							case 2->{
								for(int i = 0 ; i<counterPurchase ; i++)
									System.out.println(Container.purchase[i]);
							}
							case 3->{
								System.out.println(Container.orderArranged());
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
						System.out.println();
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
			System.out.println();
		}
	}
	
}
