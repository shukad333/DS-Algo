package com.general.geeks.tree;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * Note: You may assume that duplicates do not exist in the tree.
 * 
 * For example, given
 * 
 * preorder = [3,9,20,15,7] inorder = [9,3,15,20,7] Return the following binary
 * tree:
 * 
 * 3 / \ 9 20 / \ 15 7
 * 
 * @author skadavath
 *
 */
public class ConstructTreeFromPreOrderAndPostOrder {

	public TreeNode buildTree(int[] preorder, int[] inorder) {

		return build(preorder, inorder, 0, preorder.length-1, 0);

	}

	private TreeNode build(int[] pre, int[] in, int start, int end, int preStart) {
		if (start > end || preStart > pre.length - 1) {
			return null;
		}

		TreeNode node = new TreeNode(pre[preStart]);

		int inIndex = searchIndex(in, node.data);

		node.left = build(pre, in, start, inIndex - 1, preStart + 1);
		node.left = build(pre, in, inIndex + 1, end, preStart + (inIndex - start));
		
		return node;
	}

	private int searchIndex(int[] inorder, int index) {
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == index) {
				return i;
			}
		}
		return -1;
	}

}
