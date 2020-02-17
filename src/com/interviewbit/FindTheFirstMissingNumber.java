package com.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindTheFirstMissingNumber {
	
	public static void main(String[] args) {
		
		System.out.println(new FindTheFirstMissingNumber().firstMissingPositiveWithoutExtraSpace(Arrays.asList(3,1,2)));
		
	}
	
	public int firstMissingPositiveWithoutExtraSpace(List<Integer> a) {
		
		for(int i=0;i<a.size();i++) {
			
			int num = a.get(i);
			int pos = num - 1;
			
			if(pos>=0 && pos<a.size() && a.get(pos)!=num) {
				a.set(i, a.get(pos));
				a.set(pos, num);
				i--;
			}
		}
		
		 for (int i = 0; i < a.size(); i++)
	            if (a.get(i) != i + 1)
	                return i + 1;
	        
	        return a.size() + 1;
		
		
	}

	 public int firstMissingPositive(List<Integer> a) {
	        
	       int j =  segregate(a);
	        
	        int[] newArr = new int[a.size()-j];
	        if(j==a.size())
	        	return 1;
	        int start=0;
	        for(int i=j;i<a.size();i++) {
	            newArr[start++] = a.get(i);
	        }
	        
	        //iterate and mark the index as negative to mark visited
	        
	        for(int i=0;i<newArr.length;i++) {
	            
	            int x = Math.abs(newArr[i]);
	            
	            if(x-1<newArr.length && newArr[x-1]>0) {
	                newArr[x-1] = -newArr[x-1];
	            }
	            
	        }
	        
	        
	        for(int i=0;i<newArr.length;i++) {
	            if(newArr[i]>0)
	                return i+1;
	        }
	        
	        return newArr.length+1;
	    }
	    
	    static int segregate(List<Integer> a) {
	        
	        int j=0;
	        for(int i=0;i<a.size();i++) {
	            
	            if(a.get(i)<=0) {
	                int temp = a.get(i);
	                a.set(i, a.get(j));
	                a.set(j, temp);
	                j++;
	            }
	            
	        }
	        
	        return j;
	        
	    }

}
