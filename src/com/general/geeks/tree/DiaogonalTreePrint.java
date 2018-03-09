package com.general.geeks.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DiaogonalTreePrint {

	public static void main(String[] args) {

		TreeNode tree = new TreeNode(100);
		tree.left = new TreeNode(50);
		tree.right = new TreeNode(200);
		tree.left.left = new TreeNode(25);
		tree.left.right = new TreeNode(75);
		tree.right.right = new TreeNode(400);
		tree.right.right.right = new TreeNode(600);
		
		printDiag(tree);

	}

	static void printDiag(TreeNode node) {
		
		Map<Integer, List<Integer>> map = new HashMap();
		printDiag(0, map, node);
		
		for(Map.Entry<Integer, List<Integer>> entries : map.entrySet()) {
			
			entries.getValue().forEach(val->{
				System.out.print(val+" ");
			});
			System.out.println();
		}

	}

	static void printDiag(int level, Map<Integer, List<Integer>> map, TreeNode node) {

		if (null == node) {
			return;
		}

		List<Integer> nodeDatas = map.get(level);
		if (null == nodeDatas) {
			List<Integer> temp = new LinkedList();
			temp.add(node.data);
			map.put(level, temp);
		} else {
			nodeDatas.add(node.data);
		}

		printDiag(level + 1, map, node.left);
		printDiag(level, map, node.right);
	}

}
