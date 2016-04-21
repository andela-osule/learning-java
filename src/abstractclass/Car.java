package abstractclass;

public class Car extends Machine {
	public void start() {
		System.out.println("Car started.");
	}

	@Override
	public void work() {
		System.out.println("Car working.");
	}

	@Override
	public void shutDown() {
		System.out.println("Car shutdown.");
	}
	
}
