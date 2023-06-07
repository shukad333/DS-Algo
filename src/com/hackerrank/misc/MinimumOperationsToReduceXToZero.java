package com.hackerrank.misc;

import java.util.HashMap;
import java.util.Map;

public class MinimumOperationsToReduceXToZero {

    public static void main(String[] args) {


        System.out.println(new MinimumOperationsToReduceXToZero().minOperations(new int[]{1,1,4,2,3},5));

    }

    public int minOperations(int[] nums, int x) {

        int target = -x;

        for(int n : nums)
            target+=n;

        if(target==0)
            return nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);

        int resp = Integer.MIN_VALUE;

        int sum = 0;
        for(int i=0;i<nums.length;i++) {

            sum += nums[i];
            if(map.containsKey(sum-target)) {
                resp = Math.max(resp,i-map.get(sum-target));
            }

            map.put(sum,i);
        }

        return resp == Integer.MIN_VALUE ? -1 : nums.length - resp;

    }


}
