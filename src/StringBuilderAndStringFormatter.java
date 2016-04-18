
public class StringBuilderAndStringFormatter {
	public static void main(String[] args) {
		String info = "";
		info += "My name is Oluwafemi.";
		info += " ";
		info += "I am a system programmer."; // Very inefficient because strings are immutable
		System.out.println(info);
		
		// Use string builder. It's more efficient.
		
		StringBuilder sb = new StringBuilder(""); // Mutable string.
		sb.append("My name is Oluwafemi.");
		sb.append(" ");
		sb.append("I am a lion tamer.");
		sb.insert(25, 'r');
		System.out.println(sb.toString());
		
		
		// You can use method chaining. Since append returns reference to String Builder object.
		StringBuilder s = new StringBuilder();
		s.append("My name is Roger.")
		.append(" ")
		.append("I am a skydriver.");
		
		System.out.println(s.toString());
		
		// Formating
		System.out.println("Here is some text.\tThat was a tab.\nThat was a newline.");
		
		// Formatting integers
		System.out.printf("Total cost %-10d; Quantity is  %d\n", 5, 120);
		
		// Formatting floating point values
		for (int i=0; i<20; i++) {
			System.out.printf("%2d: some text here\n", i); // width of 2
		}
		
		System.out.printf("Total value: %5.2f\n", 5.6874);
	}
}
