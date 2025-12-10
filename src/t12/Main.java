package t12;

import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		
		Scanner KB = new Scanner(System.in);
		
		boolean exit = false;
		char l;
		Round redondeo = new Round(2);
		
		while(!exit) {
			
			System.out.println("A-Circulo");
			System.out.println("B-Esfera");
			System.out.println("C-Cuadrado");
			System.out.println("D-Cubo");
			System.out.println("E-Cambiar el numero de decimales");
			System.out.println("F-Salir");
			System.out.print("Escriba la opcion a la que quieras acceder: ");
			l = KB.nextLine().charAt(0);
			if(l=='A' || l=='B' || l=='C' || l=='D' || l=='E' || l=='F')
				l +=32;
			
			switch(l) {
			
				case 'a':
					
					Circle circulo = new Circle();					
					System.out.print("Introduce el radio del circulo: ");
					circulo.radius = KB.nextDouble();
					System.out.println("Perimetro del circulo de radio "+circulo.radius+
							"cm: "+redondeo.rounder(circulo.perimeter())+"cm2");
					System.out.println("Area del circulo de radio "+circulo.radius+
										"cm: "+redondeo.rounder(circulo.area())+"cm3");
					System.out.println();
					break;
					
				case 'b':
					
					Sphere esfera = new Sphere();
					System.out.print("Introduce el radio de la esfera: ");
					esfera.radius = KB.nextDouble();
					System.out.println("La superficie de una esfera de radio "+esfera.radius+
										"cm: "+redondeo.rounder(esfera.surface())+"cm2");
					System.out.println("El volumen de una esfera de radio "+esfera.radius+
										"cm: "+redondeo.rounder(esfera.volume())+"cm3");
					System.out.println();
					break;
					
				case 'c':
					
					Square cuadrado = new Square();
					System.out.print("Introduce la longitud del lado del cuadrado: ");
					cuadrado.side = KB.nextDouble();
					System.out.println("El perimetro de un cuadrado de lado "+cuadrado.side+
										"cm: "+redondeo.rounder(cuadrado.perimeter())+"cm2");
					System.out.println("El area de un cuadrado de lado "+cuadrado.side+
										"cm: "+redondeo.rounder(cuadrado.area())+"cm3");
					System.out.println();
					break;
					
				case 'd':
					
					Cube cubo = new Cube();
					System.out.print("Introduce la longitud del lado del cubo: ");
					cubo.side = KB.nextDouble();
					System.out.println("La superficie de un cubo de lado "+cubo.side+
										"cm: "+redondeo.rounder(cubo.surface())+"cm2");
					System.out.println("El volumen de un cubo de lado "+cubo.side+
										"cm: "+redondeo.rounder(cubo.volume())+"cm3");
					System.out.println();
					break;
					
				case 'e':
					
					System.out.println("Introduce el numero de decimales con los que quieras redondear");
					redondeo.setDecimal(KB.nextInt()); 
					while(redondeo.getDecimal()<0) {
						System.err.println("ERROR. El numero introducido no puede ser negativo");
						System.out.print("Intentalo de nuevo: ");
						redondeo.setDecimal(KB.nextInt());
					}
					System.out.println();
					break;
					
				case 'f':
					System.err.println("FINALIZANDO PROGRAMA. Hasta luego.");
					exit = true;
					break;
				default:
					System.out.println();
					System.err.println("ERROR. Esa opcion no esta disponible. Intentelo de nuevo.");
			}
			if(l=='a' || l=='b' || l=='c' || l=='d' || l=='e')
				KB.nextLine();
			
		}
	}
	
}
