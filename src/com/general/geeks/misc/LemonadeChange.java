package com.general.geeks.misc;

/**
 * At a lemonade stand, each lemonade costs $5.
 * 
 * Customers are standing in a queue to buy from you, and order one at a time
 * (in the order specified by bills).
 * 
 * Each customer will only buy one lemonade and pay with either a $5, $10, or
 * $20 bill. You must provide the correct change to each customer, so that the
 * net transaction is that the customer pays $5.
 * 
 * Note that you don't have any change in hand at first.
 * 
 * Return true if and only if you can provide every customer with correct
 * change.
 * 
 * 
 * @author skadavath
 *
 */
public class LemonadeChange {
	
	public static void main(String[] args) {
		System.out.println(new LemonadeChange().lemonadeChange(new int[] {5,5,10,10,20}));
	}

	public boolean lemonadeChange(int[] bills) {
		
		int fiveRupess = 0;
		int tenRupees = 0;
		for(int i : bills) {
			if(i==5)fiveRupess++;
			if(i==10) {
				tenRupees++;
				if(fiveRupess>0) {
					fiveRupess--;
				}
				else
					return false;
			}
			if(i==20) {
				if(tenRupees>0 && fiveRupess>0) {
					tenRupees--;
					fiveRupess--;
				}
				else if(fiveRupess>3){
					
						fiveRupess-=3;
					}
				
				else
					return false;
				}
				
			
		}
		return true;

	}

}
