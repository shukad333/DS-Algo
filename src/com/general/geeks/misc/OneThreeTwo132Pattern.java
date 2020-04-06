package com.general.geeks.misc;

import java.util.Stack;

public class OneThreeTwo132Pattern {

    public static void main(String[] args) {

        int[] nums = {-1, 2,10,4};
        System.out.println(new OneThreeTwo132Pattern().find132pattern(nums));

    }



    public boolean find132pattern(int[] nums) {

        Stack<Pair> stack = new Stack<>();

        for(int n : nums) {
            if(stack.isEmpty() || stack.peek().min>n)
                stack.push(new Pair(n,n));
            else if (n>stack.peek().min) {
                Pair last = stack.pop();
                if(n<last.max)
                    return true;
                else {
                    last.max = n;
                    while(!stack.isEmpty() && stack.peek().max<=n)
                        stack.pop();

                    //at this point , if stack is not empty we have an element with n<peek().max
                    if(!stack.isEmpty() && stack.peek().min<n)
                        return true;
                    stack.push(last);
                }
            }
        }

        return false;

    }

    public boolean _find132pattern(int[] nums) {

        int min_i = Integer.MAX_VALUE;

        for(int i=0;i<nums.length;i++) {
            min_i = Math.min(min_i,nums[i]);
            for(int j=i+1;j<nums.length;j++) {
                if(nums[i]>nums[j] && min_i<nums[j])
                    return true;
            }
        }

        return false;

    }
}

class Pair {

    int min,max;
    public Pair(int min,int max) {
        this.min = min;
        this.max = max;
    }
}
