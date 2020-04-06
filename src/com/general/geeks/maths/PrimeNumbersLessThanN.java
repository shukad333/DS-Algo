package com.general.geeks.maths;

import java.util.TreeMap;

public class PrimeNumbersLessThanN {

	public static void main(String[] args) {

		TreeMap<Integer,Integer> tm = new TreeMap<>();
		tm.put(0,1123);
		tm.put(10,1);
		System.out.println(tm.floorKey(100)+" "+tm.floorEntry(9).getValue());
		System.out.println(tm.ceilingKey(90)+" "+tm.ceilingEntry(8).getValue());
		System.out.println(new PrimeNumbersLessThanN().countPrimes(15000));

	}
	
	/*
	 * Using sieveOfEratosthenes technique
	 */
	public int countPrimes(int n) {
		
		boolean prime[] = new boolean[n+1];
		for(int i=0;i<n;i++) {
			prime[i] = true;
		}
		
		for(int p=2;p*p<=n;p++) {
			if(prime[p]==true) {
				for(int i=p*2;i<=n;i+=p) {
					prime[i] = false;
				}
			}
		}
		
		int count = 0;
		for(int i=2;i<=n;i++) {
			if(prime[i]) {
				count++;
			}
		}
		
		return count;
		
	}

	/*
	 * Below is the kiddie naive solution
	 */
//	public int countPrimes(int n) {
//
//		int total = 0;
//		for(int i=2;i<n;i++) {
//			if(isPrime(i)) {
//				total++;
//			}
//		}
//		return total;
//
//	}
//
//	private boolean isPrime(int x) {
//		
//		for(int i=2;i<=Math.sqrt(x);i++) {
//			
//			if(x%i==0) {
//				return false;
//			}
//		}
//		
//		return true;
//
//	}

}
