package com.general.geeks.misc;

import java.util.*;

/**
 *
 * Given an array of integers arr, you are initially positioned at the first index of the array.
 *
 * In one step you can jump from index i to index:
 *
 * i + 1 where: i + 1 < arr.length.
 * i - 1 where: i - 1 >= 0.
 * j where: arr[i] == arr[j] and i != j.
 * Return the minimum number of steps to reach the last index of the array.
 *
 * Notice that you can not jump outside of the array at any time.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [100,-23,-23,404,100,23,23,23,3,404]
 * Output: 3
 * Explanation: You need three jumps from index 0 --> 4 --> 3 --> 9. Note that index 9 is the last index of the array.
 * Example 2:
 *
 * Input: arr = [7]
 * Output: 0
 * Explanation: Start index is the last index. You don't need to jump.
 * Example 3:
 *
 * Input: arr = [7,6,9,6,9,6,9,7]
 * Output: 1
 * Explanation: You can jump directly from index 0 to index 7 which is last index of the array.
 * Example 4:
 *
 * Input: arr = [6,1,9]
 * Output: 2
 * Example 5:
 *
 * Input: arr = [11,22,7,7,7,7,7,7,7,22,13]
 * Output: 3
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 5 * 10^4
 * -10^8 <= arr[i] <= 10^8
 *
 */
public class JumpGame4 {

    public int minJumps(int[] arr) {

        //DFS

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0;i<arr.length;i++)  {
            map.putIfAbsent(arr[i],new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        int resp = 0;
        Set<Integer> visited = new HashSet<>();
        while(!queue.isEmpty()) {

            int size = queue.size();
            for(int i=0;i<size;i++) {
                int curr = queue.poll();
                if(curr==arr.length-1)
                    return resp;
                if(curr+1<arr.length && visited.add(curr+1))
                    queue.offer(curr+1);
                if(curr-1>=0 && visited.add(curr-1))
                    queue.offer(curr-1);
                List<Integer> eq = map.get(curr);

                for(int j : eq) {

                    if(visited.add(j))
                        queue.offer(j);

                }
            }
            resp++;

        }

        return resp;

    }
}
