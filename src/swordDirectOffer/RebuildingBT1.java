package swordDirectOffer;

import ts.zmy.com.day01.reverseWords;

public class RebuildingBT1 {
	public static void main(String[] args) {
		int[] pre= {1,2,4,7,3,5,6,8};
		int[] in= {4,7,2,1,5,3,8,6};
		TreeNode root = reConstructBinaryTree(pre,in);
		System.out.println(root.left.val);
	}
	public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		TreeNode root=getRootNode(in, 0, in.length-1, 0, pre.length-1, pre);
		return root;
	}
	public static TreeNode getRootNode(int [] in,int startIn,int endIn,int startPre,int endPre,int [] pre)
	{
		if(startPre>endPre||startIn>endIn){//判定是否序列是否便利完。
            return null;
        }
		TreeNode treeNode=new TreeNode(pre[startPre]);
		for(int i=startIn;i<=endIn;i++)
		{
			if(pre[startPre]==in[i])
			{
				treeNode.left=getRootNode(in, startIn, i-1, startPre+1, startPre+i-startIn, pre);
				treeNode.right=getRootNode(in, i+1, endIn, startPre+i-startIn+1, endPre+1, pre);
			}
		}
		return treeNode;
	}
}
