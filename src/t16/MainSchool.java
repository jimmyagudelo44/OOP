package t16;

import java.util.Scanner;

class MainSchool {

	public static void main(String[] args) {
		
		Scanner KB = new Scanner(System.in);
		
		System.out.print("Introduce el nombre de la asignatura: ");
		String nameSubject = KB.nextLine();
		System.out.print("Introduce el año escolar del alumno: ");
		int year;
		while((year = KB.nextInt())<1 || year>2)
			System.err.println("ERROR. Este curso no esta en este centro. Intentalo de nuevo");
		System.out.print("Introduce la nota en esta asignatura: ");
		int grade = KB.nextInt();
		
		Subject asignatura = new Subject(nameSubject, year, grade);
		
		System.out.println(asignatura.subToString());
	}
	
}
