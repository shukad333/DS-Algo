package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *
 * The power of an integer x is defined as the number of steps needed to transform x into 1 using the following steps:
 *
 * if x is even then x = x / 2
 * if x is odd then x = 3 * x + 1
 * For example, the power of x = 3 is 7 because 3 needs 7 steps to become 1 (3 --> 10 --> 5 --> 16 --> 8 --> 4 --> 2 --> 1).
 *
 * Given three integers lo, hi and k. The task is to sort all integers in the interval [lo, hi] by the power value in ascending order, if two or more integers have the same power value sort them by ascending order.
 *
 * Return the k-th integer in the range [lo, hi] sorted by the power value.
 *
 * Notice that for any integer x (lo <= x <= hi) it is guaranteed that x will transform into 1 using these steps and that the power of x is will fit in 32 bit signed integer.
 *
 *
 *
 * Example 1:
 *
 * Input: lo = 12, hi = 15, k = 2
 * Output: 13
 * Explanation: The power of 12 is 9 (12 --> 6 --> 3 --> 10 --> 5 --> 16 --> 8 --> 4 --> 2 --> 1)
 * The power of 13 is 9
 * The power of 14 is 17
 * The power of 15 is 17
 * The interval sorted by the power value [12,13,14,15]. For k = 2 answer is the second element which is 13.
 * Notice that 12 and 13 have the same power value and we sorted them in ascending order. Same for 14 and 15.
 * Example 2:
 *
 * Input: lo = 1, hi = 1, k = 1
 * Output: 1
 * Example 3:
 *
 * Input: lo = 7, hi = 11, k = 4
 * Output: 7
 * Explanation: The power array corresponding to the interval [7, 8, 9, 10, 11] is [16, 3, 19, 6, 14].
 * The interval sorted by power is [8, 10, 11, 7, 9].
 * The fourth number in the sorted array is 7.
 * Example 4:
 *
 * Input: lo = 10, hi = 20, k = 5
 * Output: 13
 * Example 5:
 *
 * Input: lo = 1, hi = 1000, k = 777
 * Output: 570
 *
 *
 * Constraints:
 *
 * 1 <= lo <= hi <= 1000
 * 1 <= k <= hi - lo + 1
 * Accepted
 *
 */
public class SortIntegersByThePowerValue {

    public static void main(String[] args) {
        System.out.println(new SortIntegersByThePowerValue().getKth(12,15,2));
    }

    public int getKth(int lo, int hi, int k) {

        map.put(1,0);

        int resp = 0;

        List<Integer[]> lists = new ArrayList<>();
        for(int i=1;i<=hi;i++) {

            getPower(i);

            if(i>=lo) {

                lists.add(new Integer[]{i,map.get(i)});

            }

        }

        lists.sort((l1,l2)->l1[1]==l2[1]?l1[0]-l2[0]:l1[1]-l2[1]);

        System.out.println(lists);
        return lists.get(k-1)[0];

    }

    Map<Integer,Integer> map = new HashMap<>();
    private int getPower(int num) {
        if(map.containsKey(num))
            return map.get(num);

        int resp = num%2==0?getPower(num/2):getPower(3*num+1);
        map.put(num,resp+1);

        return map.get(num);
    }
}
