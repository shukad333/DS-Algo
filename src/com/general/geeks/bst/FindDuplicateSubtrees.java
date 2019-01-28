package com.general.geeks.bst;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.general.geeks.linkedlist.Node;

/**
 * Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees, you only need to return the root node of any one of them.

Two trees are duplicate if they have the same structure with same node values.

Example 1:

        1
       / \
      2   3
     /   / \
    4   2   4
       /
      4
The following are two duplicate subtrees:

      2
     /
    4
and

    4
Therefore, you need to return above trees' root in the form of a list.
 * @author skadavath
 *
 */
public class FindDuplicateSubtrees {
	
	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.left.left = new TreeNode(4);
		node.right = new TreeNode(3);
		node.right.right = new TreeNode(4);
		node.right.left = new TreeNode(2);
		node.right.left.left = new TreeNode(4);
		
		List<TreeNode> resp = new FindDuplicateSubtrees().findDuplicateSubtrees(node);
		System.out.println(resp.size());
	}

	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		
		List<TreeNode> resp = new ArrayList<TreeNode>();
		
		HashMap<String,Integer> map = new HashMap<>();
		
		findDup(resp, root, map);
		return resp;

	}
	
	private String findDup(List<TreeNode> resp , TreeNode root,HashMap<String,Integer> map) {
		
		if(null==root) {
			return "";
		}
		
		String hash = "(";
		hash+=findDup(resp, root.left, map);
		hash+=root.data+"";
		hash+=findDup(resp, root.right, map);
		hash+=")";
		
		if(!map.containsKey(hash)) {
			map.put(hash, 1);
		}
		else {
			if(map.get(hash)==1) {
				resp.add(root);
			}
			map.put(hash, map.get(hash)+1);
		}
		return hash;
	}
	
	

}
