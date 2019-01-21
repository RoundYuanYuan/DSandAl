package swordDirectOffer.levelTransveBT;

import java.util.ArrayList;
import java.util.LinkedList;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
public class LevelTrasver {
	
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		ArrayList<Integer> arrayList =new ArrayList<Integer>();
		if(root==null)
			return arrayList;
		LinkedList<TreeNode> linkedList = new LinkedList<TreeNode>();
		linkedList.offer(root);
		while(!linkedList.isEmpty())
		{
			TreeNode treeNode = linkedList.remove();
			arrayList.add(treeNode.val);
			if(treeNode.left!=null)
				linkedList.add(treeNode.left);
			if(treeNode.right!=null)
				linkedList.add(treeNode.right);
		}
		return arrayList;
	}
}
