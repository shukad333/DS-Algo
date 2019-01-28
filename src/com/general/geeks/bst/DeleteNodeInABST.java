package com.general.geeks.bst;

/**
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
Note: Time complexity should be O(height of tree).

Example:

root = [5,3,6,2,4,null,7]
key = 3

    5
   / \
  3   6
 / \   \
2   4   7

Given key to delete is 3. So we find the node with value 3 and delete it.

One valid answer is [5,4,6,2,null,null,7], shown in the following BST.

    5
   / \
  4   6
 /     \
2       7

Another valid answer is [5,2,6,null,4,null,7].

    5
   / \
  2   6
   \   \
    4   7

 * @author skadavath
 *
 */
public class DeleteNodeInABST {
	
	public static void main(String[] args) {
		TreeNode node = new TreeNode(5);
		node.left = new TreeNode(3);
		node.right = new TreeNode(6);
		node.left.left = new TreeNode(2);
		node.left.right = new TreeNode(4);
		node.right.right = new TreeNode(7);
		
		TreeNode res = new DeleteNodeInABST().deleteNode(node, 3);
		new DeleteNodeInABST().preOrder(res);
	}
	
	private void preOrder(TreeNode node) {
		if(null == node)
			return;
		System.out.println(node.data);
		preOrder(node.left);
		preOrder(node.right);
	}

	public TreeNode deleteNode(TreeNode root, int key) {
		
		if(null==root) {
			return null;
		}
		
		if(key<root.data) {
			root.left = deleteNode(root.left, key);
		}
		else if(key>root.data) {
			root.right = deleteNode(root.right, key);
		}
		else {
			if(null==root.left) {
				return root.right;
			}
			else if(null==root.right) {
				return root.left;
			}
			
			TreeNode node = findMin(root.right);
			root.data = node.data;
			root.right = deleteNode(node.right, root.data);
			
		}
		
		return root;
	}
	
	private TreeNode findMin(TreeNode node) {
		while(node.left!=null)
			node = node.left;
		return node;
	}

}
