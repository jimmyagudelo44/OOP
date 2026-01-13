package t21;

class Employee {

	private String nif;
	private String name;
	private double salary;
	private Department department;
	
	Employee(String nif, String name, double salary) {
		super();
		this.nif = nif;
		this.name = name;
		this.salary = salary;
	}

	String getNif() {
		return nif;
	}

	void setNif(String nif) {
		this.nif = nif;
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

	Department getDepartment() {
		return department;
	}

	void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [nif=" + nif + ", name=" + name + ", salary=" + salary + ", department="+
				(department == null? department : "Empleado sin departamento ") + "]";
	}
	
	void printBoss() {
		System.out.println("Jefe de "+name+": "+department.getDirector());
	}
	
}
