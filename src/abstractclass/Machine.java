package abstractclass;

public abstract class Machine {
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public abstract void start(); // can have an abstract method like in an interface
	// Even take it further
	public abstract void work();
	public abstract void shutDown();
	
	public void run() {
		start();
		work();
		shutDown();
	}

}
