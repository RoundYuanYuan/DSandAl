package swordDirectOffer;

import java.util.Arrays;

public class RebuildingBT {
	public static void main(String[] args) {
		int[] pre= {1,2,4,7,3,5,6,8};
		int[] in= {4,7,2,1,5,3,8,6};
		RebuildingBT rebuildingBT = new RebuildingBT();
		TreeNode root = rebuildingBT.reConstructBinaryTree(pre,in );
		System.out.println(root.right);
	}

	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {

		TreeNode root = new TreeNode(pre[0]);
		addNode(root, 1, in, pre);
		return root;
	}

	public static int[][] splitTree(int val, int[] subTree) {
		int index = 0;
		int len = subTree.length;
		for (int i = 0; i < len; i++) {
			if (val == subTree[i]) {
				index = i;
				break;
			}
		}
		int[] leftTree = Arrays.copyOfRange(subTree, 0, index);
		if(index+1>len)
			index=index-1;
		int[] rightTree = Arrays.copyOfRange(subTree, index+1, len);
		int[][] res = { leftTree, rightTree };
		return res;
	}

	public static boolean contains(int val,int[] arr) {
		for(int i=0;i<arr.length;i++)
		{
			if(val==arr[i])
				return true;
		}
		return false;
	}
	

	public void addNode(TreeNode treeNode, int n, int[] subTree, int[] pre) {
		if (subTree.length == 0 || n > pre.length)
			return;
		int [][] splitTree = splitTree(treeNode.val, subTree);
		if (contains(pre[n],  splitTree[0])) {
			treeNode.left = new TreeNode(pre[n]);
			addNode(treeNode.left, n + 1, splitTree[0], pre);
		}
		n=n+splitTree[0].length;
		if(n>=pre.length)
			return;
		if (contains(pre[n],  splitTree[1])) {
			treeNode.right = new TreeNode(pre[n]);
			addNode(treeNode.right, n + 1, splitTree[1], pre);
		}
	}

}
