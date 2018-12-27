package ts.zmy.com.day08;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class LeetCode94 {
	/**
	 * 给定一个二叉树，返回它的中序 遍历。 1 输入: [1,null,2,3] \ 输出：[1,3,2] 2 / 3
	 */
	static Scanner sc = new Scanner(System.in);

	public static List<Integer> inorderTraversal(TreeNode root) {
		TreeNode currNode = root;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		List<Integer> list = new ArrayList<Integer>();

		while (currNode != null || !stack.isEmpty()) {
			while (currNode != null) {
				stack.push(currNode);
				currNode = currNode.left;
			}
			if (!stack.isEmpty()) {
				currNode = stack.pop();
				list.add(currNode.val);
				currNode = currNode.right;
			}
		}
		return list;
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
		List<Integer> list = inorderTraversal(root);
		
		for (Integer integer : list) {
			System.out.println(integer.intValue());
		}
	}

}
