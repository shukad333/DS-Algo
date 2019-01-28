package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given an array A, we can perform a pancake flip: We choose some positive integer k <= A.length, then reverse the order of the first k elements of A.  We want to perform zero or more pancake flips (doing them one after another in succession) to sort the array A.

Return the k-values corresponding to a sequence of pancake flips that sort A.  Any valid answer that sorts the array within 10 * A.length flips will be judged as correct.

 

Example 1:

Input: [3,2,4,1]
Output: [4,2,4,3]
Explanation: 
We perform 4 pancake flips, with k values 4, 2, 4, and 3.
Starting state: A = [3, 2, 4, 1]
After 1st flip (k=4): A = [1, 4, 2, 3]
After 2nd flip (k=2): A = [4, 1, 2, 3]
After 3rd flip (k=4): A = [3, 2, 1, 4]
After 4th flip (k=3): A = [1, 2, 3, 4], which is sorted. 
Example 2:

Input: [1,2,3]
Output: []
Explanation: The input is already sorted, so there is no need to flip anything.
Note that other answers, such as [3, 3], would also be accepted.

 * 
 * @author skadavath
 *
 */
public class PanCakeSorting {
	
	public static void main(String[] args) {
		
		System.out.println(new PanCakeSorting().pancakeSort(new int[] {3,2,4,1}));
		
	}
	
	public List<Integer> pancakeSort(int[] A) {
        List<Integer> res = new ArrayList<>();
        if (A == null || A.length < 2) {
            return res;
        }
        
        int curEndIndex = A.length - 1;
        while (curEndIndex > 0) {
            int curMaxIndex = getCurMaxIndex(A, curEndIndex);
            if (curMaxIndex != curEndIndex) {
                flip(A, 0, curMaxIndex);  // get the cur max to the 0-th index.
                res.add(curMaxIndex + 1);
                flip(A, 0, curEndIndex);  // get the cur max to curEndIndex so everything after curEndIndex (inclusive) is sorted
                res.add(curEndIndex + 1);
            }
            curEndIndex--;
        }
        return res;
    }
    
    private int getCurMaxIndex(int[] A, int endIndex) {
        int max = A[0];
        int maxIndex = 0;
        for (int i = 1; i <= endIndex; i++) {
            if (A[i] > max) {
                max = A[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    
    private void flip(int[] A, int start, int end) {
        while (start < end) {
            int temp = A[start];
            A[start] = A[end];
            A[end] = temp;
            start++;
            end--;
        }
        return;
    }

}
