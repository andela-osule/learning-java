package generics;

public class App {

	public static void main(String[] args) {
		Machine machine = new Machine();
		machine.start();
		
		Person person = new Person("Femi");
		person.greet();
		
		// You can type hint interfaces to access just the methods
		// implemented by objects that implement the interface
		Info mInfo = new Machine();
		mInfo.showInfo();
		
		Info pInfo = person;
		pInfo.showInfo();
		
		outputInfo(machine);
		outputInfo(mInfo);
		outputInfo(person);
		outputInfo(pInfo);

	}
	
	public static void outputInfo(Info info) {
		info.showInfo();
	}

}
