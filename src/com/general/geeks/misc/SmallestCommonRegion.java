package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * You are given some lists of regions where the first region of each list
 * includes all other regions in that list.
 * 
 * Naturally, if a region X contains another region Y then X is bigger than Y.
 * 
 * Given two regions region1, region2, find out the smallest region that
 * contains both of them.
 * 
 * If you are given regions r1, r2 and r3 such that r1 includes r3, it is
 * guaranteed there is no r2 such that r2 includes r3.
 * 
 * It's guaranteed the smallest region exists.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: regions = [["Earth","North America","South America"], ["North
 * America","United States","Canada"], ["United States","New York","Boston"],
 * ["Canada","Ontario","Quebec"], ["South America","Brazil"]], region1 =
 * "Quebec", region2 = "New York" Output: "North America"
 * 
 * 
 * Constraints:
 * 
 * 2 <= regions.length <= 10^4 region1 != region2 All strings consist of English
 * letters and spaces with at most 20 letters.
 * 
 * @author skadavath
 *
 */
public class SmallestCommonRegion {
	
	public static void main(String[] args) {
		
		List<List<String>> regions = new ArrayList<List<String>>();
		regions.add(Arrays.asList("Earth","North America","South America"));
		regions.add(Arrays.asList("North America","United States","Canada"));
		regions.add(Arrays.asList("United States","New York","Boston"));
		regions.add(Arrays.asList("Canada","Ontario","Quebec"));
		regions.add(Arrays.asList("South America","Brazil"));
		
		System.out.println(new SmallestCommonRegion().findSmallestRegion(regions, "Quebec", "New York"));
		
	}

	public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
		
		Map<String, String> parents = new HashMap<>();
		Set<String> ancestorSet = new HashSet<>();
		
		for(List<String> region : regions)
			for(int i=1;i<region.size();i++)
				parents.put(region.get(i), region.get(0));
			
			while(null!=region1) {
				ancestorSet.add(region1);
				region1 = parents.get(region1);
			}
		
		while(!ancestorSet.contains(region2)) {
			region2 = parents.get(region2);
		}
		
		return region2;

	}
	
	String region, r1, r2;
	
	public String _findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        r1=region1;
        r2=region2;
        Map<String, List<String>> graph=new HashMap<>();
        Map<String, Integer> visited=new HashMap<>();
        for(int i=0;i<regions.size();i++) {
            List<String> tmp=new ArrayList<>();
            for(int j=1;j<regions.get(i).size();j++) tmp.add(regions.get(i).get(j));
            graph.put(regions.get(i).get(0), tmp);
        }
        for(int i=0;i<regions.size();i++) {
            if(!visited.containsKey(regions.get(i).get(0))) find(regions.get(i).get(0), graph, visited);
            if(region!=null) return region;
        }
        return region;
    }
    
    int find(String root, Map<String, List<String>> g, Map<String, Integer> visited) {
        if(region!=null) return 0;
        int res=0;
        if(root.equals(r1)) res=1;
        else if(root.equals(r2)) res=2;
        if(!g.containsKey(root)) return res;
        List<String> children=g.get(root);
        for(int i=0;i<children.size();i++) {
            if(!visited.containsKey(children.get(i))) visited.put(children.get(i), find(children.get(i), g, visited));
            res+=visited.get(children.get(i));
            if(res==3) {
                if(region==null) region=root;
                return 3;
            }
        }
        return res;
    }

}
