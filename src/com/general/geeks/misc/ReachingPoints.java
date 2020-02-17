package com.general.geeks.misc;

/**
 * 
 * A move consists of taking a point (x, y) and transforming it to either (x, x+y) or (x+y, y).

Given a starting point (sx, sy) and a target point (tx, ty), return True if and only if a sequence of moves exists to transform the point (sx, sy) to (tx, ty). Otherwise, return False.

Examples:
Input: sx = 1, sy = 1, tx = 3, ty = 5
Output: True
Explanation:
One series of moves that transforms the starting point to the target is:
(1, 1) -> (1, 2)
(1, 2) -> (3, 2)
(3, 2) -> (3, 5)

Input: sx = 1, sy = 1, tx = 2, ty = 2
Output: False

Input: sx = 1, sy = 1, tx = 1, ty = 1
Output: True

Note:

sx, sy, tx, ty will all be integers in the range [1, 10^9].
 * 
 * @author skadavath
 *
 */
public class ReachingPoints {
	
	public static void main(String[] args) {
		
		System.out.println(new ReachingPoints().reachingPoints(1, 1, 1, 1));
		
	}

	public boolean reachingPoints(int sx, int sy, int tx, int ty) {
		
		if(sx>tx || sy>ty) 
			return false;
		
		if(sx==tx && (ty-sy)%sx==0) return true;
		if(sy==ty && (tx-sx)%sy==0) return true;
		
		return reachingPoints(sx, sy, tx%ty, ty%tx);

	}

}
