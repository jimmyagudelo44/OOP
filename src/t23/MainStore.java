package t23;

class MainStore {

	static int codeOrder;
	static int codeItem;
	
	public static void main(String[] args) {
	
		java.util.Scanner KB = new java.util.Scanner(System.in);
		
		System.err.println("Tienda jimmu's electronics");
		
		//usaremos estas arrays para meter adentro todos los nuevos objetos
		Container.costumer = new Client[0];
		Container.purchase = new Order[0];
		Container.product = new Item[0];
		//las boolean Exist se volveran true cuando creemos al menos un objeto y false si desaparecen
		Client.clientExist = false;
		Item[] alpha = new Item[0];
		Item.itemExist = false;
		Item.TAX = 1;
		Order[] beta = new Order[0];
		Order.orderExist = false;
		codeOrder = 0;
		codeItem = 0;
		
		boolean exit = false;
		while(!exit) {
			Interface.mainMenu();
			System.out.print("Selecciona: ");
			int option = Interface.select(KB.nextLine());
			switch(option) {
				case 1->{
					Operation.create(alpha, beta);
				}
				case 2->{
					Operation.delete();
				}//case 2
				case 3->{
					Operation.modify();
				}
				case 4->{
					Operation.link();
				}
				case 5->{
					Operation.unlink();
				}
				case 6->{
					Operation.show();
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
