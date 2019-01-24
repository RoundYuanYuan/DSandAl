package swordDirectOffer.getNextNode;

class TreeLinkNode {
	int val;
	TreeLinkNode left = null;
	TreeLinkNode right = null;
	TreeLinkNode next = null;

	TreeLinkNode(int val) {
		this.val = val;
	}
}
/**
 * 
 * @author user
 * solution
 * 1、right node is existing
 *    Returns the leftmost node of the right subtree
 * 2、right node is not existing
 *    1）current node is left node
 *       return the parent of the current node.
 *    2)current node is right node
 *       always return to the child node as the left node
 */
public class Solution {
	public TreeLinkNode GetNext(TreeLinkNode pNode) {
		if(pNode.right!=null)
		{
			pNode=pNode.right;
			while(pNode.left!=null)
			{
				pNode=pNode.left;
			}
			return pNode;
		}
		while(isLeftNode(pNode)!=-1)
		{
			if(isLeftNode(pNode)==0)
				return pNode.next;
			if(isLeftNode(pNode)==1)
				pNode=pNode.next;
		}
		return null;
	}
	public int  isLeftNode(TreeLinkNode node)
	{
		if(node.next==null)
			return -1;
		if(node.next.left!=null&&node.next.left==node)
			return 0;
		return 1;
	}
	public static void main(String[] args) {
		TreeLinkNode root = new TreeLinkNode(1);
		root.next=null;
		root.left=new TreeLinkNode(2);
		root.left.next=root;
		TreeLinkNode target=new TreeLinkNode(3);
		root.left.right=target;
		target.next=root.left;
		Solution s=new Solution();
		System.out.println(s.GetNext(target).val);
	}
}
