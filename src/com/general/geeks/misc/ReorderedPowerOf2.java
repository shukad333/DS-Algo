package com.general.geeks.misc;

import java.util.Arrays;
import java.util.Comparator;

public class ReorderedPowerOf2 {
	
	public static void main(String[] args) {
		System.out.println(new ReorderedPowerOf2().reorderedPowerOf2(128));
	}
	
	private void sort(int[] arr) {
		final int[] data = new int[] { 5, 4, 2, 1, 3 };
		
		Arrays.stream(arr).boxed().sorted((a,b)->b-a).mapToInt(i->i).toArray();
		
	}

	public boolean reorderedPowerOf2(int N) {
		
		
		
		int digitsN = getDigitsCounts(N);
		getDigitsCounts(821);
		for(int i=0;i<=32;i++) {
			if(getDigitsCounts(1<<i)==digitsN) {
				return true;
			}
		}
		return false;
	}
	
	private int getDigitsCounts(int n) {
		
		int op = 0;
		for(;n>0;n/=10) {
			op+=Math.pow(10, n%10);
		}
		System.out.println(op);
		return op;
	}
	
	

}
