package t1;

class Prueba {

	public static void main(String[] args) {

		Persona pepe = new Persona();
		pepe.name = "Pepe";
		pepe.age = 20;
		System.out.println("nombre: "+pepe.name+", edad: "+pepe.age);
		pepe.greetings();
		pepe.bye();
		
		Persona ana = new Persona();
		ana.name = "Ana";
		ana.age = 18;
		
		ana.greetings();
		ana.bye();
		
		Persona aux = pepe;
		aux.greetings();
		
		Persona anaux = ana;
		ana = aux;
		ana.greetings();
		anaux.greetings();
	}

}
