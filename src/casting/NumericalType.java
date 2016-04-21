package casting;

public class NumericalType {
	
	public static void main(String[] args) {
		byte byteVal = 127;
		short shortVal = 55;
		int intVal = 888;
		long longVal = 233333335;
		
		float floatVal = 8824.3F;
		double doubleVal = 32.4;
		
		
		System.out.println(Byte.MAX_VALUE);
		
		intVal = (int) longVal;
		System.out.println(intVal);
		
		doubleVal = intVal;
		System.out.println(doubleVal);
		
		intVal = (int) floatVal;
		System.out.println(intVal);
		
		// Be careful about stuffing a over-size type into a type without enough memory to hold it.
		byteVal = (byte) 128;
		System.out.println(byteVal);
		
		
		
	}
	
	
}
