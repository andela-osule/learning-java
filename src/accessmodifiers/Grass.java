package accessmodifiers;

import accessmodifiers.world.Plant;

public class Grass extends Plant{
	public Grass() {
		// System.out.println(this.height); Grass not in same package as plant even though it's a subclass.
	}
}
