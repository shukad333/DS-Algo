package com.general.geeks.misc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Test {
	
	public static void main(String[] args) throws InterruptedException {
		
		int[] arr = {1,5,3,8,9};
		
		List<Integer> l = Arrays.asList(1,2,3,4,5,6);
		
		l.stream().filter(ll->ll%2==0).collect(Collectors.toList());
		
		int a=0;
		while(a++<10) {
		try {
			throw new NumberFormatException("Eaaa");
			
		}
		catch(NumberFormatException ne) {
			Thread.sleep(100);
			System.out.println("here");
			break;
		}
		catch(Exception e) {
			Thread.sleep(100);
			System.out.println("gneral");
		}
		}
		
		System.out.println("Here dude");
		
		
	}

}
