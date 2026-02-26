package model;

import java.util.Random;
import java.util.Scanner;

import entity.Planificator;
import entity.Process;

public class SO {

	private static Planificator planificator = new Planificator();
	private static Random RNG = new Random();
	private static Scanner KB = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		addRandom();
		execute();

		printAll();		
		
		delete();
		
		printAll();
	}

	private static void printAll() {
		System.out.println("PENDIENTES");
		for(Process x : planificator.getPending())
			System.out.println(x);
		System.out.println("EJECUTANDOSE");
		for(Process x : planificator.getExecuting())
			System.out.println(x);
	}
	
	private static void addRandom() {
		System.out.print("Cuantos procesos quieres: ");
		int length = KB.nextInt();
		KB.nextLine();
		for(int i = 0 ; i<length ; i++)
			planificator.addPendingProcess(RNG.nextInt(11), RNG.nextInt(101));
	}
	
	private static void execute() {
		System.out.print("Cuantos procesos quieres ejecutar: ");
		int length = KB.nextInt();
		KB.nextLine();
		for(int i = 0 ; i<length ; i++)
			planificator.execute();
	}
	
	private static void arrangeByPID() {
		System.out.println("LISTA DE EJECUCION ORDENADA POR PID");
		for(Process x : planificator.listExecution())
			System.out.println(x);
	}
	
	private static void delete() {
		System.out.print("Introduce el pid del proceso que quieras abortar: ");
		int pid = KB.nextInt();
		KB.nextLine();
		if(planificator.abortExecution(pid))
			System.out.println("Se ha borrado el proceso con el PID: "+pid);
		else
			System.err.println("No se ha encontrado ningun proceso con ese PID");
	}
	
}
