package t18;

import java.util.Scanner;

public class MainTheatre {

	static Scanner KB = new Scanner(System.in);
	
	public static void main(String[] args) {

		Library.movie = new Movie[0];
		boolean exit = false;
		do {
			System.out.println("1. Agregar pelicula");
			System.out.println("2. Eliminar pelicula");
			System.out.println("3. Numero de peliculas");
			System.out.println("4. Calificacion promedia");
			System.out.println("5. Salir");
			int option = KB.nextInt();	KB.nextLine();
			switch(option) {
				case 1->
					addMovie();
				case 2->
					deleteMovie();
				case 3->
					movieCounter();
				case 4->
					averageRating();
				case 5->{
					exit = true;
					System.err.println("HASTA LUEGO");
				}default->
					System.err.println("Esta opcion no existe. Intentalo de nuevo");
			}
		}while(!exit);
	}

	static void addMovie(){
		System.out.print("Introduce el nombre de la peli: ");
		String name = KB.nextLine();
		System.out.print("Introduce el nombre del director: ");
		String director = KB.nextLine();
		System.out.print("Introduce la calificacion: ");
		int rating;
		do {
			rating = KB.nextInt();	KB.nextLine();
			if(rating < 0 || rating > 10)
				System.err.println("La calificacion tiene que ser del 1 al 10");
		}while(rating < 0 || rating > 10);
		Library.addMovie(new Movie(name, director, rating));
		System.err.println("Pelicula añadida: "+Library.movie[Library.movie.length-1]);
	}
	
	static void deleteMovie() {
		Library.allMoviesWithCounter();
		System.out.println("Selecciona la pelicula que quieras eliminar");
		int option;
		do {
			option = KB.nextInt();	KB.nextLine();
			if(option < 0 || option > Library.movie.length-1)
				System.err.println("Pelicula no encontrado. Intentalo de nuevo");
		}while(option < 0 || option > Library.movie.length-1);
		System.err.println("Pelicula eliminada: "+Library.movie[option]);
		Library.deleteMovie(Library.movie[option]);
	}
	
	static void movieCounter() {
		System.err.println("Numero de peliculas: "+Library.obtainMovieCounter());
	}
	
	static void averageRating() {
		System.err.println("Clasificacion promedia: "+Library.averageRate()+"/10");
	}
	
}
