package com.general.geeks.tree;

/**
 * 
 * Given a binary tree, we install cameras on the nodes of the tree.
 * 
 * Each camera at a node can monitor its parent, itself, and its immediate
 * children.
 * 
 * Calculate the minimum number of cameras needed to monitor all nodes of the
 * tree.
 * 
 * 
 * 
 * 
 * 
 * @author skadavath
 *
 */
public class BinaryTreeCameras {
	
	public static void main(String[] args) {
		
		TreeNode node = new TreeNode(1);
//		node.left = new TreeNode(2);
//		node.left.left = new TreeNode(3);
//		node.left.left.right = new TreeNode(4);
//		node.left.left.right.left = new TreeNode(5);
		
		System.out.println(new BinaryTreeCameras().minCameraCover(node));
		
	}

	public int minCameraCover(TreeNode root) {
		
		int[] cameras = new int[1];
		int cam = minCamera(root, cameras);
		
		return cameras[0]+(cam==-2?1:0);

	}
	
	public int minCamera(TreeNode root , int[] cameras) {
		
		if(null==root) {
			return -1;
		}
		
		int left = minCamera(root.left, cameras);
		int right = minCamera(root.right, cameras);
		
		//if both childs are null ,
		//no need a camera there since it can be managed by the parent
		if(left==-1 && right==-1) {
			return -2;
		}
		//if both the childs are leaf , place a camera in that node
		else if(left==-2 || right==-2) {
			cameras[0]++;
			return 0;
		}
		//else tell the parent that it needs to be managed
		else
			return -1;
	}

}
