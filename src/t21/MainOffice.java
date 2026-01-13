package t21;

import java.util.Scanner;

public class MainOffice {

	static Scanner KB = new Scanner(System.in);
	static Department[] department = new Department[0];
	
	public static void main(String[] args) {
		
		Employee[] alpha = new Employee[0];
		
		System.out.print("Introduce el DNI del director: ");
		String nifD = KB.nextLine();
		System.out.print("Introduce su nombre: ");
		String nameD = KB.nextLine();
		System.out.print("Introduce su salario: ");
		Double salaryD = KB.nextDouble();	KB.nextLine();
		
		System.out.print("Introduce el nombre del departamento: ");
		String nameDep = KB.nextLine();
		
		Employee boss = new Employee(nifD, nameD, salaryD);
		Department dep = new Department(nameDep, boss, alpha);
		addDepartment(dep);
		
		String yesOrNo;
		do {
			System.out.print("Introduce el DNI del empleado: ");
			String nifE = KB.nextLine();
			System.out.print("Introduce su nombre: ");
			String nameE = KB.nextLine();
			System.out.print("Introduce su salario: ");
			Double salaryE = KB.nextDouble();	KB.nextLine();
			dep.addEmployee(new Employee(nifE, nameE, salaryE),dep);
			System.out.print("Quieres añadir otro empleado? (s/n)");
			yesOrNo = KB.nextLine();
		}while(yesOrNo.equals("s"));
		
		System.out.println("Salario promedio del departamento: "+dep.averageSalary()+"€");
		
		System.out.println("*Ha venido otro empleado mas*");
		System.out.print("Su nif es: ");
		String nifN = KB.nextLine();
		System.out.print("Su nombre es: ");
		String nameN = KB.nextLine();
		System.out.print("Le vamos a pagar: ");
		double salaryN = KB.nextDouble();
		Employee newOne = new Employee(nifN, nameN, salaryN);
		dep.addEmployee(newOne, dep);
		
		System.err.println("HAN ASCENDIDO AL NUEVO");
		dep.newDirector(newOne);
		System.out.println("El nuevo jefe del departamento es: "+newOne);
	}
	
	static void addDepartment(Department d){
		Department[] aux = department;
		department = new Department[aux.length+1];
		for(int i = 0 ; i<aux.length ; i++)
			department[i] = aux[i];
		department[aux.length] = d;
	}
	
	static void deleteDepartment(Department d) {
		Department[] aux = new Department[department.length-1];
		boolean found = false;
		for(int i = 0 ; i<aux.length ; i++) {
			if(department[i] == d)
				found = true;
			if(!found)
				aux[i] = department[i];
			else
				aux[i] = department[i+1];
		}
		department = aux;
	}
}
