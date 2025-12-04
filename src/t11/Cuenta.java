package t11;

class Cuenta {

	String owner;
	double funds;
	
	double deposit(double quantity) {
		if(quantity>0)
			return funds+quantity;
		else
			return funds;
	}
	
	double withdraw(double quantity) {
		if(quantity>0)
			if(funds-quantity<0)
				return 0;
			else
				return funds-quantity;
		else
			return funds;
	}
	
}
