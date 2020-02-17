package com.general.geeks.misc;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
Output: 4
Explanation:
^
|
|  o
|     o        o
|        o
|  o        o
+------------------->
0  1  2  3  4  5  6
 * 
 * @author skadavath
 *
 */
public class MaxPointsOnALine {
	
	public static void main(String[] args) {
		
		
		System.out.println(new MaxPointsOnALine().maxPoints(new int[][] {{1,1},{2,2},{3,3}}));
		
	}
	
	public int maxPoints(int[][] points) {
		
		if (points==null) return 0;
    	if (points.length<=2) return points.length;
    	
    	Map<Integer,Map<Integer,Integer>> map = new HashMap<Integer,Map<Integer,Integer>>();
    	int result=0;
    	for (int i=0;i<points.length;i++){ 
    		map.clear();
    		int overlap=0,max=0;
    		for (int j=i+1;j<points.length;j++){
    			int x=points[j][0]-points[i][0];
    			int y=points[j][1]-points[i][1];
    			if (x==0&&y==0){
    				overlap++;
    				continue;
    			}
    			int gcd=gcd(x,y);
    			if (gcd!=0){
    				x/=gcd;
    				y/=gcd;
    			}
    			
    			if (map.containsKey(x)){
    				if (map.get(x).containsKey(y)){
    					map.get(x).put(y, map.get(x).get(y)+1);
    				}else{
    					map.get(x).put(y, 1);
    				}   					
    			}else{
    				Map<Integer,Integer> m = new HashMap<Integer,Integer>();
    				m.put(y, 1);
    				map.put(x, m);
    			}
    			max=Math.max(max, map.get(x).get(y));
    		}
    		result=Math.max(result, max+overlap+1);
    	}
    	return result;
        
	}
	
	public int gcd(int a,int b) {
		
		if(b==0)
			return a;
		return gcd(b,a%b);
	}

}


