package com.general.geeks.misc;

public class PerfectSquareWithoutFunction {
	
	public static void main(String[] args) {
		
		System.out.println(new PerfectSquareWithoutFunction().isPerfectSquare(9));
	}

	public boolean isPerfectSquare(int num) {

		for (int i = 1; i <= num / 2; i++) {
			if (i * i == num) {
				return true;
			}
		}
		return false;
		
	}

}
