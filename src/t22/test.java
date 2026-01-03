package t22;

class test {

	public static void main(String[] args) {

		Order[] buy = new Order[1];
		buy[0] = new Order("Aspiradora", 50, 0);
		Client costumer = new Client("s", "s", buy);
		buy[0].discount(50);
		System.out.print(costumer.clientToString());
	}

}
