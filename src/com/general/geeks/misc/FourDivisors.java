package com.general.geeks.misc;

/**
 *
 * Given an integer array nums, return the sum of divisors of the integers in that array that have exactly four divisors.
 *
 * If there is no such integer in the array, return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [21,4,7]
 * Output: 32
 * Explanation:
 * 21 has 4 divisors: 1, 3, 7, 21
 * 4 has 3 divisors: 1, 2, 4
 * 7 has 2 divisors: 1, 7
 * The answer is the sum of divisors of 21 only.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10^4
 * 1 <= nums[i] <= 10^5
 *
 */
public class FourDivisors {


    public static void main(String[] args) {

        int[] nums = {21,4,7};
        System.out.println(new FourDivisors().sumFourDivisors(nums));

    }


    //catch here is , for a number to have exactly 4 divisors , it will be 1,n and a pair d,n/d where n/d!=d
    public int sumFourDivisors(int[] nums) {

        int resp  = 0;

        for(int n : nums) {

            int lastDivisor = 0;
            for(int d=2;d*d<=n;d++) {

                if(n%d==0) {
                    if(lastDivisor==0)
                        lastDivisor=d;
                    else {
                        lastDivisor=0;
                        break;
                    }
                }


            }

            if(lastDivisor>0 && n/lastDivisor!=lastDivisor)
                resp += 1+n+lastDivisor + n/lastDivisor;



        }

        return resp;

    }
}
