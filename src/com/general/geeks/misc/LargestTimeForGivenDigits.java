package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given an array of 4 digits, return the largest 24 hour time that can be made.
 * 
 * The smallest 24 hour time is 00:00, and the largest is 23:59. Starting from
 * 00:00, a time is larger if more time has elapsed since midnight.
 * 
 * Return the answer as a string of length 5. If no valid time can be made,
 * return an empty string.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: [1,2,3,4] Output: "23:41" Example 2:
 * 
 * Input: [5,5,5,5] Output: ""
 * 
 * 
 * Note:
 * 
 * A.length == 4 0 <= A[i] <= 9
 * 
 * @author skadavath
 *
 */
public class LargestTimeForGivenDigits {
	
	public static void main(String[] args) {
		
		System.out.println(new LargestTimeForGivenDigits().largestTimeFromDigits(new int[] {1,2,3,4}));
		
	}

	public String largestTimeFromDigits(int[] A) {
		
		String str="";
		for(int i : A) {
			str=str+i;
		}
		List<String> list = new ArrayList<>();
		permutations("", str, list);
		
		String time = "";
		
		for (String s : list) {
            s = s.substring(0, 2) + ":" + s.substring(2);
            if (s.charAt(3) < '6') {
                if (s.charAt(0) <= '2' && s.compareTo("24:00") < 0) {
                    time = time.compareTo(s) > 0 ? time : s;
                }
            }
        }
        return time;

	}

	private void permutations(String pre, String str, List<String> list) {

		if (str.length() == 0)
			list.add(pre);
		else {
			for (int i = 0; i < str.length(); i++) {
				
				permutations(pre+str.charAt(i), str.substring(0, i)+str.substring(i+1), list);

			}
		}
	}

}
