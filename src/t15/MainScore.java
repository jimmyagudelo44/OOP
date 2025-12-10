package t15;

public class MainScore {

	public static void main(String[] args) {

		java.util.Scanner KB = new java.util.Scanner(System.in); 
		
		Score partitura = new Score();
		
		boolean exit = false;
		while(!exit) {
			System.out.println(partitura.scoreToString());
			System.out.println("Numero de instrumentos: "+partitura.counterInstrument());
			System.out.println("1.Cambiar de instrumento principal");
			System.out.println("2.Cambiar un instrumento especifico");
			System.out.println("3.Añadir instrumento");
			System.out.println("4.Incrementar el tempo");
			System.out.println("5.Decrementar el tempo");
			System.out.println("6.Salir");
			System.out.print("Selecciona una opcion: ");
			int option = KB.nextInt(); KB.nextLine();
			switch(option) {
				case 1 -> {
					System.out.print("Introduce el instrumento principal nuevo: ");
					String instrument = KB.nextLine();
					partitura.setMainInstrument(instrument);
				}
				case 2 -> {
					System.out.print("Introduce la posicion del instrumento que quieras cambiar: ");
					int position;
					while((position = KB.nextInt())<0 || position>partitura.counterInstrument()-1)
						System.err.println("ERROR. Esa posicion no existe. Intentalo de nuevo");
					KB.nextLine();
					System.out.print("Ahora introduce el instrumento por el que lo quieras cambiar");
					String instrument = KB.nextLine();
					partitura.setOneInstrument(position, instrument);
				}
				case 3 -> {
					System.out.print("Introduce el instrumento que quieras añadir: ");
					String instrument = KB.nextLine();
					partitura.addInstrument(instrument);
				}
				case 4 ->
					partitura.increaseTempo();
				case 5 ->
					partitura.decreaseTempo();
				case 6 -> {
					exit = true;
					System.err.println("FINALIZANDO PROGRAMA. Hasta luego.");
				}
				default ->
					System.err.println("ERROR. No hay ninguna opcion con este numero. Intentalo de nuevo");
			}
			System.out.println();
		}
	}
	
}

