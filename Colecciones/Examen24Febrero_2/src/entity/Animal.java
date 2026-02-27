package entity;

abstract public class Animal {

	protected int energy = 1;
	protected String name;
	
	public Animal(int energy, String name) {
		this.energy = energy < 1? 1 : energy > 100? 100 : energy;
		this.name = name;
	}
	
	public Animal(String name) {
		this.name = name;
	}
	
	public Animal() {

	}

	public int getEnergy() {
		return energy;
	}
	
	public void setEnergy(int energy) {
		this.energy = energy < 1? 1 : energy > 100? 100 : energy;
	}
	
	abstract public void eat(int quantity);

	@Override
	public String toString() {
		return name+": "+energy;
	}
	
}
