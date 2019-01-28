package com.general.geeks.bst;

/**
 * 
 * Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Example 1:

Input: [1,3,null,null,2]

   1
  /
 3
  \
   2

Output: [3,1,null,null,2]

   3
  /
 1
  \
   2
Example 2:

Input: [3,1,4,null,null,2]

  3
 / \
1   4
   /
  2

Output: [2,1,4,null,null,3]

  2
 / \
1   4
   /
  3
Follow up:

A solution using O(n) space is pretty straight forward.
Could you devise a constant space solution?
 * 
 * @author skadavath
 *
 */
public class RecoverBinarySearchTree {

	TreeNode prev, first, middle, last;

	/**
	 * 
	 * The inorder will always give the sorted array
	 * 
	 * two cases :
	 * 
	 * The swapped nodes are not adjacent in the inorder traversal of the BST.
	 * 
	 * For example, Nodes 5 and 25 are swapped in {3 5 7 8 10 15 20 25}. The inorder
	 * traversal of the given tree is 3 25 7 8 10 15 20 5 If we observe carefully,
	 * during inorder traversal, we find node 7 is smaller than the previous visited
	 * node 25. Here save the context of node 25 (previous node). Again, we find
	 * that node 5 is smaller than the previous node 20. This time, we save the
	 * context of node 5 ( current node ). Finally swap the two node’s values.
	 * 
	 * 2. The swapped nodes are adjacent in the inorder traversal of BST.
	 * 
	 * For example, Nodes 7 and 8 are swapped in {3 5 7 8 10 15 20 25}. The inorder
	 * traversal of the given tree is 3 5 8 7 10 15 20 25 Unlike case #1, here only
	 * one point exists where a node value is smaller than previous node value. e.g.
	 * node 7 is smaller than node 8.
	 * 
	 * How to Solve? We will maintain three pointers, first, middle and last. When
	 * we find the first point where current node value is smaller than previous
	 * node value, we update the first with the previous node & middle with the
	 * current node. When we find the second point where current node value is
	 * smaller than previous node value, we update the last with the current node.
	 * In case #2, we will never find the second point. So, last pointer will not be
	 * updated. After processing, if the last node value is null, then two swapped
	 * nodes of BST are adjacent.
	 * 
	 * @param root
	 */

	public void recoverTree(TreeNode root) {

		recoverTreeUtil(root);

		if (first != null && last != null) {
			int temp = first.data;
			first.data = last.data;
			last.data = temp;

		}

		if (first != null && middle != null) {
			int temp = first.data;
			first.data = middle.data;
			middle.data = temp;
		}

	}

	public void recoverTreeUtil(TreeNode root) {

		if (null == root)
			return;

		recoverTreeUtil(root.left);
		if (null != prev && root.data < prev.data) {
			if (null == first) {
				first = prev;
				middle = root;
			} else
				last = root;

		}
		
		prev = root;

		recoverTreeUtil(root.right);

	}

}
