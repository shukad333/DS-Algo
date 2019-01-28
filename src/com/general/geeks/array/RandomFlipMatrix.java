package com.general.geeks.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * You are given the number of rows n_rows and number of columns n_cols of a 2D binary matrix where all values are initially 0. Write a function flip which chooses a 0 value uniformly at random, changes it to 1, and then returns the position [row.id, col.id] of that value. Also, write a function reset which sets all values back to 0. Try to minimize the number of calls to system's Math.random() and optimize the time and space complexity.

Note:

1 <= n_rows, n_cols <= 10000
0 <= row.id < n_rows and 0 <= col.id < n_cols
flip will not be called when the matrix has no 0 values left.
the total number of calls to flip and reset will not exceed 1000.
Example 1:

Input: 
["Solution","flip","flip","flip","flip"]
[[2,3],[],[],[],[]]
Output: [null,[0,1],[1,2],[1,0],[1,1]]
Example 2:

Input: 
["Solution","flip","flip","reset","flip"]
[[1,2],[],[],[],[]]
Output: [null,[0,0],[0,1],null,[0,0]]
Explanation of Input Syntax:

The input is two lists: the subroutines called and their arguments. Solution's constructor has two arguments, n_rows and n_cols. flip and reset have no arguments. Arguments are always wrapped with a list, even if there aren't any.
 * @author skadavath
 *
 */
public class RandomFlipMatrix {
	
	int row,col,total;
	Map<Integer, Integer> map = new HashMap<>();
	Random rand = new Random();
	
	public RandomFlipMatrix(int n_rows, int n_cols) {
		row = n_rows;
		col = n_cols;
		total = row*col;
		
	}
	 
    public int[] flip() {
        
    	//Ficher Yates Algo
    	//First get a random number till total
    	int r = rand.nextInt(total--);
    	
    	//store in x
    	int x = map.getOrDefault(r, r);
    	
    	//swap r with total
    	
    	map.put(r, map.getOrDefault(total, total));
    	
    	return new int[] {x/col,x%col};
    }
    
    public void reset() {
    	
    	map.clear();
    	total = row*col;
        
    }

}
