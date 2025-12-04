package t12;

class Round {
	
	int decimal;
	
	double rounder(double operator) {
		int quantity = 1;
		for(int i = 0 ; i<decimal ; i++) {
				quantity *= 10; 
		}
		return (double)((int)(operator*quantity))/quantity;
	}
}
