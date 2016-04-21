package exception.handle;

// There are two types of exceptions in Java
// Checked & runtime exceptions.

public class RuntimeException {
	
	public static void main(String[] args) {
		try {
			Thread.sleep(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} // Throws a Checked exception that you have to handle
		
		int value = 7;
		value = value/0; // ArithmeticException runtime exception here!!!
		// Runtime exceptions don't force you to handle them.
		// They represent serious fundamental errors that your program is unlikely to recover from.
		
		String text = null;
		
		System.out.println(text.length()); // Null pointer exception
		// variable not referencing anything, pretty easy to fix.
		
		String[] words = {"one", "two", "three"};
		System.out.println(words[3]); // ArrayIndexOutOfBoundsException
		// Program can't recover from this.  Fix the underlying problem or catch it.
	}
}
