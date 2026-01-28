package empleado;

class Employee {

	protected String name;
	protected double salary;
	protected String date;
	protected String id;
	
	

	public Employee(String name, double salary, String date, String id) {
		this.name = name;
		this.salary = salary;
		this.date = date;
		this.id = id;
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	double getSalary() {
		return salary;
	}

	void setSalary(double salary) {
		this.salary = salary;
	}

	String getDate() {
		return date;
	}

	void setDate(String date) {
		this.date = date;
	}	

	String getId() {
		return id;
	}

	void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", date=" + date + "]";
	}
	
	@Override
	public boolean equals(Object e) {
		if(id.equals(((Employee)e).getId()))
			return true;
		else
			return false;
	}
	
}