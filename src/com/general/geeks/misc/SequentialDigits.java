package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * An integer has sequential digits if and only if each digit in the number is one more than the previous digit.

Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.

 

Example 1:

Input: low = 100, high = 300
Output: [123,234]
Example 2:

Input: low = 1000, high = 13000
Output: [1234,2345,3456,4567,5678,6789,12345]
 

Constraints:

10 <= low <= high <= 10^9
 * 
 * @author skadavath
 *
 */
public class SequentialDigits {
	
	public static void main(String[] args) {
		
		System.out.println(new SequentialDigits().sequentialDigits(1000, 13000));
		
	}
	
	public List<Integer> sequentialDigits(int low, int high) {
		
		List<Integer> resp = new ArrayList<>();
		
		for(int i=1;i<10;i++) {
			
			int curr=i,next=i;
			while(curr<=high && next<10) {
				
				if(curr>=low)
					resp.add(curr);
				
				int nextNum = curr*10 + ++next;
				curr = nextNum;
			}
			
		}
		
		Collections.sort(resp);
		return resp;

	}

}
