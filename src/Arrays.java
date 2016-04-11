
public class Arrays {
	public static void main(String[] args) {
		int value = 10;
		int[] values;
		values = new int[3]; // Set array length of 3.
		values[0] = value;
		values[1] = 20;
		values[2] = 30;
		System.out.println(values[0]);
		System.out.println(values[1]);
		System.out.println(values[2]);
		
		// Iterate through array values
		
		System.out.println("Iterating through arrays the old way");
		for(int i = 0; i < values.length; i++) {
			System.out.println(values[i]);
		}
		
		int[] numbers = {5, 6, 7};
		
		System.out.println("Iterating through array items the new way");
		for(int i : numbers) {
			System.out.println(i);
		}
	}
}
