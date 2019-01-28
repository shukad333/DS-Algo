package com.general.geeks.misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * 
A number is called as a Jumping Number if all adjacent digits in it differ by 1. The difference between ‘9’ and ‘0’ is not considered as 1.
All single digit numbers are considered as Jumping Numbers. For example 7, 8987 and 4343456 are Jumping numbers but 796 and 89098 are not.

Given a positive number x, print all Jumping Numbers smaller than or equal to x. The numbers can be printed in any order.

Example:

Input: x = 20
Output:  0 1 2 3 4 5 6 7 8 9 10 12

Input: x = 105
Output:  0 1 2 3 4 5 6 7 8 9 10 12
         21 23 32 34 43 45 54 56 65
         67 76 78 87 89 98 101

Note: Order of output doesn't matter, 
i,e., numbers can be printed in any order

 * 
 * @author skadavath
 *
 */
public class JumpingNumber {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		JumpingNumber jn = new JumpingNumber();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		//System.out.println("N is "+N);
		
		for(int i=0;i<N;i++) {
			
			int x = Integer.parseInt(br.readLine());
			jn.printJumpingNumber(x);
			
		}
		
	}
	
	public void printJumpingNumber(int x) {
		
		Set<Integer> set = new TreeSet<>();
		for(int i=0;i<=9 && i<x;i++) {
			dfs(i,x,set);
		}
		
		for(int a : set)
			System.out.print(a+" ");
	}
	
	private void dfs(int i , int x,Set<Integer> set) {
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(i);
		
		while(!queue.isEmpty()) {
			
			int num = queue.poll();
			
			if(num<=x) {
				
				set.add(num);
				int last = num % 10;
				
				if(last==0) {
					queue.add((num*10) + (last+1));
				}
				else if(last==9) {
					queue.add((num*10) + (last-1));
				}
				else {
					
					queue.add((num*10) + (last+1));
					queue.add((num*10) + (last-1));
					
				}
				
			}
			
		}
		
	}

}
