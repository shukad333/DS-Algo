package com.general.geeks.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * 
 * 
 * @author skadavath
 *
 */
public class WodBoggle {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println(new WodBoggle().getWordBoggle(new String[] {"GEEKS", "FOR", "QUIZ", "GO"}, new char[][]{{'G','I','Z'},
            {'U','E','K'},
            {'Q','S','E'}}));
		
	
		
	}
	
	public List<String> getWordBoggle(String[] dictionary,char[][] boggle) {
		
		boolean[][] visited = new boolean[boggle.length][boggle[0].length];
		List<String> resp = new ArrayList<>();
		for(int i=0;i<boggle.length;i++)
			for(int j=0;j<boggle[0].length;j++)
				dfs(boggle, dictionary, visited, i, j, new StringBuilder(), resp);
		return resp;
		
	}
	
	int[][] dirs = {{0,1},{0,-1},{1,1},{1,-1},{-1,-1},{-1,1},{-1,0},{1,0}};
	private void dfs(char[][] boggle,String[] dictionary,boolean[][] visited,int x,int y,StringBuilder s,List<String> resp) {
		
		
		
		s.append(boggle[x][y]);
		
		if(checkInDict(dictionary, s.toString())) {
			resp.add(s.toString());
			//return true;
		}
		
		
		for(int[] dir : dirs) {
			
			int dx = x+dir[0];
			int dy = y+dir[1];
			if(dx>=boggle.length || dx<0 || dy<0 || dy>=boggle[0].length || visited[dx][dy])
				continue;
			visited[dx][dy] = true;
			dfs(boggle, dictionary, visited, dx, dy, s, resp);
			//	return true;
			
			visited[dx][dy] = false;
			s.deleteCharAt(s.length()-1);
			}
		
		
//		return false;
		
		
	}
	
	private boolean checkInDict(String[] dictionary,String s) {
		for(String d : dictionary) {
			if(d.equals(s))
				return true;
		}
		
		return false;
	}
	
	

}
