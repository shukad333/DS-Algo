package com.general.geeks.array.dynamicprogramming;


/**
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:

Input: [3,2,3,null,3,null,1]

     3
    / \
   2   3
    \   \ 
     3   1

Output: 7 
Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:

Input: [3,4,5,1,3,null,1]

     3
    / \
   4   5
  / \   \ 
 1   3   1

Output: 9
Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 * @author skadavath
 *
 */
public class HouseRobberIII {
	
	public static void main(String[] args) {
		
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		node.left.left = new TreeNode(10);
		
		System.out.println(new HouseRobberIII().rob(node));
		
	}

	public int rob(TreeNode root) {
		
		/**
		 * Two scenarios , 
		 * 
		 * rob the root , then grandchildren max(root.left.let,root,left.right,root.right.left,root.right.right)
		 * or don't rob the root and rob root.left and root.right
		 */
		
		
		if(null==root)
			return 0;
		
		int val = 0;
		if(null!=root.left)
			val += rob(root.left.left)+rob(root.left.right);
		
		if(null!=root.right)
			val += rob(root.right.left)+rob(root.right.right);
		
		//now calculate if root is not robbed and max
		
		return Math.max(val+root.data, rob(root.left)+rob(root.right));
	}

}

class TreeNode {
	
	int data;
	TreeNode left;
	TreeNode right;
	public TreeNode(int data) {
		
		this.data = data;
		this.left = left;
		this.right = right;
		
	}
}
