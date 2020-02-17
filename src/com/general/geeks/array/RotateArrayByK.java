package com.general.geeks.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class RotateArrayByK {
	

	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5,6,7};
		System.out.println(Arrays.stream(arr).sum());
		StringBuilder sb = new StringBuilder();
		sb.append(" ");
		sb.append(" ");
		sb.append("#");
		System.out.println(sb.toString());
		rotateArr(arr,8);
		for(int i : arr) {
			System.out.print(i+" ");
		}
		
		String s="";
		System.out.println(s.contains("shu"));
		Set<Integer> set = new HashSet<>();
		set.add(1);
		set.add(2);
		
		Iterator<Integer> it = set.iterator();
		System.out.println(it.next());
		System.out.println(it.next());
	}
	
	public static void rotateArr(int[] arr , int k) {
		
		for(int i=0;i<k;i++) {
			int element = arr[arr.length-1];
			for(int j=arr.length-1;j>0;j--) {
				arr[j] = arr[j-1];
			}
			arr[0] = element;
		}
		
	}

}
