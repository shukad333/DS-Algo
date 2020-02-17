package com.general.geeks.misc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Given an array of integers, find out whether there are two distinct indices i
 * and j in the array such that the absolute difference between nums[i] and
 * nums[j] is at most t and the absolute difference between i and j is at most
 * k.
 * 
 * 
 * @author skadavath
 *
 */
public class ContainsDuplicate3 {
	
	public static void main(String[] args) {
		
		System.out.println(new ContainsDuplicate3().containsNearbyAlmostDuplicate(new int[] {1,2,3,1}, 3, 0));
		
	}
	
	
	private long getID(long i, long w) {
	    return i < 0 ? (i + 1) / w - 1 : i / w;
	}

	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
	    if (t < 0) return false;
	    Map<Long, Long> d = new HashMap<>();
	    long w = (long)t + 1;
	    for (int i = 0; i < nums.length; ++i) {
	        long m = getID(nums[i], w);
	        if (d.containsKey(m))
	            return true;
	        if (d.containsKey(m - 1) && Math.abs(nums[i] - d.get(m - 1)) < w)
	            return true;
	        if (d.containsKey(m + 1) && Math.abs(nums[i] - d.get(m + 1)) < w)
	            return true;
	        d.put(m, (long)nums[i]);
	        if (i >= k) d.remove(getID(nums[i - k], w));
	    }
	    return false;
	}

	public boolean _containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		
		
		TreeSet<Integer> set = new TreeSet();
		
		for(int i=0;i<nums.length;i++) {
			
			SortedSet<Integer> sortedSet = set.subSet(nums[i]-k, nums[i]+k+1);
			if(sortedSet.size()>0) {
				return true;
			}
			set.add(nums[i]);
			if(i>=k) {
				set.remove(nums[i-k]);
			}
		}
		return false;

	}

}
