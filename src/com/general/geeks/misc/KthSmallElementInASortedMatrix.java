package com.general.geeks.misc;

/**
 * Given a n x n matrix where each of the rows and columns are sorted in
 * ascending order, find the kth smallest element in the matrix.
 * 
 * Note that it is the kth smallest element in the sorted order, not the kth
 * distinct element.
 * 
 * Example:
 * 
 * matrix = [ [ 1, 5, 9], [10, 11, 13], [12, 13, 15] ], k = 8,
 * 
 * return 13. Note: You may assume k is always valid, 1 ≤ k ≤ n2.
 * 
 * @author skadavath
 *
 */
public class KthSmallElementInASortedMatrix {
	
	public static void main(String[] args) {
		System.out.println(new KthSmallElementInASortedMatrix().kthSmallest(new int[][] {{1, 5,9},{10,11,13},{12,13,15}},8));
		//System.out.println(new KthSmallElementInASortedMatrix().kthSmallest(new int[][] {{1,2,3,4},{10,20,30,40}},8));
	}

	public int kthSmallest(int[][] matrix, int k) {
		
		
		//binary search using range
		
		int high = matrix[matrix.length-1][matrix[0].length-1],low = matrix[0][0];
		
		while(low<high) {
			
			int mid = low + (high-low)/2;
			int count=0,j=matrix[0].length-1;
			for(int i=0;i<matrix.length;i++) {
				while(j>=0 && matrix[i][j]>mid)
					j--;
				count+=(j+1);
			}
			if(count<k)low=mid+1;
			else
				high=mid-1;
		}
		
		return low;
	}

}
