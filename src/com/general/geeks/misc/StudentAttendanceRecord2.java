package com.general.geeks.misc;

/**
 * 
 * Given a positive integer n, return the number of all possible attendance records with length n, which will be regarded as rewardable. The answer may be very large, return it after mod 109 + 7.

A student attendance record is a string that only contains the following three characters:

'A' : Absent.
'L' : Late.
'P' : Present.
A record is regarded as rewardable if it doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).

Example 1:
Input: n = 2
Output: 8 
Explanation:
There are 8 records with length 2 will be regarded as rewardable:
"PP" , "AP", "PA", "LP", "PL", "AL", "LA", "LL"
Only "AA" won't be regarded as rewardable owing to more than one absent times. 
Note: The value of n won't exceed 100,000.
 * 
 * @author skadavath
 *
 */
public class StudentAttendanceRecord2 {

	final int mod = 1000_000_00_7;
	public int checkRecord(int n) {
		
		int[] P = new int[n+1]; //ending with P and not having A
		int[] L = new int[n+1]; //ending with L and not having A
		
		P[0] = 1;
		P[1] = 1;
		L[1] = 1;
		
		for(int i=2;i<=n;i++) {
			P[i] = (P[i-1]+L[i-1]) %mod;
			L[i] = (P[i-1]+P[i-2]) %mod;
		}
		
		long resp = (P[n] + L[n])%mod;
		
		//insert A in between P and L
		
		for(int i=0;i<n;i++) {
			long s = ((P[i]+L[i])%mod * (P[n-i-1]+L[n-i-1])%mod)%mod;
			resp = (resp+s)%mod;
		}
		return (int)resp;

	}

}
