package com.general.geeks.misc;

public class MatrixTranspose {
	
	public static void main(String[] args) {
		
		int[][] B = new MatrixTranspose().transpose(new int[][] {{1,2,3},{4,5,6}});
		for(int i=0;i<B.length;i++) {
			for(int j=0;j<B[0].length;j++) {
				System.out.print(B[i][j]+" ");
			}
			System.out.println();
		}
		
	}

	public int[][] transpose(int[][] A) {
		
		int[][] B = new int[A[0].length][A.length];
		for(int i=0;i<A.length;i++) {
			for(int j=0;j<A[0].length;j++) {
				B[j][i] = A[i][j];
			}
		}
		
		return B;

	}

}
