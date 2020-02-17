package com.general.geeks.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Given two numbers arr1 and arr2 in base -2, return the result of adding them together.

Each number is given in array format:  as an array of 0s and 1s, from most significant bit to least significant bit.  For example, arr = [1,1,0,1] represents the number (-2)^3 + (-2)^2 + (-2)^0 = -3.  A number arr in array format is also guaranteed to have no leading zeros: either arr == [0] or arr[0] == 1.

Return the result of adding arr1 and arr2 in the same format: as an array of 0s and 1s with no leading zeros.

 

Example 1:

Input: arr1 = [1,1,1,1,1], arr2 = [1,0,1]
Output: [1,0,0,0,0]
Explanation: arr1 represents 11, arr2 represents 5, the output represents 16.
 

Note:

1 <= arr1.length <= 1000
1 <= arr2.length <= 1000
arr1 and arr2 have no leading zeros
arr1[i] is 0 or 1
arr2[i] is 0 or 1

 * 
 * @author skadavath
 *
 */
public class AddingTwoNegabinaryNumbers {
	
	public static void main(String[] args) {
		
		System.out.println(Arrays.toString(new AddingTwoNegabinaryNumbers().addNegabinary(new int[] {1,1,1,1,1},new int[] {1,0,1})));
	}

	public int[] addNegabinary(int[] arr1, int[] arr2) {
		
		int i1 = arr1.length - 1, i2 = arr2.length - 1, carry = 0;
	    List<Integer> resultList = new ArrayList<Integer>();
		
		// 1. calculate sum of arr1 and arr2
	    while (i1 >= 0 || i2 >= 0 || carry != 0) {
	        int n1 = i1 >= 0 ? arr1[i1--] : 0;
	        int n2 = i2 >= 0 ? arr2[i2--] : 0;
	        int sum = n1 + n2 + carry;
			int result = sum & 1;
	        carry = -1 * (sum >> 1) ;
			resultList.add(0, result);
			
	    }
		
		// 2. remove leading zero
	    int beginIndex = 0;
	    while (beginIndex < resultList.size() && resultList.get(beginIndex) == 0)
	        beginIndex++;
			
	    if (beginIndex == resultList.size())
	        return new int[]{0};
	    int resultArray[] = new int[resultList.size() - beginIndex];
	    for (int i = 0; i < resultArray.length; i++)
	        resultArray[i] = resultList.get(i + beginIndex);
	    return resultArray;

	}

}
