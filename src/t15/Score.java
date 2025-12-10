package t15;

public class Score {

	java.util.Scanner KB = new java.util.Scanner(System.in);
	
	private String author;
	private String[] instrument;
	private int tempo;
	
	Score(){
		System.out.print("Introduce el nombre del autor: ");
		author = KB.nextLine();
		System.out.print("Introduce el tempo (pulsaciones/minuto): ");
		while((tempo = KB.nextInt())<0)
			System.err.println("ERROR. El tempo no puede ser negativo. Intentalo de nuevo");
		System.out.print("Introduce los instrumentos que vas a meter: ");
		int cap;
		while((cap = KB.nextInt())<1)
			System.err.println("ERROR. El numero de instrumentos tiene que ser 1 al menos. "
					+ "Intentalo de nuevo");
		KB.nextLine();
		instrument = new String[cap];
		System.out.println("Ahora introduce los instrumentos");
		for(int i = 0 ; i<cap ; i++) {
			System.out.print(i+"º: ");
			instrument[i] = KB.nextLine();
		}
	}
	
	String getAuthor() {
		return author;
	}
	
	void setAuthor(String author) {
		this.author = author;
	}
	
	String getOneInstrument(int position) {
		return instrument[position];
	}
	
	String getAllInstruments() {
		String total = "";
		for(int i = 0 ; i<instrument.length ; i++)
			if(i!=instrument.length-1)
				total += instrument[i]+", ";
			else
				total += instrument[i];
		return total;
	}
	
	void setOneInstrument(int position, String instrument) {
		this.instrument[position] = instrument;
	}
	
	void setAllInstrument() {
		System.out.print("Introduce el numero de instrumentos que vas a meter: ");
		int cap;
		while((cap = KB.nextInt())<1)
			System.err.println("ERROR. Tienes que meter al menos 1");
		instrument = new String[cap];
		for(int i = 0 ; i<cap ; i++) {
			System.out.print(i+"º: ");
			instrument[i] = KB.nextLine();
		}
	}
	
	/**
	 * 
	 * @param mainInstrument nuevo instrumento principal que ira el primero de todos en la lista
	 */
	void setMainInstrument(String mainInstrument) {
		instrument[0] = mainInstrument;
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
		String total = "";
		for(int i = 0 ; i<instrument.length ; i++)
			if(i!=instrument.length-1)
				total += instrument[i]+", ";
			else
				total += instrument[i];
		return "Autor: "+author+". Instrumentos: "+total+". Tempo: "+tempo;
	}
	
	/**
	 * concatena el instrumento añadido en el parametro con el nuevo al que se le da
	 * @param instrument
	 */
	void addInstrument(String instrument) {
		String[] aux = new String[this.instrument.length];
		for(int i = 0 ; i<aux.length ; i++)
			aux[i] = this.instrument[i];
		this.instrument = new String[aux.length+1];
		for(int i = 0 ; i<aux.length ; i++)
			this.instrument[i] = aux[i];
		this.instrument[this.instrument.length-1] = instrument;
	}
	
	int counterInstrument() {
		return instrument.length;
	}

}
