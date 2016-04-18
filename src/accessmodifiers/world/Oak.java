package accessmodifiers.world;

public class Oak extends Plant {
	public Oak() {
		// cant say
		// type = "tree";
		// because type is private.
		this.size = "large"; // works because size is protected and oak&plant in same package;
		this.height = 10; // works because height is protected and oak&plant in same package
	}
}
