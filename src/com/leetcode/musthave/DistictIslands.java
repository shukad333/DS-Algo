package com.leetcode.musthave;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DistictIslands {


    public static void main(String[] args) {
        int[][] grid = {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,1,1,1}};
        System.out.println(new DistictIslands().numDistinctIslands(grid));
    }

    public int numDistinctIslands(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;
        Set<List<List<Integer>>> islands = new HashSet<>(); // all different islands
        boolean[][] seen = new boolean[m][n];

        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j) {
                List<List<Integer>> island = new ArrayList<>();
                dfs(i, j, i, j, grid, island,seen);
                if (!island.isEmpty())
                    islands.add(island);
            }

        return islands.size();
    }


    private void dfs(int i , int j , int x , int y ,int[][] grid, List<List<Integer>> islands,boolean[][] seen) {

        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length)
            return;

        if(grid[i][j]==0 || seen[i][j])
            return;

        seen[i][j] = true;
        islands.add(Arrays.asList(i-x,j-y));

        int[] dir = {0,1,0,-1,0};
        for(int a=0;a<dir.length-1;a++) {
            dfs(i,j,x+dir[a],y+dir[a+1],grid,islands,seen);
        }

    }
}



