package com.interviewbit;

import java.util.Map;
import java.util.TreeMap;

public class AliceLeaderboard {
	
	 static int[] climbingLeaderboard(int[] scores, int[] alice) {

        

         int[] resp = new int[alice.length];

         
         TreeMap<Integer, Integer> map = new TreeMap<>();
         for(int s : scores)
        	 if(!map.containsKey(s))
        		 map.put(s, map.size()+1);
         
         int index = 0;
         for(int i=0;i<alice.length;i++) {
        	 
        	 int currScore = alice[i];
        	 
        	 Integer lowerScore = map.floorKey(currScore);
        	 if(null==lowerScore)
        		 resp[index++] = map.size()+1;
        	 else
        		 resp[index++] = map.get(lowerScore);
        	 
         }

         return resp;
 }

}
