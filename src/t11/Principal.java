package t11;

import java.util.Scanner;

class Principal {

	public static void main(String[] args) {

		Scanner KB = new Scanner(System.in);
		
		Cuenta account = new Cuenta();
		System.out.print("Introduzca el nombre del propietario de la cuenta: ");
		account.owner = KB.nextLine();
		System.out.print("Introduzca sus fondos actuales: ");
		account.funds = KB.nextDouble();
		
		int opt;
		boolean exit = false;
		while(!exit) {
			
			System.out.println("Cuenta del sr."+account.owner);
			System.out.println("Fondos: "+account.funds+"€");
			System.out.println("¿Que operacion desea realizar? ");
			System.out.println("1.Ingresar");
			System.out.println("2.Retirar");
			System.out.println("3.Salir");
			
			System.out.print("Opcion: ");
			opt = KB.nextInt();
			switch(opt) {
				
				case 1:
					
					System.out.print("¿Cuanto dinero desea ingresar? ");
					double quantityDeposit = KB.nextDouble();
					account.funds = account.deposit(quantityDeposit);
					System.out.println();
					break;
					
				case 2:
					
					System.out.print("¿Cuanto dinero desea retirar? ");
					double quantityWithdraw = KB.nextDouble();
					account.funds = account.withdraw(quantityWithdraw);
					System.out.println();
					break;
					
				case 3:
					exit = true;
					System.err.println("FINALIZANDO PROGRAMA. Que tenga un buen dia");
					break;
				default:
					System.err.println("ERROR. no hay ninguna opcion con este numero");
					System.out.println();
			}
		}
	}

}
