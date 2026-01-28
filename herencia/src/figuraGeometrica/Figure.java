package figuraGeometrica;

class Figure {

	protected String name;
	protected int sideNumber;
	
	Figure(String name, int sideNumber) {
		super();
		this.name = name;
		this.sideNumber = sideNumber;
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	int getSideNumber() {
		return sideNumber;
	}

	void setSideNumber(int sideNumber) {
		this.sideNumber = sideNumber;
	}

	@Override
	public String toString() {
		return "Figure [name=" + name + ", sideNumber=" + sideNumber + "]";
	}
	
}
