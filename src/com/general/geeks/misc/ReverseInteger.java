package com.general.geeks.misc;

public class ReverseInteger {
	
	public static void main(String[] args) {
		
		ReverseInteger ri = new ReverseInteger();
		System.out.println(ri.reverse(1534236469));
		
	}
	public int reverse(int x) {
		
		boolean isPostive = true;
		if(x<0) {
			isPostive = false; 
			x*=-1;
		}
		
		int rev = 0;
		int prevNum = 0;
		while(x>0) {
			int temp = x%10;
			rev = rev*10+temp;
			//Check for overflow bro
			if((rev-temp)/10!=prevNum) {
				return 0;
			}
			prevNum = rev;
			x = x/10;
		}
		
		
		if(!isPostive)
			rev*=-1;
		
		return rev;
		
		}
	
	
}
