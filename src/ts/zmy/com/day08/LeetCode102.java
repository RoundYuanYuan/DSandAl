package ts.zmy.com.day08;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


public class LeetCode102 {
	static Scanner sc = new Scanner(System.in);

	public static List<List<Integer>> levelOrder(TreeNode root) {
		// 创建队列和列表
		Queue<TreeNode> treeQueue = new LinkedList<TreeNode>();
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(root==null)
			return res;
		TreeNode headNode;
		// 1.根节点进队列
		treeQueue.offer(root);
		// 2.出队列 --左右节点进队列
		// 3.重复2步骤
		while (!treeQueue.isEmpty()) {
			List<Integer> levelNode = new ArrayList<Integer>();
			int queueSize = treeQueue.size();
			for (int i = 0; i < queueSize; i++) {
				headNode = treeQueue.remove();
				levelNode.add(headNode.val);
				if (headNode.left != null) {
					treeQueue.offer(headNode.left);
				}
				if (headNode.right != null) {
					treeQueue.offer(headNode.right);
				}
			}
			res.add(levelNode);
		}
		return res;
	}

	public static TreeNode createTree() {
		int num = sc.nextInt();
		if (num == 0) {
			return null;
		}
		TreeNode treeNode = new TreeNode(num);
		System.out.println("left");
		treeNode.left = createTree();
		System.out.println("right");
		treeNode.right = createTree();
		return treeNode;
	}

	public static void main(String[] args) {
		TreeNode root = createTree();
		List<List<Integer>> ans = levelOrder(root);
		for (List<Integer> list : ans) {
			for (int num : list) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}
}
