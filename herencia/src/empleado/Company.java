package empleado;

class Company {

	String name;
	Department[] department;
	
	public Company(String name, Department[] department) {
		this.name = name;
		this.department = department;
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	Department[] getDepartment() {
		return department;
	}

	void setDepartment(Department[] department) {
		this.department = department;
	}
	
	double totalSalary() {
		double total = 0;
		for(Department d : department)
			total += d.totalSalary();
		return total;
	}
	
	void addDepartment(Department d) {
		Department[] aux = department;
		department = new Department[aux.length+1];
		for(int i = 0 ; i<aux.length ; i++)
			department[i] = aux[i];
		department[aux.length] = d;
	}
	
	void deleteDepartment(Department d) {
		Department[] aux = new Department[department.length-1];
		boolean found = false;
		for(int i = 0 ; i<aux.length ; i++) {
			if(department[i].equals(d))
				found = true;
			if(!found)
				aux[i] = department[i];
			else
				aux[i] = department[i+1];
		}
		department = aux;
	}
	
}