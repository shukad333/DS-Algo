package com.general.geeks.bst;

/**
 * Given a binary search tree and the lowest and highest boundaries as L and R, trim the tree so that all its elements lies in [L, R] (R >= L). You might need to change the root of the tree, so the result should return the new root of the trimmed binary search tree.

Example 1:
Input: 
    1
   / \
  0   2

  L = 1
  R = 2

Output: 
    1
      \
       2
Example 2:
Input: 
    3
   / \
  0   4
   \
    2
   /
  1

  L = 1
  R = 3

Output: 
      3
     / 
   2   
  /
 1

 * @author skadavath
 *
 */
public class TrimABST {
	
	public static void main(String[] args) {
		
		TreeNode node = new TreeNode(0);
		node.left = new TreeNode(1);
		node.right = new TreeNode(2);
		
		TreeNode res = new TrimABST().trimBST(node, 2, 3);
		new TrimABST().printIn(res);
		
	}
	
	public void printIn(TreeNode node) {
		if(null == node)
			return;
		
		printIn(node.left);
		System.out.println(node.data);
		printIn(node.right);
	}

	public TreeNode trimBST(TreeNode root, int L, int R) {
		
		if(null == root) {
			return null;
		}
		
		if(root.data<L) return trimBST(root.right, L, R);
		if(root.data>R) return trimBST(root.left, L, R);
		
		root.left = trimBST(root.left, L, R);
		root.right = trimBST(root.right, L, R);
		
		return root;
	}

}
