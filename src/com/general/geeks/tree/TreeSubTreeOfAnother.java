package com.general.geeks.tree;


/**
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

Example 1:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
Given tree t:
   4 
  / \
 1   2
Return true, because t has the same structure and node values with a subtree of s.
Example 2:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
    /
   0
Given tree t:
   4
  / \
 1   2
Return false.
 * @author skadavath
 *
 */
public class TreeSubTreeOfAnother {
	
	public static void main(String[] args) {
		
		TreeNode treeS = new TreeNode(3);
		treeS.left = new TreeNode(4);
		treeS.right = new TreeNode(5);
		treeS.left.left = new TreeNode(1);
		treeS.left.right = new TreeNode(2);
		
		TreeNode treeT = new TreeNode(4);
		treeT.left = new TreeNode(1);
		treeT.right = new TreeNode(22);
		
		System.out.println(new TreeSubTreeOfAnother().isSubtree(treeS, treeT));
		
	}

	public boolean isSubtree(TreeNode s, TreeNode t) {
		
		if(t==null) {
			return true;
		}
		
		if(s==null) {
			return false;
		}
		
		if(isTreesIdentical(s, t)) {
			return true;
		}
		
		
		return isSubtree(s.left, t) || isSubtree(s.right, t);

	}
	
	public boolean isTreesIdentical(TreeNode s , TreeNode t) {
		
		if(s==null && t==null) {
			return true;
		}
		
		if(s==null || t==null) {
			return false;
		}
		
		return (s.data == t.data && isTreesIdentical(s.left, t.left) && isTreesIdentical(s.right, t.right));
	}

}
