package com.general.geeks.misc;

/**
 * You are given two jugs with capacities x and y litres. There is an infinite
 * amount of water supply available. You need to determine whether it is
 * possible to measure exactly z litres using these two jugs.
 * 
 * If z liters of water is measurable, you must have z liters of water contained
 * within one or both buckets by the end.
 * 
 * Operations allowed:
 * 
 * Fill any of the jugs completely with water. Empty any of the jugs. Pour water
 * from one jug into another till the other jug is completely full or the first
 * jug itself is empty. Example 1: (From the famous "Die Hard" example)
 * 
 * Input: x = 3, y = 5, z = 4 Output: True Example 2:
 * 
 * Input: x = 2, y = 6, z = 5 Output: False
 * 
 * @author skadavath
 *
 */
public class WaterAndJugProblem {

	public static void main(String[] args) {
		System.out.println(new WaterAndJugProblem().canMeasureWater(3, 5, 4));
		System.out.println(new WaterAndJugProblem().canMeasureWater(2, 6, 5));
	}

	public boolean canMeasureWater(int x, int y, int z) {

		// Bezouts Identity
		/**
		 * ax + by = z ( z is the GCD of a,b) a and b are two numbers(can be negative if
		 * poring out of jug) ax + by will be a multiple of GCD
		 */

		if (x + y < z)
			return false;
		if (x == z || y == z || (x + y) == z)
			return true;
		return z % GCD(x, y) == 0;

	}

	private int GCD(int a, int b) {
		while (b != 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}

		return a;
	}

}
