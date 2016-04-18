package polymorphism;
 
public class App {

	public static void main(String[] args) {
		// You can always use a child class where you'll use a parent class
		Plant plant = new Plant();
		Tree tree = new Tree();

		Plant aTree = tree; // Polymorph
		
		tree.grow();
		
		aTree.grow(); // what matters is the object aTree points at.
		// aTree.shedLeaves(); Would work
		// Type defines what methods are call-able and the method in the object pointed at.
		doGrow(aTree);
	}
	
	public static void doGrow(Plant plant) {
		plant.grow();
	}
}
