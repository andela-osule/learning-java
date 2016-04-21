package abstractclass;

public class App {
	public static void main(String[] args) {
		Camera cam = new Camera();
		cam.setId(5);
		cam.run();
		
		Car car = new Car();
		car.setId(4);
		
		car.run();
		
		// Since there is not such thing as a machine by itself in the real-world
		// Can prevent user from instantiating machine by making it abstract.
	}
}
