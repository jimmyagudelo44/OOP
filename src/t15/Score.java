package t15;

public class Score {

	java.util.Scanner KB = new java.util.Scanner(System.in);
	
	private String author;
	private String instrument;
	private int tempo;
	
	Score(){
		System.out.print("Introduce el nombre del autor: ");
		author = KB.nextLine();
		System.out.print("Introduce el instrumento: ");
		instrument = KB.nextLine();
		System.out.print("Introduce el tempo (pulsaciones/minuto): ");
		while((tempo = KB.nextInt())<0)
			System.err.println("ERROR. El tempo no puede ser negativo. Intentalo de nuevo");
	}
	
	String getAuthor() {
		return author;
	}
	
	void setAuthor(String author) {
		this.author = author;
	}
	
	String getInstrument() {
		return instrument;
	}
	
	void setInstrument(String instrument) {
		this.instrument = instrument;
	}
	
	/**
	 * 
	 * @param mainInstrument nuevo instrumento principal que ira el primero de todos en la lista
	 */
	void setMainInstrument(String mainInstrument) {
		boolean coma = false;
		String otherInstruments = "";
		for(int i = 0 ; i<instrument.length() ; i++) {
			if(instrument.charAt(i)==',')
				coma = true;
			if(coma)
				otherInstruments += instrument.charAt(i);
		}
		mainInstrument += otherInstruments;
		instrument = mainInstrument;
	}
	
	int getTempo() {
		return tempo;
	}
	
	void setTempo(int tempo) {
		this.tempo = tempo;
	}
	
	/**
	 * suma 10 al tempo
	 */
	void increaseTempo() {
		tempo += 10;
	}
	
	/**
	 * resta 10 al tempo
	 */
	void decreaseTempo() {
		tempo -= 10;
	}
	
	/**
	 * 
	 * @return concatenacion de los atributos de Score
	 */
	String scoreToString() {
		return "Autor: "+author+". Instrumentos: "+instrument+". Tempo: "+tempo;
	}
	
	/**
	 * concatena el instrumento añadido en el parametro con el nuevo al que se le da
	 * @param instrument
	 */
	void addInstrument(String instrument) {
		this.instrument += ", "+instrument;
	}
	
	int counterInstrument() {
		int counter = 1;
		for(int i = 0 ; i<instrument.length() ; i++)
			if(instrument.charAt(i)==',')
				counter++;
		return counter;
	}

}
