package com.general.geeks.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * We are stacking blocks to form a pyramid. Each block has a color which is a one letter string, like `'Z'`.

For every block of color `C` we place not in the bottom row, we are placing it on top of a left block of color `A` and right block of color `B`. We are allowed to place the block there only if `(A, B, C)` is an allowed triple.

We start with a bottom row of bottom, represented as a single string. We also start with a list of allowed triples allowed. Each allowed triple is represented as a string of length 3.

Return true if we can build the pyramid all the way to the top, otherwise false.

Example 1:
Input: bottom = "XYZ", allowed = ["XYD", "YZE", "DEA", "FFF"]
Output: true
Explanation:
We can stack the pyramid like this:
    A
   / \
  D   E
 / \ / \
X   Y   Z

This works because ('X', 'Y', 'D'), ('Y', 'Z', 'E'), and ('D', 'E', 'A') are allowed triples.
Example 2:
Input: bottom = "XXYX", allowed = ["XXX", "XXY", "XYX", "XYY", "YXZ"]
Output: false
Explanation:
We can't stack the pyramid to the top.
Note that there could be allowed triples (A, B, C) and (A, B, D) with C != D.
Note:
bottom will be a string with length in range [2, 8].
allowed will have length in range [0, 200].
Letters in all strings will be chosen from the set {'A', 'B', 'C', 'D', 'E', 'F', 'G'}.

 * 
 * @author skadavath
 *
 */
public class PyramidTransitionMatrix {
	
	public static void main(String[] args) {
		
		
	}

	public boolean pyramidTransition(String bottom, List<String> allowed) {
		
		Map<String, ArrayList<String>> map = new HashMap<>();
		for(String s : allowed) {
			String starting = s.substring(0,2);
			if(!map.containsKey(starting))map.put(starting,new ArrayList<>());
			map.get(starting).add(s.substring(2));
		}
		
		
		return helper(bottom, map);

	}
	
	private boolean helper(String bottom,Map<String,ArrayList<String>> map) {
		
		if(bottom.length()==1) 
			return true;
		for(int i=0;i<bottom.length()-1;i+=2) {
			if(!map.containsKey(bottom.substring(i, i+2))) return false;
		}
		
		List<String> list = new ArrayList<>();
		setUpNextBottom(bottom, map, 0, new StringBuilder(), list);
		for(String s : list) {
			if(helper(s, map))
				return true;
		}
		return false;
		
	}
	
	
	private void setUpNextBottom(String bottom,Map<String,ArrayList<String>> map,int index,StringBuilder sb,List<String> nextList) {
		
		if(index==bottom.length()-1) {
				nextList.add(sb.toString());
				return;
		}
		
		for(String s : map.get(bottom.substring(index, index+2))) {
			sb.append(s);
			setUpNextBottom(bottom, map, index+1, sb,nextList);
			sb.deleteCharAt(sb.length()-1);
		}
		
	}
	

}
