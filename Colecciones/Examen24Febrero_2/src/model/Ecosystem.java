package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import entity.Animal;
import entity.Bunny;
import entity.Lion;
import entity.inter.Predator;
import entity.inter.Prey;

public class Ecosystem {

	private static List<Animal> animal = new ArrayList<Animal>();
	private static Random RNG = new Random();
	
	public static void main(String[] args) {
		
		createSpecificAnimals();
		
		feedRandom();
		
		printAll();
		
		if(!firstPredatorGoesNuts()) {
			System.err.println("El leon no ha cazado a ninguna presa. Procede a morirse");
			animal.remove(firstPredator());
		}
		
		printAll();
	}
	
	private static void createSpecificAnimals() {
		animal.add(new Bunny("Hector"));
		animal.add(new Lion("Nini"));
		animal.add(new Bunny("Rafael"));
		animal.add(new Bunny("Ricardo"));
		animal.add(new Lion("Sofia"));
		animal.add(new Bunny("Vulgarcito"));
	}
	
	private static void feedRandom() {
		for (Animal x : animal)
			x.eat(RNG.nextInt(1, 61));
	}
	
	private static void printAll() {
		for (Animal x : animal)
			System.out.println(x);
	}
	
	private static boolean firstPredatorGoesNuts() {
		boolean oneKill = false;
		Animal predator = firstPredator();
		List<Animal> dead = new ArrayList<Animal>();
		
		for(Animal x : animal)
			if(x instanceof Prey && ((Predator)predator).hunt(x)) {
				System.out.println("El leon cazo a su presa");
				oneKill = true;
				dead.add(x);
				
			}else if(x instanceof Prey)
				System.out.println("La presa huyo");
		
		animal.removeAll(dead);
		
		return oneKill;
	}
	
	private static Animal firstPredator() {
		boolean found = false;
		Animal x = null;
		for(int i = 0 ; i<animal.size() && !found ; i++)
			if(animal.get(i) instanceof Predator) {
				found = true;
				x = animal.get(i);
			}
		return x;
	}
	
}
