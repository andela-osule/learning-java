package generics.classes;

import java.util.ArrayList;
import java.util.HashMap;

public class App {

	public static void main(String[] args) {
		// A generic class is one that can work with other objects
		// LEARN to use arrayList class in its generic form.
		
		// Old-style before Java 5
		ArrayList list = new ArrayList(); // Object that can store other objects.
		
		list.add("apple");
		list.add("banana");
		
		String fruit = (String) list.get(1);
		
		System.out.println(fruit);
		
		// Modern style: Array list is Parameterized classes
		ArrayList<String> strings = new ArrayList<String>();
		strings.add("cat");
		strings.add("dog");
		strings.add("alligator");
		
		String animal = strings.get(1);
		
		System.out.println(animal);
		
		// There can be > 1 type of argument. See Hashmap
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "dob");
		map.put(2, "rob");
		
		System.out.println(map.get(1));
	}

}
