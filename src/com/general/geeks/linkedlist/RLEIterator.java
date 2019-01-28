package com.general.geeks.linkedlist;

/**
 * 
 * @author skadavath
 *
 */
public class RLEIterator {
	
	public static void main(String[] args) {
		
		RLEIterator it = new RLEIterator(new int[] {3,8,0,9,2,5});
		System.out.println(it.next(2));
		System.out.println(it.next(1));
		System.out.println(it.next(1));
		System.out.println(it.next(1));
		System.out.println(it.next(1));
		
	}
	
	
	int[] arr;
	int index = 0;
	public RLEIterator(int[] A) {
		
		arr = A;

	}

	 public int next(int n) {
	        while(index < arr.length && n > arr[index]){
	            n = n - arr[index];
	            index += 2;
	        }
	        
	        if(index >= arr.length){
	            return -1;
	        }
	        
	        arr[index] = arr[index] - n;
	        return arr[index + 1];
	    }
}

/**
 * Your RLEIterator object will be instantiated and called as such: RLEIterator
 * obj = new RLEIterator(A); int param_1 = obj.next(n);
 */