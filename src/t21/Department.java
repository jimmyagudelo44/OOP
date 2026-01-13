package t21;

import java.util.Arrays;

class Department {

	private String name;
	private Employee director;
	private Employee[] workers;
	
	Department(String name, Employee director, Employee[] workers) {
		this.name = name;
		this.director = director;
		this.workers = workers;
	}
	
	String getName() {
		return name;
	}
	
	void setName(String name) {
		this.name = name;
	}
	
	Employee getDirector() {
		return director;
	}
	
	void setDirector(Employee director) {
		this.director = director;
	}
	
	Employee[] getWorkers() {
		return workers;
	}
	
	void setWorkers(Employee[] workers) {
		this.workers = workers;
	}
	
	@Override
	public String toString() {
		return "Department [name=" + name + ", director=" + director + ", workers=" + Arrays.toString(workers) + "]";
	}
	
	double averageSalary() {
		double total = 0;
		for(Employee e : workers)
			total += e.getSalary();
		total += director.getSalary();
		return total/workers.length+1;
	}
	
	void newDirector(Employee director) {
		if(employeeInDepartment(director)) {
			deleteEmployee(this.director);
			this.director = director;
		}
		else
			System.err.println("Empleado no pertenece a departamento");
	}
	
	boolean employeeInDepartment(Employee employee) {
		boolean found = false;
		for(int i = 0 ; i<workers.length && !found ; i++)
			if(workers[i] == employee)
				found = true;
		return found;
	}
	
	void addEmployee(Employee e, Department d) {
		Employee[] aux = workers;
		workers = new Employee[aux.length+1];
		for(int i = 0 ; i<aux.length ; i++)
			aux[i] = workers[i];
		workers[aux.length] = e;
		e.setDepartment(d);
	}
	
	void deleteEmployee(Employee e) {
		Employee[] aux = new Employee[workers.length-1];
		boolean found = false;
		for(int i = 0 ; i<aux.length ; i++) {
			if(workers[i] == e)
				found = true;
			if(!found)
				aux[i] = workers[i];
			else
				aux[i] = workers[i+1];
		}
		workers = aux;
		e.setDepartment(null);
	}
	
}
