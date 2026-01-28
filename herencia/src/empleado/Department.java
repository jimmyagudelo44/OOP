package empleado;

import java.util.Arrays;
import java.util.Objects;

class Department {
	
	private String name;
	private Employee[] employee;
	
	Department(String name, Employee[] employee) {
		this.name = name;
		this.employee = employee;
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	Employee[] getEmployee() {
		return employee;
	}

	void setEmployee(Employee[] employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Department [name=" + name + ", employee=" + Arrays.toString(employee) + "]";
	}

	double totalSalary() {
		double total = 0;
		for(Employee e : employee) 
			if(!(e instanceof Employee))
				total += e.getSalary();
			else
				total += ((Manager)e).totalSalary();
		return total;
	}
	
	void addEmployee(Employee e) {
		Employee[] aux = employee;
		employee = new Employee[aux.length+1];
		for(int i = 0 ; i<aux.length ; i++)
			employee[i] = aux[i];
		employee[aux.length] = e;
	}
	
	void deleteEmployee(Employee e) {
		Employee[] aux = new Employee[employee.length-1];
		boolean found = false;
		for(int i = 0 ; i<aux.length ; i++) {
			if(employee[i].equals(e))
				found = true;
			if(!found)
				aux[i] = employee[i];
			else
				aux[i] = employee[i+1];
		}
		employee = aux;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		return Objects.equals(name, other.name);
	}
	
}