package com.general.geeks.tree;

/**
 * Given a tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only 1 right child.

Example 1:
Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]

       5
      / \
    3    6
   / \    \
  2   4    8
 /        / \ 
1        7   9

Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

 1
  \
   2
    \
     3
      \
       4
        \
         5
          \
           6
            \
             7
              \
               8
                \
                 9  
Note:

The number of nodes in the given tree will be between 1 and 100.
Each node will have a unique integer value from 0 to 1000.
 * @author skadavath
 *
 */
public class IncreasingOrderSearchTree {
	
	public static void main(String[] args) {
		
		TreeNode node = new TreeNode(10);
		node.left = new TreeNode(5);
		node.right = new TreeNode(100);
		
		TreeNode resp = new IncreasingOrderSearchTree().increasingBST(node);
		new IncreasingOrderSearchTree().preOrder(resp);
		
	}

	public TreeNode increasingBST(TreeNode root) {
		
		return increasingOrderBST(root, null);

	}
	
	private TreeNode increasingOrderBST(TreeNode root , TreeNode parent) {
		
		if(null==root)
			return parent;
		
		TreeNode resp = increasingOrderBST(root.left, root);
		root.left = null;
		root.right = increasingOrderBST(root.right, parent);
		return resp;
	}
	
	public void preOrder(TreeNode node) {
		if(null==node)
			return ;
		
		System.out.println(node.data+" ");
		preOrder(node.left);
		preOrder(node.right);
		
	}

}
