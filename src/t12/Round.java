package t12;

public class Round {
	
	private int decimal;
	
	/**
	 * 
	 * @param decimal introduce el numero de decimales que quieras
	 */
	public Round(int decimal){
		this.decimal = decimal;
	}
	
	public int getDecimal() {
		return decimal;
	}
	
	public void setDecimal(int decimal) {
		this.decimal = decimal;
	}
	
	/**
	 * 
	 * @param operator el numero que quieras redondear
	 * @return el numero redondeado
	 */
	public double rounder(double operator) {
		int quantity = 1;
		for(int i = 0 ; i<decimal ; i++)
				quantity *= 10; 
		return (double)((int)(operator*quantity))/quantity;
	}
}
