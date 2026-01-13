package t18;

class Movie {

	private String title;
	private String director;
	private int rating;
	
	public Movie(String title, String director, int rating) {
		this.title = title;
		this.director = director;
		this.rating = rating;
	}
	String getTitle() {
		return title;
	}
	void setTitle(String title) {
		this.title = title;
	}
	String getDirector() {
		return director;
	}
	void setDirector(String director) {
		this.director = director;
	}
	int getRating() {
		return rating;
	}
	void setRating(int rating) {
		this.rating = rating;
	}
	
	@Override
	public String toString() {
		return "Movie [title=" + title + ", director=" + director + ", rating=" + rating + "]";
	}
	
}
