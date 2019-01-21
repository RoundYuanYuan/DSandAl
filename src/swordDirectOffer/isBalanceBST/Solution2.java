package swordDirectOffer.isBalanceBST;

public class Solution2 {
	public boolean IsBalanced_Solution(TreeNode root) {
		return isBalanced(root)!=-1;
	}
	public int isBalanced(TreeNode node)
	{
		if(node==null)
			return 0;
		
	    int left=isBalanced(node.left);
	    if(left==-1)
	    	return -1;
	    int right=isBalanced(node.right);
	    if(right==-1)
	    	return -1;
	    return Math.abs(right-left)>1?-1:1+Math.max(left, right);
	}
}
