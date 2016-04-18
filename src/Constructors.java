class Machine {
	private String name;
	private int code;
	
	public Machine() {
		this("Arnie", 0);
		System.out.println("Constructor running!");
		name = "Arnie";
		// invoke a constructor inside of a constructor.
	} 
	
	// Constructor overloading
	public Machine(String name) {
		this(name, 0);
		System.out.println("Constructor takes a string parameter.");
		this.name = name;
	}
	
	public Machine(String name, int code) {
		System.out.println("Constructor takes a string and integer parameter.");
		this.name = name;
		this.code = code;
	}
	
	
}

public class Constructors {

	public static void main(String[] args) {
		Machine machine = new Machine();
		
		new Machine("Bertie");
		
		new Machine("Tolani", 2);
	}

}
