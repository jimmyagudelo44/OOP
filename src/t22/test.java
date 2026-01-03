package t22;

class test {

	public static void main(String[] args) {

		Order[] buy = new Order[3];
		Client costumer = new Client("s", "s", buy);
		costumer.clientToString();
	}

}
