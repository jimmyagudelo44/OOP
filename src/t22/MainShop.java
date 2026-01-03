package t22;

class MainShop {

	public static void main(String[] args) {
		
		java.util.Scanner KB = new java.util.Scanner(System.in);
		
		boolean exit = false;
		
		Order[] purchases = new Order[100];
		Client[] costumers = new Client[100];
		
		int counterCostumers = 0;
		int counterPurchases = 0;
		int codeGenerator = 0;
		
		while(!exit && counterCostumers<100 && counterPurchases<100) {
			System.out.println("1. Insertar Cliente");
			System.out.println("2. Insertar Pedido");
			if(!(counterCostumers==0 || counterPurchases==0)) {
				System.out.println("3. Insertar pedido a un determinado cliente");
				System.out.println("4. Mostrar clientes con mas pedidos");
				System.out.println("5. Mostrar pago para cliente");
				System.out.println("6. Numero de compras de un productos");
				System.out.println("7. Mostrar todos los clientes");
				System.out.println("8. Mostrar todos los pedidos");
			}
			System.out.println("9. Salir");
			System.out.print("Seleccion: ");
			int option = KB.nextInt();	KB.nextLine();	System.out.println();
			
			switch(option) {
				case 1->{
					System.out.print("Introduce el nombre del nuevo cliente: ");
					String name = KB.nextLine();
					System.out.print("Introduce el DNI del nuevo cliente: ");
					String id = KB.nextLine();
					Order[] buy = new Order[10];
					costumers[counterCostumers] = new Client(name, id, buy);
					costumers[counterCostumers++].resetPurchases();
				}
				case 2->{
					System.out.print("Introduce la descripcion del pedido: ");
					String description = KB.nextLine();
					System.out.print("Introduce el precio del pedido: ");
					Double price = KB.nextDouble();
					purchases[counterPurchases++] = new Order(description, price, codeGenerator++);
				}
				case 3->{
					if(!(counterCostumers==0 || counterPurchases==0)) {
						boolean found = false;
						int costumerSelected = 0;
						do {
						System.out.print("Introduce el DNI del cliente "
								+ "al que quieras meterle el pedido: ");
						String id = KB.nextLine();
						for(int i = 0 ; i<counterCostumers && !found; i++)
							if(costumers[i].getId().equals(id)) {
								found = true;
								costumerSelected = i;
							}
						if(!found)
							System.err.println("No se ha encontrado ningun cliente con ese DNI. "
									+ "Intentalo de nuevo");
						}while(!found);
						found = false;
						int purchaseSelected = 0;
						do {
							System.out.print("Ahora Introduce el codigo del pedido "
									+ "que quieras introducir: ");
							int code = KB.nextInt();
							for(int i = 0 ; i<counterPurchases && !found; i++)
								if(purchases[i].getCode()==code) {
									found = true;
									purchaseSelected = i;
								}
							if(!found)
								System.err.println("No se ha encontrado ningun pedido con ese codigo. "
										+ "Intentalo de nuevo");
						}while(!found);
						boolean codeFound = false;
						for(int i = 0 ; i<costumers[costumerSelected].getPurchases().length ; i++)
							if(costumers[costumerSelected].purchaseAt(i).getCode() 
									== purchases[purchaseSelected].getCode())
								codeFound = true;
						found = false;
						if(!codeFound) { 
							for(int i = 0 ; i<costumers[costumerSelected].getPurchases().length 
								&& !found ; i++)
								if(costumers[costumerSelected].purchaseAt(i).getCode()
										== -1) {
									found = true;
									costumers[costumerSelected].setPurchaseAt(i, purchases[purchaseSelected]); 
								}
						}
						else 
							found = true;
						if(!found)
							System.err.println("ERROR. Un cliente no puede tener mas de "
									+ costumers[costumerSelected].getPurchases().length+" pedidos");
						else if(codeFound)
							System.err.println("ERROR. Un mismo cliente no puede "
									+ "tener el mismo pedido 2 veces");
					}else
						if(counterCostumers==0)
							System.err.println("No hay clientes actualmente");
						else
							System.err.println("No se han realizado compras aun");
				}
				case 4->{
					int biggest = 0;
					String total = "";
					boolean equals = false;
					for(int i = 0 ; i<counterCostumers ; i++) {
						if(costumers[i].purchaseCounter()>biggest) {
							biggest = costumers[i].purchaseCounter();
							total = costumers[i].getName();
							equals = false;
						}else if(costumers[i].purchaseCounter()==biggest) {
							total += ", "+costumers[i].getName();
							equals = true;
						}
					}
					if(biggest!=0)
						if(!equals)
							System.out.println("El cliente con mas compras es "
									+total+" con "
									+biggest+" compras");
						else
							System.out.println("Los clientes con mas compras son "
									+total+" con "
									+biggest+" compras");
					else
						System.err.println("Aun no hay clientes con compras realizadas");
				}
				case 5->{
					boolean found = false;
					while(!found) {
						System.out.print("Introduce el DNI del cliente "
								+ "del que quieras ver su factura: ");
						String id = KB.nextLine();
						for(int i = 0 ; i<counterCostumers && !found ; i++)
							if(costumers[i].getId().equals(id)) {
								System.out.println("La factura de "+costumers[i].getName()
										+" es de: "+costumers[i].bill()+"€");
								found = true;
							}
						if(!found) {
							System.err.println("ERROR. No hay ningun cliente con ese DNI. "
									+ "Intentalo de nuevo");
						}
					}
				}
				case 7->{
					for(int i = 0 ; i<counterCostumers ; i++)
						System.out.println(costumers[i].clientToString());
				}
				case 8->{
					for(int i = 0 ; i<counterPurchases ; i++)
						System.out.println(purchases[i].orderToString());
				}
				case 9->{
					exit = true;
					System.err.println("FINALIZANDO PROGRAMA... HASTA LUEGO...");
				}
				default->
					System.err.println("ERROR. NO hay ninguna opcion con este numero."
							+ " Intentalo de nuevo");
			}
			
			System.out.println();
		}
	}
	
}
