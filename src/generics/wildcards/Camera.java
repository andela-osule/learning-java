package generics.wildcards;

public class Camera extends Machine {

	@Override
	public String toString() {
		return "I am a camera";
	}

	public void snap() {
		System.out.println("Snapped");
	}
}
