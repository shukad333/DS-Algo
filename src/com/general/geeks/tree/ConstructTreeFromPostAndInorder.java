package com.general.geeks.tree;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note: You may assume that duplicates do not exist in the tree.
 * 
 * For example, given
 * 
 * inorder = [9,3,15,20,7] postorder = [9,15,7,20,3] Return the following binary
 * tree:
 * 
 * 3 / \ 9 20 / \ 15 7
 * 
 * @author skadavath
 *
 */
public class ConstructTreeFromPostAndInorder {

	public TreeNode buildTree(int[] inorder, int[] postorder) {

		return build(postorder, inorder, postorder.length - 1, 0, postorder.length - 1);

	}

	private TreeNode build(int[] pre, int[] in, int start, int end, int preStart) {
		if (preStart < 0 || start < end) {
			return null;
		}

		TreeNode node = new TreeNode(pre[preStart]);

		int inIndex = start; // Index of current root in inorder
		for (int i = start; i >= end; i--) {
			if (in[i] == node.data) {
				inIndex = i;
				break;
			}
		}

		node.right = build(pre, in, start, inIndex + 1, preStart - 1);
		node.left = build(pre, in, inIndex - 1, end, preStart - (start - inIndex) - 1);

		return node;
	}

}
