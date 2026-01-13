package t18;

class Library {

	static Movie[] movie;
	
	static void addMovie(Movie m) {
		Movie[] aux = movie;
		movie = new Movie[aux.length+1];
		for(int i = 0 ; i<aux.length ; i++)
			movie[i] = aux[i];
		movie[aux.length] = m;
	}
	
	static void deleteMovie(Movie m) {
		Movie[] aux = new Movie[movie.length-1];
		boolean found = false;
		for(int i = 0 ; i<aux.length ; i++) {
			if(movie[i] == m)
				found = true;
			if(!found)
				aux[i] = movie[i];
			else
				aux[i] = movie[i+1];
		}
		movie = aux;
	}
	
	static int obtainMovieCounter() {
		return movie.length;
	}
	
	static double averageRate() {
		int total = 0;
		for(Movie m : movie)
			total += m.getRating();
		return ((double)(total))/movie.length;
	}
	
	static void allMovies() {
		for(Movie m : movie)
			System.out.println(m);
	}
	
	static void allMoviesWithCounter() {
		int counter = 0;
		for(Movie m : movie)
			System.out.println((counter++)+". "+m);
	}
	
}
