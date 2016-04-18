package accessmodifiers.world;

public class Field {
	private Plant plant = new Plant();
	
	public Field() {
		// Works, Field is in same package as plant.
		System.out.println(plant.size);
	}

}
