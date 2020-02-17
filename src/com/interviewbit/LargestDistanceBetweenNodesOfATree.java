package com.interviewbit;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LargestDistanceBetweenNodesOfATree {
	
	public static void main(String[] args) {
		
		
		ArrayList<Integer> inp = new ArrayList<>();
		inp.add(-1);
		inp.add(0);
		inp.add(0);
		inp.add(0);
		inp.add(3);
		
		System.out.println(new LargestDistanceBetweenNodesOfATree().solve(inp));
	}
	
	List<List<Integer>> graph = new ArrayList<>();
	int n;
	public int solve(ArrayList<Integer> A) {
		
		n = A.size();
		
		for(int i=0;i<A.size();i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0;i<A.size();i++) {
			
			if(A.get(i)==-1)
				continue;
			graph.get(i).add(A.get(i));
			graph.get(A.get(i)).add(i);
		}
		
		
		//do bfs
		
		int furthest = findFurthest(0)[0];
		
		return findFurthest(furthest)[1];
	}
	
	private int[] findFurthest(int start) {
        final boolean[] marked = new boolean[n];
        Deque<Integer> level = new LinkedList<>();
        
        marked[start] = true;
        level.add(start);
        int dist = 0;
        
        while (true) {
            final Deque<Integer> nextLevel = new LinkedList<>();
            
            for (int i : level) {
                for (int j : graph.get(i)) {
                    if (!marked[j]) {
                        marked[j] = true;
                        nextLevel.add(j);
                    }
                }
            }
            
            if (nextLevel.isEmpty()) {
                return new int[] {level.getLast(), dist};
            } 
            
            level = nextLevel;
            dist++;
        }
    }

}
