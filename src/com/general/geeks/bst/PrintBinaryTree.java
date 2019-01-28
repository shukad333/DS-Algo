package com.general.geeks.bst;

import java.util.ArrayList;
import java.util.List;

/**
 * Print a binary tree in an m*n 2D string array following these rules:

The row number m should be equal to the height of the given binary tree.
The column number n should always be an odd number.
The root node's value (in string format) should be put in the exactly middle of the first row it can be put. The column and the row where the root node belongs will separate the rest space into two parts (left-bottom part and right-bottom part). You should print the left subtree in the left-bottom part and print the right subtree in the right-bottom part. The left-bottom part and the right-bottom part should have the same size. Even if one subtree is none while the other is not, you don't need to print anything for the none subtree but still need to leave the space as large as that for the other subtree. However, if two subtrees are none, then you don't need to leave space for both of them.
Each unused space should contain an empty string "".
Print the subtrees following the same rules.
Example 1:
Input:
     1
    /
   2
Output:
[["", "1", ""],
 ["2", "", ""]]
Example 2:
Input:
     1
    / \
   2   3
    \
     4
Output:
[["", "", "", "1", "", "", ""],
 ["", "2", "", "", "", "3", ""],
 ["", "", "4", "", "", "", ""]]
Example 3:
Input:
      1
     / \
    2   5
   / 
  3 
 / 
4 
Output:

[["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
 ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
 ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
 ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
Note: The height of binary tree is in the range of [1, 10].
 * @author skadavath
 *
 */
public class PrintBinaryTree {
	
	public static void main(String[] args) {
		
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.left.left = new TreeNode(3);
		node.left.left = new TreeNode(4);
		node.right = new TreeNode(5);
		
		//System.out.println(new PrintBinaryTree().printTree(node));
		
		List<String> temp = new ArrayList<>();
		temp.add("s");
		List<List<String>> r1 = new ArrayList<>();
		r1.add(temp);
		List<List<String>> r2 = new ArrayList<>();
		r1 = new ArrayList<>();
		r1.add(new ArrayList<>(temp));
	}

	public List<List<String>> printTree(TreeNode root) {
		
		List<List<String>> resp = new ArrayList<List<String>>();
		int rows = height(root);
		int cols = (int) (Math.pow(2, rows) - 1);
		
		List<String> temp = new ArrayList<>();
		
		for(int i=0;i<cols;i++) temp.add("");
		for(int i=0;i<rows;i++) resp.add(new ArrayList<>(temp));
		
		print(root, resp,0, rows, 0	, cols-1);
		
		return resp;
		
	}
	
	private void print(TreeNode root, List<List<String>> resp, int row, int totalRows, int i, int j) {

		if (row == totalRows ||  null == root) {
			
			return;
		}
		
		resp.get(row).set((i+j)/2, root.data+"");
		print(root.left, resp,  row+1, totalRows, i, (i+j)/2-1);
		print(root.right, resp,  row+1, totalRows, (i+j)/2+1, j);

	}

	private int height(TreeNode root) {
		if (null == root)
			return 0;

		return 1 + Math.max(height(root.left), height(root.right));
	}

}
