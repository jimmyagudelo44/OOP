package t16;

class Subject {

	private String name;
	private int year;
	private int grade;
	
	Subject(String name, int year, int grade){
		this.name = name;
		this.year = year;
		this.grade = grade;
	}
	
	Subject(String name, int year){
		this.name = name;
		this.year = year;
		grade = -1;
	}
	
	void setName(String name) {
		this.name = name;
	}
	
	String getName() {
		return name;
	}

	int getYear() {
		return year;
	}

	void setYear(int year) {
		this.year = year;
	}

	int getGrade() {
		return grade;
	}

	void setGrade(int grade) {
		this.grade = grade;
	}
	
	void rate(int grade) {
		this.grade = grade;
	}
	
	int result() {
		return grade;
	}
	
	String subToString() {
		return "Nombre "+name+", "+year+"º ESO,"+" nota: "+grade;
	}
	
		
}
