class Thing {
	public static final int LUCKY_NUMBER = 7;
	public String name;
	public static String description; 
	// Advice: Keep member variables private or protected.
	
	public static int count;
	public int id;
	
	public Thing() {
		id = count;
		count++;
	}
	
	public void showName() {
		// However, instance methods can access static variables
		System.out.printf("Object id: %d,  %s : %s\n", id, description, name);
	}
	
	public static void showInfo() {
		System.out.println("Hello");
		// Static methods can access static variables. 
		System.out.println(description); 
	}
} 


public class StaticAndFinal {

	public static void main(String[] args) {
		System.out.printf("Before creating objects, count is: %d\n" ,Thing.count);
		Thing thing1 = new Thing();
		Thing thing2 = new Thing();
		
		System.out.printf("After creating objects, count is: %d\n", Thing.count);
		
		Thing.description = "I am a thing";
		Thing.showInfo();
		
		System.out.println(Thing.description);
		
		thing1.name = "Bob";
		thing2.name = "Sue";
		
		System.out.println(thing1.name);
		System.out.println(thing2.name);
	
		thing1.showName();
		thing2.showName();
		
		System.out.println(Math.PI); // Final fields are written in upper case.
		

		System.out.println(Thing.LUCKY_NUMBER);
	}

}
