
public class MultiDimArrays {
	public static void main(String[] args) {
		int[][] grid = {
			{1, 0}, 
			{1, 4}
		};
		
		for(int[] row : grid) {
			for (int col: row) {
				System.out.println(col);
			}
		}
		
		String[][] texts = new String[2][3];
		
		texts[0][2] = "Hello there";
		
		System.out.println(texts[0][1]);
		
	}
}
