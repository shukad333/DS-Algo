package com.general.codechef.may;

import java.util.Scanner;

public class NaiveChef {
	
	public static void main(String[] args) {
		System.out.println(~2);
		System.out.println(Integer.toBinaryString(-2));
	}
	
	private double getProbalility(String dice , String numbers) {
		String[] diceStr = dice.split(" ");
		String[] numStr = numbers.split(" ");
		int[] diceArr = new int[diceStr.length];
		int[] numArr = new int[numStr.length];
		for(int i=0;i<diceStr.length;i++) {
			diceArr[i] = Integer.parseInt(diceStr[i]);
		}
		for(int i=0;i<numStr.length;i++) {
			numArr[i] = Integer.parseInt(numStr[i]);
		}
		int numOfFaces = diceArr[0];
		int numA = diceArr[1];
		int numB = diceArr[2];
		
		int cA = 0;
		int cB = 0;
		for(int j=0;j<numArr.length;j++) {
			if(numArr[j]==numA)
				cA++;
			if(numArr[j]==numB)
				cB++;
		}
		
		double probA = cA/numArr.length;
		double probB = cB/numArr.length;
		
		return 0;
	}
}
