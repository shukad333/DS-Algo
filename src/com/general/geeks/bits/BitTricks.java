package com.general.geeks.bits;

public class BitTricks {
	
	public static void main(String[] args) {
		
		long x = 16;
		//Checks for power of 2
		System.out.println((x&(x-1))==0);
		
		int y=5;
		System.out.println((y>>1));
		
		long z=8;
		z=z&0x5555555555555555L;
		System.out.println(0x55555555);
		System.out.println(Math.pow(4, 8));
		
	}
}
