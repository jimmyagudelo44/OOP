package t12;

import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		
		Scanner KB = new Scanner(System.in);
		
		boolean exit = false;
		char l;
		
		while(!exit) {
			
			System.out.println("A-Circulo");
			System.out.println("B-Esfera");
			System.out.println("C-Cuadrado");
			System.out.println("D-Cubo");
			System.out.println("E-Salir");
			System.out.print("Escriba la opcion a la que quieras acceder: ");
			l = KB.nextLine().charAt(0);
			
			switch(l) {
			
				case 'a':
					
					Circle circulo = new Circle();					
					System.out.print("Introduce el radio del circulo: ");
					circulo.radius = KB.nextDouble();
					KB.nextLine();
					System.out.println("Perimetro del circulo de radio "+circulo.radius+
							"cm: "+circulo.perimeter()+"cm2");
					System.out.println("Area del circulo de radio "+circulo.radius+
										"cm: "+ circulo.area()+"cm3");
					System.out.println();
					break;
					
				case 'b':
					
					Sphere esfera = new Sphere();
					System.out.print("Introduce el radio de la esfera: ");
					esfera.radius = KB.nextDouble();
					KB.nextLine();
					System.out.println("La superficie de una esfera de radio "+esfera.radius+
										"cm: "+esfera.surface()+"cm2");
					System.out.println("El volumen de una esfera de radio "+esfera.radius+
										"cm: "+esfera.volume()+"cm3");
					System.out.println();
					break;
					
				case 'c':
					
					Square cuadrado = new Square();
					System.out.print("Introduce la longitud del lado del cuadrado: ");
					cuadrado.side = KB.nextDouble();
					KB.nextLine();
					System.out.println("El perimetro de un cuadrado de lado "+cuadrado.side+
										"cm: "+cuadrado.perimeter()+"cm2");
					System.out.println("El area de un cuadrado de lado "+cuadrado.side+
										"cm: "+cuadrado.area()+"cm3");
					System.out.println();
					break;
					
				case 'd':
					
					Cube cubo = new Cube();
					System.out.print("Introduce la longitud del lado del cubo: ");
					cubo.side = KB.nextDouble();
					KB.nextLine();
					System.out.println("La superficie de un cubo de lado "+cubo.side+
										"cm: "+cubo.surface()+"cm2");
					System.out.println("El volumen de un cubo de lado "+cubo.side+
										"cm: "+cubo.volume()+"cm3");
					System.out.println();
					break;
					
				case 'e':
					System.err.println("FINALIZANDO PROGRAMA. Hasta luego.");
					exit = true;
					break;
				default:
					System.out.println();
					System.err.println("ERROR. Esa opcion no esta disponible. Intentelo de nuevo.");
			}
			
		}
	}
	
}
