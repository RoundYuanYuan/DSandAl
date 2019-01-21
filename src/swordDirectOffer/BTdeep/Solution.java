package swordDirectOffer.BTdeep;

import java.util.ArrayList;


public class Solution {
	public static int TreeDepth(TreeNode root) {
		if(root==null)
			return 0;
		int leftdeep=0;
		int rightdeep=0;
		if(root.left==null&&root.right==null)
			return 1;
		if(root.left!=null)
			leftdeep=1+TreeDepth(root.left);
		if(root.right!=null)
			rightdeep=1+TreeDepth(root.right);
		return leftdeep>rightdeep?leftdeep:rightdeep;
	}
	public static void main(String[] args) {
		TreeNode root=new TreeNode(3);
		root.left=new TreeNode(2);
		root.right=new TreeNode(1);
		root.left.left=new TreeNode(3);
		root.left.right=new TreeNode(4);
		root.right.right=new TreeNode(5);
		
		System.out.println(TreeDepth(root));
	}
	
}

class TreeNode {
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;

	public TreeNode(int val) {
		this.val = val;

	}
}
