package com.general.geeks.misc;

import java.util.List;

/**
 * In a string composed of 'L', 'R', and 'X' characters, like "RXXLRXRXL", a move consists of either replacing one occurrence of "XL" with "LX", or replacing one occurrence of "RX" with "XR". Given the starting string start and the ending string end, return True if and only if there exists a sequence of moves to transform one string to the other.

Example:

Input: start = "RXXLRXRXL", end = "XRLXXRRLX"
Output: True
Explanation:
We can transform start to end following these steps:
RXXLRXRXL ->
XRXLRXRXL ->
XRLXRXRXL ->
XRLXXRRXL ->
XRLXXRRLX
Note:

1 <= len(start) = len(end) <= 10000.
Both start and end will only consist of characters in {'L', 'R', 'X'}.

 * @author skadavath
 *
 */
public class SwapAdjacentInLRString {
	
	public static void main(String[] args) {
		
		System.out.println(new SwapAdjacentInLRString().canTransform("RXXLRXRXL", "XRLXXRRLX"));
		
	}

	public boolean canTransform(String start, String end) {

		int r = 0, l = 0;
        for (int i = 0; i< start.length(); i++){
        	if (start.charAt(i) == 'L') l++;
        	if (start.charAt(i) == 'R') r++;
            
            if (end.charAt(i) == 'L') l--;
            
            if (end.charAt(i) == 'R') r--;

            if (l > 0 || r < 0 || (r > 0 && l != 0))  return false;
        }
        
        if (l == 0 && r == 0) return true;
        return false;
	}
	
}
