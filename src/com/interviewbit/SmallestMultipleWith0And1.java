package com.interviewbit;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SmallestMultipleWith0And1 {

	public static void main(String[] args) {
		
		System.out.println(new SmallestMultipleWith0And1().multiple(17));

	}

	public String multiple(int A) {
        if (A == 0)
            return "0";
        if (A == 1)
            return "1";
        
        long x = A;    
        
        Queue<Long> q = new ArrayDeque<>();
        q.offer(1L);
        long[] parent = new long[A + 1];
        Arrays.fill(parent, -1L);
        boolean[] added = new boolean[A + 1];
        
        while(parent[0] == -1 && !q.isEmpty()) {
            long v = q.poll();
            
            long next = (v * 10) % x;
            long next2 = (next + 1) % x;
            
            if (next != 1 && parent[(int)next] == -1L) {
                parent[(int)next] = v;
                q.offer(next);
            }
            if (next2 != 1 && parent[(int)next2] == -1L) {
                parent[(int)next2] = v;
                added[(int)next2] = true;
                q.offer(next2);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        long cur = 0;
        while(cur != 1L) {
            sb.append((added[(int)cur] ? '1' : '0'));
            cur = parent[(int)cur];
        }
        sb.append('1');
        return sb.reverse().toString();
    }
}
