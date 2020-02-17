package com.general.geeks.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such
 * that a + b + c = 0? Find all unique triplets in the array which gives the sum
 * of zero.
 * 
 * Note:
 * 
 * The solution set must not contain duplicate triplets.
 * 
 * Example:
 * 
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * 
 * A solution set is: [ [-1, 0, 1], [-1, -1, 2] ]
 * 
 * @author skadavath
 *
 */
public class ThreeSum {
	
	public static void main(String[] args) {
		
		System.out.println(new ThreeSum().threeSum(new int[] {-31013930, -31013930, 9784175, 21229755}));
		System.out.println(new ThreeSum().threeSum(Arrays.asList(-31013930, -31013930, 9784175, 21229755)));
		
	}

	public List<List<Integer>> threeSum(int[] nums) {

		List<List<Integer>> resp = new ArrayList<>();

		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {

			if (i > 0 && nums[i] == nums[i - 1])
				continue;

			int left = i + 1, right = nums.length - 1;

			int target = -nums[i];

			while (left < right) {
				if (nums[left] + nums[right] == target) {
					resp.add(Arrays.asList(nums[left], nums[i], nums[right]));
					left++;
					right--;

					while (left < nums.length && nums[left] == nums[left - 1])
						left++;
					while (right >= 0 && nums[right] == nums[right + 1])
						right--;
				} else if (nums[left] + nums[right] > target) {
					right--;

				} else
					left++;
			}

		}

		return resp;
	}
	
public ArrayList<ArrayList<Integer>> threeSum(List<Integer> A) {
        
        ArrayList<ArrayList<Integer>> resp = new ArrayList<>();
        
        Collections.sort(A);
        for(int i=0;i<A.size()-2;i++) {
            
            if(i>0 && A.get(i).equals(A.get(i-1)))
            continue;
            int left = i+1,right = A.size()-1;
            int target = -A.get(i);
            while(left<right) {
                if(A.get(left)+A.get(right) == target) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(A.get(i));
                    temp.add(A.get(left));
                    temp.add(A.get(right));
                    resp.add(temp);
                    left++;right--;
                    while(left<A.size() && A.get(left)==A.get(left-1))
                    left++;
                    while(right>=0 && A.get(right)==A.get(right+1))
                    right--;
                    
                }
                else if(A.get(left)+A.get(right)<=target) {
                    left++;
                }
                else
                right--;
            }
        }
        
        return resp;
    }
}
