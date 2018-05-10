package com.general.geeks.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]

 * @author skadavath
 *
 */
public class BinaryTreePaths {

	public static void main(String[] args) {

		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		node.left.right = new TreeNode(5);

		System.out.println(new BinaryTreePaths().binaryTreePaths(node));
	}

	public List<String> binaryTreePaths(TreeNode root) {
		List<String> answer = new ArrayList<String>();
		if (root != null)
			searchBT(root, "", answer);
		return answer;
	}

	private void searchBT(TreeNode root, String path, List<String> answer) {
		if (root.left == null && root.right == null)
			answer.add(path + root.data);
		if (root.left != null)
			searchBT(root.left, path + root.data + "->", answer);
		if (root.right != null)
			searchBT(root.right, path + root.data + "->", answer);
	}

}
