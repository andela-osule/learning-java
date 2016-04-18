package accessmodifiers;

import accessmodifiers.world.Oak;
import accessmodifiers.world.Plant;


/*
 * private -- only within same class
 * public -- from anywhere
 * protected -- same class, subclass and same package 
 * no modifier -- same package
 */

public class App {
	public static void main(String[] args) {
		Plant plant = new Plant();
		
		Oak oak = new Oak();
		
		System.out.println(plant.name);
		System.out.println(Plant.ID);
		
		System.out.println(oak.name);
		//System.out.println(oak.size); wont work because size is protected and app isn't in same package as oak.
		
		// System.out.println(plant.type); wont work because type is private.
		 
		// System.out.println(plant.size); wont work size is protected and app isn't in same package as plant.
		
		// System.out.println(plant.height); wont work because height and plant not in same package and height has package level visibility
		
	}
}
