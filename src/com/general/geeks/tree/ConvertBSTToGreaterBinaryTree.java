package com.general.geeks.tree;

/**
 * 
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that
 * every key of the original BST is changed to the original key plus sum of all
 * keys greater than the original key in BST.
 * 
 * Example:
 * 
 * Input: The root of a Binary Search Tree like this: 5 / \ 2 13
 * 
 * Output: The root of a Greater Tree like this: 18 / \ 20 13
 * 
 * @author skadavath
 *
 */
public class ConvertBSTToGreaterBinaryTree {
	
	public static void main(String[] args) {
		
		TreeNode node = new TreeNode(2);
		node.left = new TreeNode(1);
		node.right = new TreeNode(3);
		
		TreeNode n = new ConvertBSTToGreaterBinaryTree().convertBST(node);
		System.out.println(n.data);
		System.out.println(n.left.data);
	}
	public TreeNode convertBST(TreeNode root) {
			
		convert(root, new int[] {0});
		return root;
		
	}
	
	private void convert(TreeNode node , int[] sum) {
		
		if(null == node) {
			return;
		}
		
		convert(node.right,sum);
		node.data += sum[0];
		sum[0] = node.data;
		convert(node.left,sum);
	}

}
