package empleado;

class TemporalEmployee extends Employee{

	private String finalDate;
	
	TemporalEmployee(String finalDate, String name, double salary, String date, String id) {
		super(name, salary, date, id);
		this.finalDate = finalDate;
	}

	String getFinalDate() {
		return finalDate;
	}

	void setFinalDate(String finalDate) {
		this.finalDate = finalDate;
	}

	@Override
	public String toString() {
		return "TemporalEmployee [finalDate=" + finalDate + "]";
	}
	
}