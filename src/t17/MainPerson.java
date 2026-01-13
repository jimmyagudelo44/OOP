package t17;

import java.util.Scanner;

public class MainPerson {

	static Scanner KB = new Scanner(System.in);
	
	public static void main(String[] args) {
			
		AddressBook.person = new Person[0];
		
		boolean exit = false;
		do {
			System.out.println("1. Añadir persona");
			System.out.println("2. Eliminar persona");
			System.out.println("3. Mostrar numero de personas");
			System.out.println("4. Mostrar todo");
			System.out.print("Selecciona: ");
			int option = KB.nextInt();	KB.nextLine();
			switch(option) {
				case 1->{
					addPerson();
				}
				case 2->{
					deletePerson();
				}
				case 3->{
					counterPeople();
				}
				case 4->{
					showAll();
				}
				case 5->{
					exit = true;
					System.err.println("HASTA LUEGO");
				}
				default->{
					System.err.println("No hay ninguna opcion con este valor. Intentelo de nuevo");
				}
			}
		}while(!exit);
	}
	

	
	private static void addPerson(){
		System.out.print("Introduce el nombre de la persona: ");
		String name = KB.nextLine();
		System.out.print("Introduce su edad: ");
		int age = KB.nextInt();	KB.nextLine();
		System.out.print("Introduce su direccion: ");
		String address = KB.nextLine();
		AddressBook.addPerson(new Person(name, age, address));
		System.err.println("Nueva persona añadida: "
				+AddressBook.person[AddressBook.person.length-1]);
	}
	
	private static void deletePerson() {
		AddressBook.allPeople();
		System.out.print("Selecciona la persona a la que quieres eliminar: ");
		int option;
		do {
			option = KB.nextInt();	KB.nextLine();
			if(option < 0 || option > AddressBook.person.length-1)
				System.err.println("Persona inexistente. Intentelo de nuevo");
		}while(option < 0 || option > AddressBook.person.length-1);
		System.err.println("Persona eliminada: "+AddressBook.person[option]);
		AddressBook.deletePerson(AddressBook.person[option]);
	}
	
	private static void counterPeople() {
		System.err.println("Numero de personas: "+AddressBook.obtainPersonCounter());
	}
	
	private static void showAll() {
		System.out.println(AddressBook.obtainInformation());
	}
	
}


