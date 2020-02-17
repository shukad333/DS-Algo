package com.general.geeks.misc;

import java.util.PriorityQueue;

public class ThirdLargest {

	public static void main(String[] args) {

		int[] nums = { 2, 2 };
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(4);
		pq.add(5);
		pq.add(2);
		System.out.println(pq.peek());
		System.out.println(pq.poll());
		System.out.println(pq.peek());
		System.out.println(pq.poll());
		System.out.println(new ThirdLargest().thirdMax(nums));

	}

	public int thirdMax(int[] nums) {

		Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        for (Integer n : nums) {
            if (n.equals(max1) || n.equals(max2) || n.equals(max3)) continue;
            if (max1 == null || n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (max2 == null || n > max2) {
                max3 = max2;
                max2 = n;
            } else if (max3 == null || n > max3) {
                max3 = n;
            }
        }
        return max3 == null ? max1 : max3;
	}

}
