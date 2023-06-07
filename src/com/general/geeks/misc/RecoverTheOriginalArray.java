package com.general.geeks.misc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RecoverTheOriginalArray {

    public static void main(String[] args) {

        int[] resp = new RecoverTheOriginalArray().recoverArray(new int[]{2,10,6,4,8,12});
        System.out.println(Arrays.toString(resp));

    }

    int[] ans;
    public int[] recoverArray(int[] nums) {
        int n = nums.length/2;
        ans = new int[n];
        Arrays.sort(nums);
        Map<Integer, Integer> hm = new HashMap<>();

        for(int num: nums){
            hm.put(num, hm.getOrDefault(num,0)+1);
        }
        for(int i=1; i<=n; i++){
            int k = (nums[i] - nums[0]);
            if(k!=0 && k%2==0){
                if(check(nums, new HashMap<>(hm), k)) return ans;
            }
        }
        return ans;
    }
    boolean check(int[] nums, Map<Integer, Integer> map, int k){
        int idx = 0;
        for(int num: nums){
            if(map.getOrDefault(num,0) == 0) continue;
            if(map.getOrDefault(num+k,0) == 0) return false;
            map.put(num, map.get(num)-1);
            map.put(num+k, map.get(num+k)-1);
            ans[idx++] = num+k/2;
        }
        return true;
    }

}
