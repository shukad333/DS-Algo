package com.general.geeks.linkedlist;

public class NumbersSum {
	
	public static void main(String[] args) {
		
		Node l1 = new Node(9);
		Node temp = l1;
		for(int i=0;i<20;i++) {
			l1.next = new Node(9);
			l1 = l1.next;
		}
//		l1.next = new Node(6);
//		l1.next.next = new Node(3);
//		
		Node l2 = new Node(1);
//		l2.next = new Node(4);
//		l2.next.next  = new Node(2);
//		
		
		Node res = sum(temp,l2);
		while(res!=null) {
			System.out.println(res.data);
			res = res.next;
		}
	}
	
	public static Node sum(Node l1,Node l2) {
		
		Node res = null;
		Node temp = null;
		Node prev = null;
		int carry=0,sum=0;
		
		while(l1!=null || l2!=null) {
			
			sum = carry+(l1!=null?l1.data:0) + (l2!=null?l2.data:0);
			carry = sum>=10?1:0;
			sum = sum%10;
			
			temp = new Node(sum);
			if(null==res) {
				
				res = temp;
			}
			else {
				
				prev.next = temp;
			}
			
			prev = temp;
			
			if(l1!=null)
				l1 = l1.next;
			if(l2!=null)
				l2 = l2.next;
			
			
		}
		if(carry>0) {
			temp.next = new Node(carry);
		}
		return res;
		
	}
}
