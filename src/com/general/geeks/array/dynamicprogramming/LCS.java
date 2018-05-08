package com.general.geeks.array.dynamicprogramming;

public class LCS {
	
	public static void main(String[] args) {
		
		System.out.println(new LCS().LCSWithoutMemo("SHUHAIL".toCharArray(), "SHAMU".toCharArray(), 7, 5));
		System.out.println(new LCS().LCSWithMemo("SHUHAIL".toCharArray(), "SHAMU".toCharArray(), 7, 5));
	}
	
	public int LCSWithoutMemo(char[] X , char[] Y , int m , int n) {
		
		if(m==0 || n==0) {
			return 0;
		}
		
		if(X[m-1] == Y[n-1]) {
			return 1 + LCSWithoutMemo(X, Y, m-1, n-1);
		}
		else {
			return Math.max(LCSWithoutMemo(X, Y, m-1, n), LCSWithoutMemo(X, Y, m, n-1));
		}
	}
	
	public int LCSWithMemo(char[] X , char[] Y , int m , int n) {
		
		int L[][] = new int[m+1][n+1];
		 
	    /* Following steps build L[m+1][n+1] in bottom up fashion. Note
	         that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
	    for (int i=0; i<=m; i++)
	    {
	      for (int j=0; j<=n; j++)
	      {
	        if (i == 0 || j == 0)
	            L[i][j] = 0;
	        else if (X[i-1] == Y[j-1])
	            L[i][j] = L[i-1][j-1] + 1;
	        else
	            L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
	      }
	    }
	  return L[m][n];
	}

}
