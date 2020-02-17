package com.general.geeks.tree;

/**
 * 
 * In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.

 

Example 1:


Input: root = [1,2,3,4], x = 4, y = 3
Output: false
Example 2:


Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true
Example 3:



Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false
 

Note:

The number of nodes in the tree will be between 2 and 100.
Each node has a unique integer value from 1 to 100.

 * 
 * @author skadavath
 *
 */
public class CousinsInABinaryTree {
	
	public static void main(String[] args) {
		
		TreeNode tree = new TreeNode(1);
		tree.left = new TreeNode(2);
		tree.right = new TreeNode(3);
		tree.left.left = new TreeNode(4);
		tree.right.left = new TreeNode(6);
		tree.right.left.left = new TreeNode(8);
		
		System.out.println(new CousinsInABinaryTree().isCousins(tree, 4, 6));
	}
	
	public boolean isCousins(TreeNode root, int x, int y) {
		
		
		//return postOrder(root, x, y)==0;
		getRootAndDepth(root, x, y, null, 0);
		return (xParent!=yParent && xDepth==yDepth);
		

	}
	
	TreeNode xParent,yParent;
	int xDepth,yDepth;
	private void getRootAndDepth(TreeNode root , int x , int y , TreeNode parent,int depth) {
		if(null == root) {
			return ;
		}
		
		if(root.data == x) {
			xParent = parent;
			xDepth = depth;
		}
		
		if(root.data == y) {
			yParent = parent;
			yDepth = depth;
		}
		
		getRootAndDepth(root.left, x, y, root, depth+1);
		getRootAndDepth(root.right, x, y, root, depth+1);
		
	}
	
	private int postOrder(TreeNode root,int x , int y) {
		if(null==root)
			return -1;
		
		if(root.data==x || root.data == y)
			return 1;
		
		int left = postOrder(root.left, x, y);
		int right = postOrder(root.right, x, y);
		
		if(left>0 && right>0) {
			
			if(left==right) {
				//for parent
				return ((root.left.data==x && root.right.data==y) || (root.left.data==y && root.right.data==x))?-1:0;
			}
			else return -1;
			
			
		}
		//for level
		else if (left >= 0) return left == 0 ? 0 : left + 1;
		else if (right >= 0) return right == 0 ? 0 : right + 1;
		else return -1;
		
		
		
		
	}

}
