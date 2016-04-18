package anon;

public class App {

	public static void main(String[] args) {
		// Anonymous classes
		Machine machine = new Machine();
		machine.start();
		
		//overriding start method in Machine
		Machine anonMachine = new Machine() {
			@Override public void start() {
				System.out.println("Starting machine !!!");
			}
		};
		anonMachine.start();
		
		// Plant plant1 = new Plant(); Won't work cos' there is no plant class
		IPlant plant = new IPlant() {
			@Override
			public void grow() {
				System.out.println("Plant growing ...");
			}
		};
		plant.grow();
		
	}

}
