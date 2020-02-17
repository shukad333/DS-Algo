package com.general.geeks.misc;

import java.util.Optional;

/**
 * 
 * Given a 2D grid of 0s and 1s, return the number of elements in the largest square subgrid that has all 1s on its border, or 0 if such a subgrid doesn't exist in the grid.

 

Example 1:

Input: grid = [[1,1,1],[1,0,1],[1,1,1]]
Output: 9
Example 2:

Input: grid = [[1,1,0,0]]
Output: 1
 

Constraints:

1 <= grid.length <= 100
1 <= grid[0].length <= 100
grid[i][j] is 0 or 1
 * 
 * @author skadavath
 *
 */
public class Largest1BorderedSquare {
	
	public static void main(String[] args) {
		
		Optional<Object> ob = Optional.of("haha");
		System.out.println(ob.isPresent()?ob.get():"No bro");
	}

	public int largest1BorderedSquare(int[][] A) {
		
		int m = A.length, n = A[0].length;
        int[][] left = new int[m][n], top = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (A[i][j] > 0) {
                    left[i][j] = j > 0 ? left[i][j - 1] + 1 : 1;
                    top[i][j] = i > 0  ? top[i - 1][j] + 1 : 1;
                }
            }
        }
        for (int l = Math.min(m, n); l > 0; --l)
            for (int i = 0; i < m - l + 1; ++i)
                for (int j = 0; j < n - l + 1; ++j)
                    if (top[i + l - 1][j] >= l &&
                            top[i + l - 1][j + l - 1] >= l &&
                            left[i][j + l - 1] >= l &&
                            left[i + l - 1][j + l - 1] >= l)
                        return l * l;
        return 0;
    }

	}

