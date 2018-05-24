package com.general.geeks.tree;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Serialization is the process of converting a data structure or object into a
 * sequence of bits so that it can be stored in a file or memory buffer, or
 * transmitted across a network connection link to be reconstructed later in the
 * same or another computer environment.
 * 
 * Design an algorithm to serialize and deserialize a binary tree. There is no
 * restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and
 * this string can be deserialized to the original tree structure.
 * 
 * Example:
 * 
 * You may serialize the following tree:
 * 
 * 1 / \ 2 3 / \ 4 5
 * 
 * as "[1,2,3,null,null,4,5]"
 * 
 * @author skadavath
 *
 */
public class SerializeDeserializeTree {
	
	public static void main(String[] args) {
		
		TreeNode node = new TreeNode(12);
		node.left = new TreeNode(1);
		node.right = new TreeNode(20);
		TreeNode newNode = new SerializeDeserializeTree().deserialize(new SerializeDeserializeTree().serialize(node));
		System.out.println(newNode.data);
	}

	private static final String Seperator = "#";
	private static final String NULL_VAL = "NA";

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {

		StringBuilder sb = new StringBuilder();
		serialize(root, sb);
		return sb.toString();
	}

	private void serialize(TreeNode root, StringBuilder sb) {

		if (null == root) {
			sb.append(NULL_VAL).append(Seperator);
		} else {
			sb.append(root.data).append(Seperator);
			serialize(root.left, sb);
			serialize(root.right, sb);
		}
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		
		Deque<String> deque = new LinkedList();
		deque.addAll(Arrays.asList(data.split(Seperator)));
		return deserializeTree(deque);
	}
	
	private TreeNode deserializeTree(Deque<String> data) {
		
		String val = data.remove();
		if(NULL_VAL.equals(val)) {
			return null;
		}
		else {
		TreeNode node = new TreeNode(Integer.valueOf(val));
		node.left = deserializeTree(data);
		node.right = deserializeTree(data);
		return node;
		}
	}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
