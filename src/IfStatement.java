
public class IfStatement {
	public static void main(String args[]) {
		boolean condition = 1 < 6;
		boolean notequal = 5 != 5;
		boolean equal = 5 == 7;
		System.out.println(condition);
		System.out.println(notequal);
		System.out.println(equal);

		int myInt = 20;

		if (myInt < 30) {
			System.out.println("Yes, it's true!");
		} else if (myInt > 30) {
			System.out.println("No, it's false!");
		} else {
			System.out.println("None of the above.");
		}
	}
}
