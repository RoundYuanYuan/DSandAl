package swordDirectOffer.isBalanceBST;


public class Solution {
	public boolean IsBalanced_Solution(TreeNode root) {
		if (root == null)
			return true;
		if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1)
			return false;

		return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
	}

	public int getHeight(TreeNode node) {
		if (node == null)
			return 0;
		return max(getHeight(node.left), getHeight(node.right)) + 1;
	}

	private int max(int a, int b) {
		return a > b ? a : b;
	}
	public static void main(String[] args) {
		TreeNode root=new TreeNode(3);
		root.left=new TreeNode(2);
		root.right=new TreeNode(1);
		root.left.left=new TreeNode(3);
		root.left.right=new TreeNode(4);
		root.right.right=new TreeNode(5);
		Solution s=new Solution();
		System.out.println(s.IsBalanced_Solution(root));
	}
}
