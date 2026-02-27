package entity;

import entity.inter.Prey;

public class Bunny extends Animal implements Prey{

	public Bunny(int energy, String name) {
		super(energy, name);

	}

	public Bunny(String name) {
		super(name);
	}

	public Bunny() {

	}

	@Override
	public void run() {
		energy = 1;
	}

	@Override
	public void eat(int quantity) {
		energy += energy + quantity/2 > 100? 100 - energy : quantity/2;
	}
	
	@Override
	public String toString() {
		return name+": "+energy+" (CONEJO)";
	}
	
}
