package generics.wildcards;

import java.util.ArrayList;

public class App {

	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		showList(list);
		
		ArrayList<Machine> machines = new ArrayList<Machine>();
		machines.add(new Machine());
		machines.add(new Machine());
		showMachines(machines);
		
		ArrayList<Camera> cameras = new ArrayList<Camera>();
		cameras.add(new Camera());
		cameras.add(new Camera());
		showList(cameras);
	}
	

	// Using a wild-card means you can't call specialized class methods. You can however downcast
	public static void showList(ArrayList<?> list){
		for(Object o: list) {
			System.out.println(o);
		}
	}
	
	// How about we pass an array list of Machine class or classes that extend Machine
	public static void showMachines(ArrayList<? extends Machine> list){
		for(Machine m: list) {
			System.out.println(m);
			m.start();
			// value.snap() !!!wont work, can only call machine methods.
			
		}
	}
	
	// How about we pass an array list of Camera class or classes that are super classes of Camera
	public static void showCameras(ArrayList<? super Camera> list){
		for(Object c: list) {
			System.out.println(c);
			// Downcast to Camera class if you need access to public methods in Camera class
			
		}
	}
}
