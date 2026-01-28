package empleado;

import java.util.Scanner;

class MainEmployee {
	
	static Scanner KB = new Scanner(System.in);
	static Company company;

	public static void main(String[] args) {
		
		Employee[] employeeX = new Employee[0];
		Department[] departmentX = new Department[0];
		System.out.print("Introduce el nombre de la empresa: ");
		company = new Company(KB.nextLine(), departmentX);
		for(int i = 0 ; i<4 ; i++) {
			System.out.println("Introduce el nombre del "+(i+1)+ "º departamento: ");
			company.addDepartment(new Department(KB.nextLine(), employeeX));
		}
		
		boolean exit = false;
		do {
			System.out.println("1. Añadir empleado a departamento");
			System.out.println("2. Mostrar salario total de la empresa");
			System.out.println("3. Departamento con mas salario");
			System.out.print("Selecciona: ");
			int option = KB.nextInt();	KB.nextLine();
			switch(option) {
				case 1->{
						printAllDepartments();
						addEmployeeToDepartment();
				}case 2->{
					
				}case 3->{
					
				}default->{
					System.err.println("HASTA LUEGO...");
					exit = true;
				}
			}
		}while(!exit);
		
	}
	
	static void printAllDepartments() {
		for(int i = 0 ; i<company.getDepartment().length ; i++)
			System.out.println(company.getDepartment()[i]);
	}
	
	static void addEmployeeToDepartment() {
		
	}
	
}