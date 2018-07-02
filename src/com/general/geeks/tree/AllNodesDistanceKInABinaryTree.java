package com.general.geeks.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * We are given a binary tree (with root node root), a target node, and an
 * integer value `K`.
 * 
 * Return a list of the values of all nodes that have a distance K from the
 * target node. The answer can be returned in any order.
 * 
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2 Output:
 * [7,4,1] Explanation: The nodes that are a distance 2 from the target node
 * (with value 5) have values 7, 4, and 1.
 * 
 * Note that the inputs "root" and "target" are actually TreeNodes. The
 * descriptions of the inputs above are just serializations of these objects.
 * 
 * @author skadavath
 *
 */
public class AllNodesDistanceKInABinaryTree {
	
	public static void main(String[] args) {
		
		TreeNode node = new TreeNode(3);
		node.left = new TreeNode(5);
		node.right = new TreeNode(1);
		node.left.left = new TreeNode(6);
		node.left.right = new TreeNode(2);
		node.left.right.left = new TreeNode(7);
		node.left.right.right = new TreeNode(4);
		node.right.left = new TreeNode(0);
		
		List<Integer> op = new AllNodesDistanceKInABinaryTree().distanceK(node, new TreeNode(4), 2);
		for(int i : op) {
			System.out.println(i+" ");
		}
	}

	private MyGraph targetGraphNode;

	public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
		
		MyGraph newGraph = convertToMyGraph(root, target, null);
		List<Integer> op = new ArrayList<>();
		doDFS(targetGraphNode, K, new ArrayList<>(), op);
		return op;

	}

	private void doDFS(MyGraph graph, int K, List<Integer> visited, List<Integer> op) {

		if (!visited.contains(graph.val)) {
			visited.add(graph.val);
			if (K == 0) {
				if (!op.contains(graph.val))
					op.add(graph.val);
			}
			for(MyGraph g : graph.neighbors) {
				doDFS(g, K-1, visited, op);
			}
		}

	}

	private MyGraph convertToMyGraph(TreeNode root, TreeNode target, MyGraph parent) {
		
		MyGraph graphNode = new MyGraph(root.data);
		
		if (null == targetGraphNode && target.data == root.data)
			targetGraphNode = graphNode;

		if (parent != null)
			graphNode.neighbors.add(parent);
		if (root.left != null)
			graphNode.neighbors.add(convertToMyGraph(root.left, target, graphNode));
		if (root.right != null)
			graphNode.neighbors.add(convertToMyGraph(root.right, target, graphNode));

		return graphNode;
	}

}

class MyGraph {
	int val;
	List<MyGraph> neighbors;

	public MyGraph(int val) {
		this.val = val;
		neighbors = new ArrayList<>();
	}
}
