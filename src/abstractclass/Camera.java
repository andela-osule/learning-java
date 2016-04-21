package abstractclass;

public class Camera extends Machine { 
	// Sets fundamental identity of a Car.
	// Much stronger than simply implementing an interface. 
	// Interfaces are rules for what things your class does.
	
	public void start() {
		System.out.println("Camera started");
	}

	@Override
	public void work() {
		System.out.println("Camera working.");
	}

	@Override
	public void shutDown() {
		System.out.println("Camera shutdown.");
	}
}
