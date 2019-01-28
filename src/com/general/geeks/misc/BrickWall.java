package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * There is a brick wall in front of you. The wall is rectangular and has
 * several rows of bricks. The bricks have the same height but different width.
 * You want to draw a vertical line from the top to the bottom and cross the
 * least bricks.
 * 
 * The brick wall is represented by a list of rows. Each row is a list of
 * integers representing the width of each brick in this row from left to right.
 * 
 * If your line go through the edge of a brick, then the brick is not considered
 * as crossed. You need to find out how to draw the line to cross the least
 * bricks and return the number of crossed bricks.
 * 
 * You cannot draw a line just along one of the two vertical edges of the wall,
 * in which case the line will obviously cross no bricks.
 * 
 * 
 * Note: The width sum of bricks in different rows are the same and won't exceed
 * INT_MAX. The number of bricks in each row is in range [1,10,000]. The height
 * of wall is in range [1,10,000]. Total number of bricks of the wall won't
 * exceed 20,000.
 * 
 * 
 * Example: I
 * 
 * @author skadavath
 *
 */
public class BrickWall {
	
	public static void main(String[] args) {
		
		List<Integer> r = Arrays.asList(1,2,2,1);
		List<List<Integer>> inp = new ArrayList<>();
		inp.add(r);
		r = Arrays.asList(3,1,2);
		inp.add(r);
		
		r = Arrays.asList(1,3,2);
		inp.add(r);

		r = Arrays.asList(2,4);
		inp.add(r);
		
		r = Arrays.asList(3,1,2);
		inp.add(r);
		
		r = Arrays.asList(1,3,1,1);
		inp.add(r);


		System.out.println(new BrickWall().leastBricks(inp));
		
	}

	public int leastBricks(List<List<Integer>> wall) {

		int count = 0;
		Map<Integer, Integer> map = new HashMap<>();

		for (List<Integer> w : wall) {
			int length = 0;	
			for (int i = 0; i < w.size()-1; i++) {
				
				int size = w.get(i);
				length += size;
				map.put(length, map.getOrDefault(length, 0)+1);
				count = Math.max(count, map.get(length));

			}

		}

		return wall.size() - count;

	}

}
