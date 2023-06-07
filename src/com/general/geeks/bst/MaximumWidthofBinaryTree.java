package com.general.geeks.bst;

import java.util.ArrayList;
import java.util.List;

public class MaximumWidthofBinaryTree {

    public static void main(String[] args) {

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(3);
        node.right = new TreeNode(5);
        node.left.right = new TreeNode(5);
        node.left.left = new TreeNode(5);
        node.right.right = new TreeNode(5);

        System.out.println(new MaximumWidthofBinaryTree().widthOfBinaryTree(node));

    }

    public int widthOfBinaryTree(TreeNode root) {
        return dfs(root, 0, 1, new ArrayList<>(), new ArrayList<Integer>());
    }

    public int dfs(TreeNode root, int level, int order, List<Integer> start, List<Integer> end){
        if(root == null)return 0;
        //everytime start adding the level to the start/end
        //start represents the leftmost and end rightmost of any level
        if(start.size() == level){
            start.add(order); end.add(order);
        }
        else
            end.set(level, order);
        int cur = end.get(level) - start.get(level) + 1;
        int left = dfs(root.left, level + 1, 2*order, start, end);
        int right = dfs(root.right, level + 1, 2*order + 1, start, end);
        return Math.max(cur, Math.max(left, right));
    }
}
