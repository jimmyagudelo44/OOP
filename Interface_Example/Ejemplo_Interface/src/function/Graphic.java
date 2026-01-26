package function;

public class Graphic {

	public static void mainMenu() {
		System.out.println();
		System.out.println("1. Crear envio");
		System.out.println("2. Mostrar todos los pedidos");
		System.out.println("3. Coste total");
		System.out.println("4. Coste total del seguro");
		System.out.println("5. Modificar un pedido");
		System.out.println("6. Cambiar el estado de un envio");
		System.out.println("7. Salir");
		System.out.println();
	}
	
	public static void deliveryType() {
		System.out.println();
		System.err.println("Tipo de pedido que quieras crear");
		System.out.println("1. Estandar");
		System.out.println("2. Urgente");
		System.out.println("3. Refrigerado");
		System.out.println();
	}
	
}
