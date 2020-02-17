package com.general.geeks.misc;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given an array A of positive integers, call a (contiguous, not necessarily distinct) subarray of A good if the number of different integers in that subarray is exactly K.

(For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.)

Return the number of good subarrays of A.

 

Example 1:

Input: A = [1,2,1,2,3], K = 2
Output: 7
Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
Example 2:

Input: A = [1,2,1,3,4], K = 3
Output: 3
Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
 

Note:

1 <= A.length <= 20000
1 <= A[i] <= A.length
1 <= K <= A.length
 * 
 * @author skadavath
 *
 */
public class SubArraysWithKDifferentIntegers {
	
	
	public static void main(String[] args) {
		
		System.out.println(new SubArraysWithKDifferentIntegers().atMostK(new int[] {1,2,1},2));
		
	}

public int subarraysWithKDistinct(int[] A, int K) {
        
        return atMostK(A,K) - atMostK(A,K-1);
    }
    
    private int atMostK(int[] A , int K) {
        
        Map<Integer,Integer> counts = new HashMap<>();
        int i=0,resp=0;
        
        for(int j=0;j<A.length;j++) {
            
            if(counts.getOrDefault(A[j],0)==0)
                K--;
            counts.put(A[j],counts.getOrDefault(A[j],0)+1);
            while(K<0) {
                
                //sliding window starts, we move the left pointer
                
                counts.put(A[i],counts.get(A[i])-1);
                if(counts.get(A[i])==0)
                    K++;
                i++;
                
            }
            resp += j-i+1;
        }
        
        return resp;
    }

}
