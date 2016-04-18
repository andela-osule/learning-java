package casting;

public class App {
	public static void main(String[] args) {
		Machine machine = new Machine();
		Camera camera = new Camera();
		
		machine.start();
		camera.start();
		camera.snap();
		
		// Let's upcast
		Machine spMachine = camera;
		
		spMachine.start(); // can't say spMachine.snap()
		// NOTE: the type of the object determine what methods can be called
		
		
		// Let's downcast: inherently unsafe
		Machine dMachine = new Camera();
		Camera dCamera = (Camera) dMachine;
		dCamera.start();
		dCamera.snap();
		
		//Or try changing machine to camera which won't work
		//		Machine ddMachine = new Machine();
		//		Camera ddCamera = (Camera) machine;
		//		ddCamera.start();
		//		ddCamera.stop();
	}
} 