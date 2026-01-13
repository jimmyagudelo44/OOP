package t17;

class Person {

	private String name;
	private int age;
	private String address;
	
	Person(String name, int age, String address){
		this.name = name;
		this.age = age;
		this.address = address;
	}
	
	String getName() {
		return name;
	}
	
	void setName(String name) {
		this.name = name;
	}

	int getAge() {
		return age;
	}

	void setAge(int age) {
		this.age = age;
	}

	String getAddress() {
		return address;
	}

	void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", address=" + address + "]";
	}
	
}
