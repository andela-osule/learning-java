class Robot {
	
	public void speak(String text) {
		System.out.println(text);
	}
	
	public void jump(int height) {
		System.out.printf("Jumping: %d\n", height);
	}
	
	public void move(String direction, double distance) {
		System.out.printf("Moving distance %.2f m in direction %s.\n", distance, direction);
	}
	
}
public class MethodParams {

	public static void main(String[] args) {
		Robot sam = new Robot();
		sam.speak("Hi, I'm Sam!"); // Passing a parameter to the method.
		sam.jump(7);
		sam.move("right", 30.0);
		
		String  greeting = "Hello there!";
		sam.speak(greeting);
	}

}
