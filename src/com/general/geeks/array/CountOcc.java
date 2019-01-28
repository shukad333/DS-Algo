package com.general.geeks.array;

/**
 * 
 * @author skadavath
 *
 */
public class CountOcc {
	
	public static void main(String[] args) {
		//System.out.println(new CountOcc().count("5115 5"));
		int a = 4155;
		//System.out.println(a%10);
		int count=0;
		while(a>0) {
			int last = a%10;
			if(last==5)
				count++;
			a=a/10;
		}
		System.out.println(count);
		//new CountOcc().count("51555 5");
	}
	
	public int count(String a) {
		//String s = String.valueOf(a);
		int count=0;
		String[] arr = a.split(" ");
		for(char c : arr[0].trim().toCharArray()) {
			if(arr[1].equals(c+""))
				count++;
			//if(c==arr[1])
		}
		
		return count;
	}

}
