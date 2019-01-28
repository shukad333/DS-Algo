package com.general.geeks.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * A complete binary tree is a binary tree in which every level, except possibly
 * the last, is completely filled, and all nodes are as far left as possible.
 * 
 * Write a data structure CBTInserter that is initialized with a complete binary
 * tree and supports the following operations:
 * 
 * CBTInserter(TreeNode root) initializes the data structure on a given tree
 * with head node root; CBTInserter.insert(int v) will insert a TreeNode into
 * the tree with value node.val = v so that the tree remains complete, and
 * returns the value of the parent of the inserted TreeNode;
 * CBTInserter.get_root() will return the head node of the tree.
 * 
 * 
 * Example 1:
 * 
 * Input: inputs = ["CBTInserter","insert","get_root"], inputs = [[[1]],[2],[]]
 * Output: [null,1,[1,2]] Example 2:
 * 
 * Input: inputs = ["CBTInserter","insert","insert","get_root"], inputs =
 * [[[1,2,3,4,5,6]],[7],[8],[]] Output: [null,3,4,[1,2,3,4,5,6,7,8]]
 * 
 * 
 * Note:
 * 
 * The initial given tree is complete and contains between 1 and 1000 nodes.
 * CBTInserter.insert is called at most 10000 times per test case. Every value
 * of a given or inserted node is between 0 and 5000.
 * 
 * @author skadavath
 *
 */
public class CompleteBinaryTreeInserter {
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		CompleteBinaryTreeInserter inserted = new CompleteBinaryTreeInserter(root);
		
		
		
	}
	
    List<TreeNode> tree;
    public CompleteBinaryTreeInserter(TreeNode root) {
        tree = new ArrayList<>();
        tree.add(root);
        for (int i = 0; i < tree.size(); ++i) {
            if (tree.get(i).left != null) tree.add(tree.get(i).left);
            if (tree.get(i).right != null) tree.add(tree.get(i).right);
        }
    }

    public int insert(int v) {
        int N = tree.size();
        TreeNode node = new TreeNode(v);
        tree.add(node);
        if (N % 2 == 1)
            tree.get((N - 1) / 2).left = node;
        else
            tree.get((N - 1) / 2).right = node;
        return tree.get((N - 1) / 2).data;
    }

    public TreeNode get_root() {
        return tree.get(0);
    }

}
