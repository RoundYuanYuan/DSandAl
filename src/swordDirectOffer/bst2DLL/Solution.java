package swordDirectOffer.bst2DLL;

public class Solution {
	public TreeNode Convert(TreeNode pRootOfTree) {
		if(pRootOfTree==null)
			return null;
		TreeNode lastNode = null;
		
		lastNode = getLastNode(pRootOfTree, lastNode);

		TreeNode headNode = lastNode;

		while (headNode.left != null)

			headNode = headNode.left;

		return headNode;
	}

	public TreeNode getLastNode(TreeNode root, TreeNode lastNode) {
		if (root == null)
			return lastNode;
		TreeNode currNode = root;
		if (currNode.left != null)
			lastNode = getLastNode(currNode.left, lastNode);
		currNode.left = lastNode;
		if (lastNode != null)
			lastNode.right = currNode;
		lastNode = currNode;
		if (currNode.right != null)
			lastNode = getLastNode(currNode.right, lastNode);
		return lastNode;
	}
}
