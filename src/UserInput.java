import java.util.Scanner;

public class UserInput {
	public static void main(String[] args) {
		// Create scanner object
		Scanner input = new Scanner(System.in);

		// Output the prompt
		System.out.println("Enter ah line of text: ");

		// Wait for user to enter line of text
		String line = input.nextLine();
		// double value = input.nextDouble();
		// int value = input.nextInt();
		
		// Print line of text
		System.out.println("You entered: " + line);
		input.close();
	}
}
