// can only have one public class in a .java file
class Person {
	// Classes can contain
	// - Data representing state of object i.e instance vars
	// - Subroutines/methods representing behaviour
	String name;
	int age;
	
	void speak() {
		System.out.printf("My name is %s and I am %d years old.\n", name, age);
	}
	
	int calculateYearsToRetirement() {
		return 65 - age;
	}
	
	int getAge() {
		return age;
	}
	
	String getName() {
		return name;
	}
}


public class ClassesAndObjects {
	public static void main(String[] args) {
		Person jake  = new Person();
		jake.name = "Jake Bloggs";
		jake.age = 37;
		
		Person sarah = new Person();
		sarah.name = "Sarah Smith";
		sarah.age = 20;
		
		System.out.println(jake.name);
	}
}
