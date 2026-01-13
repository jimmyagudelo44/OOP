package t17;

public class AddressBook {

	static Person[] person;
	
	static void addPerson(Person p) {
		Person[] aux = person;
		person = new Person[aux.length+1];
		for(int i = 0 ; i<aux.length ; i++)
			person[i] = aux[i];
		person[aux.length] = p;
	}
	
	static void deletePerson(Person p) {
		Person[] aux = new Person[person.length-1];
		boolean found = false;
		for(int i = 0 ; i<aux.length ; i++) {
			if(person[i] == p)
				found = true;
			if(!found)
				aux[i] = person[i];
			else
				aux[i] = person[i+1];
		}
		person = aux;
	}
	
	static int obtainPersonCounter() {
		return person.length;
	}
	
	static String obtainInformation() {
		String total = "";
		for(Person p : person)
			total = p+" -- ";
		return "La libreta contiene "+person.length+" personas: "+total;
	}
	
	static void allPeople() {
		int counter = 0;
		for(Person p : person)
			System.out.println((counter++)+". "+p);
	}
	
}
