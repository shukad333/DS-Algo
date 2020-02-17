package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.List;

public class CircularPermutationInBinaryRepresentation {
	
	
	public static void main(String[] args) {
		
		System.out.println(new CircularPermutationInBinaryRepresentation().circularPermutation(3, 2));
		
	}
	

		public List<Integer> circularPermutation(int n, int start) {
			
			List<Integer> temp = oneBitDiff(n);
			
			
			int i=0;
			for(;i<temp.size();i++) {
				if(temp.get(i)==start)
					break;
			}
			
			List<Integer> resp = new ArrayList<>();
			for(int j=i;j<temp.size();j++) {
				
				resp.add(temp.get(j));
				
			}
			
			for(int j=0;j<i;j++)
				resp.add(temp.get(j));
			
			return resp;
	        
	    }
		
		private List<Integer> oneBitDiff(int n) {
			List<Integer> resp = new ArrayList<Integer>();
			resp.add(0);
			
			for(int i=0;i<n;i++) {
				for(int j=resp.size()-1;j>=0;j--) {
					resp.add(resp.get(j) | (1<<i));
				}
			}
			
			return resp;
		}

}
