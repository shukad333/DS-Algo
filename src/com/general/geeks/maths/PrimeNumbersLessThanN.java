package com.general.geeks.maths;

public class PrimeNumbersLessThanN {

	public static void main(String[] args) {
		
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
