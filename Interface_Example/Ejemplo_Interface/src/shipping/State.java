package shipping;

import java.util.Scanner;

public enum State {

	CREADO, ENVIADO, RECIBIDO, DEVUELTO;
	
	public static State readState() {
		Scanner KB = new Scanner(System.in);
		String word = KB.nextLine();
		State newState = null;
		for(State s : values())
			if(word.equalsIgnoreCase(s.name()))
				newState = s;
		return newState;
	}
	
}
