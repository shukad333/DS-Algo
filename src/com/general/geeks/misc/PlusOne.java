package com.general.geeks.misc;

public class PlusOne {
	
	public static void main(String[] args) {
		
		/*
		 * int[] digits = [1,2,3,4,5,6,7,8,9,1]
		 * plusOne -> [1,2,3,4,5,6,7,9,0,1]
		 */
		
		int[] arr = {0};
		
		PlusOne plus = new PlusOne();
		arr = plus.plusOne(arr);
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
	}
	
	public int[] plusOne(int[] digits) {
		
		
		int length = digits.length;
		int temp = digits[length-1] + 1;
		digits[length-1] = temp>=10?0:temp;
		int carry = temp >= 10 ? 1 : 0;
		for(int i=length-2;i>=0;i--) {
			
			temp = digits[i] + carry;
			carry = temp >= 10 ? 1 : 0;
			digits[i] = temp >= 10?0:temp;
		}
		
		if(carry!=0) {
			int[] newArr = new int[length+1];
			newArr[0] = carry;
			for(int i=0;i>length;i++) {
				newArr[i+1] = digits[i]; 
			}
			digits = newArr;
		}
		return digits;
	}

}
