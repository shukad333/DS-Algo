package com.general.geeks.misc;

public class ReorderedPowerOf2 {
	
	public static void main(String[] args) {
		System.out.println(new ReorderedPowerOf2().reorderedPowerOf2(128));
	}

	public boolean reorderedPowerOf2(int N) {
		
		int digitsN = getDigitsCounts(N);
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
