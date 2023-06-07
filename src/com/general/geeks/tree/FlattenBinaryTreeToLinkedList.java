package com.general.geeks.tree;

public class FlattenBinaryTreeToLinkedList {

    public static void main(String[] args) {

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(4);
        node.right = new TreeNode(5);
        node.right.right = new TreeNode(6);

        new FlattenBinaryTreeToLinkedList().flatten(node);
    }

    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(null==root)
            return;

        flatten(root.right);
        flatten(root.left);

        root.left = null;
        root.right = prev;
        prev = root;
    }

}
