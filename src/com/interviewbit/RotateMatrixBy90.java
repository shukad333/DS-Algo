package com.interviewbit;

import java.util.ArrayList;

public class RotateMatrixBy90 {
	
	public void rotate(ArrayList<ArrayList<Integer>> a) {
        
		int N = a.size();
        // Traverse each cycle 
   for (int i = 0; i < N / 2; i++) 
   { 
       for (int j = i; j < N - i - 1; j++) 
       { 
 
           // Swap elements of each cycle 
           // in clockwise direction 
           int temp = a.get(i).get(j); 
           a.get(i).set(j, a.get(N-1-j).get(i));
           a.get(N-1-j).set(i, a.get(N-1-i).get(N-1-j));
           a.get(N-1-i).set(N-1-j, a.get(j).get(N-1-i));
           a.get(j).set(N-1-i, temp);
           
       } 
   } 
   }

}
