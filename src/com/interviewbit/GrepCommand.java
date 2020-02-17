package com.interviewbit;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GrepCommand {
	
	
	public static void main(String[] args) {
		
		new GrepCommand().grepWords(new String[] {"njan","shu", "nooru","java","nee","jambi","finu"},3 ,"finu");
		
	}
	
	public void grepWords(String[] words,int K,String findWord) {
		
		Queue<String> list = new LinkedList<String>() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean add(String e) {
				// TODO Auto-generated method stub
				if(size()>=K) {
					super.remove(0);
				}
				return super.add(e);
			}
		};
		
		for(String w : words) {
			
			if(w.equals(findWord)) {
				System.out.println(list);
			}
			list.add(w);
			
		}
		
	}

}
