package entity;

import entity.inter.Predator;
import entity.inter.Prey;

public class Lion extends Animal implements Predator {

	public Lion(int energy, String name) {
		super(energy, name);
	}

	public Lion(String name) {
		super(name);
	}

	public Lion() {

	}

	@Override
	public boolean hunt(Animal prey) {
		boolean kill = false;
		if(energy >= prey.energy) {
			kill = true;
			eat(prey.energy);
		}else {
			((Prey)prey).run();
			energy -= energy/2;
		}
		return kill;
	}

	@Override
	public void eat(int quantity) {
		energy += energy + quantity > 100? 100 - energy : quantity;
	}

	@Override
	public String toString() {
		return name+": "+energy+" (LEON)";
	}

}
