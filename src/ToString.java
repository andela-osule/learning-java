class Frogger {
	
	private int id;
	private String name;
	
	Frogger(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(id).append(": ").append(name);
//		return sb.toString();
		return String.format("%d: %s\n", id, name);
	}
}


public class ToString {

	public static void main(String[] args) {
		Frogger frog1 = new Frogger(7, "Fred");
		System.out.println(frog1);
		
	}

}
