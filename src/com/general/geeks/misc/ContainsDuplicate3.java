package com.general.geeks.misc;

import java.util.HashSet;
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

	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		
		
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
