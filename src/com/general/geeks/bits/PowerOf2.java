package com.general.geeks.bits;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given an integer, write a function to determine if it is a power of two.
 * 
 * Example 1:
 * 
 * Input: 1 Output: true Explanation: 20 = 1 Example 2:
 * 
 * Input: 16 Output: true Explanation: 24 = 16 Example 3:
 * 
 * Input: 218 Output: false
 * 
 * @author skadavath
 *
 */
public class PowerOf2 {

	public static void main(String[] args) {
		
		System.out.println(new PowerOf2().isPowerOfTwo(16));
		System.out.println(new PowerOf2().power("147573952589676412928"));
		List<String> list = new ArrayList<>();
		list.add("aa");
		list.add("BB");
		list.stream().filter(l->l.equals("BB")).collect(Collectors.toList()).get(0);
	}
	public boolean isPowerOfTwo(int n) {
		
		return (n&(n-1))==0;
		
	}
	
	 public int power(String a) {
		 
		 BigInteger bi = new BigInteger(a);
		 
		 if(bi.compareTo(BigInteger.ONE)==0 || bi.compareTo(BigInteger.ZERO)==0)
			 return 1;
		 
		 System.out.println(bi.bitLength());
		 System.out.println(bi.toByteArray());
		 for(int i=0;i<bi.bitLength()-1;i++) {
			 
			 if(bi.testBit(i))
				 return 0;
				 
		 }
		 
		 return bi.testBit(bi.bitLength()-1)?1:0;
	 }

}
