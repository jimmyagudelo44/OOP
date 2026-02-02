package main;

import linkedList.MyLinkedList;
import java.util.Scanner;

public class Main {

	private static MyLinkedList<Integer> n = new MyLinkedList<Integer>();
	static Scanner KB = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.err.println("Linked List de Jimmy");
		
		boolean exit = false;
		while(!exit) {

			System.out.println();
			System.out.println("1. Añadir");
			System.out.println("2. Borrar");
			System.out.println("3. Buscar");
			System.out.println("4. Longitud");
			System.out.println("5. Mostrar todos");
			System.out.println("6. Salir");

			System.out.print("Selecciona: ");
			int option = KB.nextInt();

			switch (option) {
				case 1 ->
					add();
				case 2 ->
					delete();
				case 3 -> {
					search();
				}
				case 4 ->
					length();
				case 5->{
					printAll();
				}
				case 6 -> {
					exit = true;
					System.err.println("Finalizando programa");
				}
				default->
					System.err.println("Valor introducido no valido");
			}
			System.out.println();
		}
		
	}
	
	private static void add() {
		System.out.print("Numero nuevo: ");
		int newN = KB.nextInt();
		System.err.println(n.found(n.getStart(), newN)? "Este numero ya esta en la lista" 
				: "Numero añadido a la lista: "+newN);
		n.add(newN);
	}
	
	private static void delete() {
		System.out.print("Numero que quieras eliminar: ");
		int selected = KB.nextInt();
		System.err.println(n.found(n.getStart(), selected)? "Numero borrado de la lista: "+selected
				: "Este numero no esta en la lista");
		if(n.found(n.getStart(), selected))
			n.delete(selected);
	}
	
	private static void search() {
		System.out.print("Introduce el numero que quieras buscar: ");
		int selected = KB.nextInt();
		System.err.println(n.found(n.getStart(), selected)? "Encontrado" : "No encontrado");
	}
	
	private static void length() {
		System.err.println("Longitud de la lista: "+n.getLength());
	}
	
	private static void printAll() {
		System.out.println("Imprimiendo todos los numeros: ");
		System.err.println(n);
	}
	
}
