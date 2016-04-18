package accessmodifiers.world;

public class Plant {
	// Bad practice. Hide instance variables from the world or otherwise make them constant.
	// Never declare instance variables public, encapsulate them.
	public String name;
	
	// Acceptable practice. It is final.
	public final static int ID = 8;
	
	private String type;
	
	protected String size;
	
	int height;
	
	public Plant() {
		name = "Cactus";
		this.type = "plant";
		
		size = "medium";
		height = 8;
	}
}
