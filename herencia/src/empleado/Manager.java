package empleado;

class Manager extends Employee{

	private double bonus;

	Manager(double bonus, String name, double salary, String date, String id){
		super(name, salary, date, id);
		this.bonus = bonus;
	}

	double totalSalary() {
		return salary + bonus;
	}
	
}