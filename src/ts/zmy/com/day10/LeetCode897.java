package ts.zmy.com.day10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import ts.zmy.com.day10.TreeNode;

/**
 * 
 * @author user
 * @version 1
 * @produce 解决方案： 1、Build the tree after traversing the order  ×
 *                   2、Build while traversing
 *          
 */

public class LeetCode897 {
	static Scanner sc = new Scanner(System.in);

	public static TreeNode increasingBST(TreeNode root) {
		ArrayList<Integer> treeList = inOrder(root);
		TreeNode prevNode = null;
		TreeNode nRoot = new TreeNode(treeList.get(0));
		prevNode = nRoot; // 将数组构建成成树
		for (int i = 1; i < treeList.size(); i++) {
			TreeNode nCurrNode = new TreeNode(treeList.get(i));
			prevNode.right = nCurrNode;
			prevNode = nCurrNode;
		}
		return nRoot;
	}

	/**
	 * 将数组中序遍历 返回遍历后的数组
	 * 
	 * @param root
	 * @return
	 */
	public static ArrayList<Integer> inOrder(TreeNode root) {
		Stack<TreeNode> treeStack = new Stack<TreeNode>();
		ArrayList<Integer> treeList = new ArrayList<Integer>();
		TreeNode currNode = root;
		while (!treeStack.isEmpty() || currNode != null) {
			if (currNode != null) {
				treeStack.push(currNode);
				currNode = currNode.left;
			} else if (!treeStack.isEmpty()) {
				currNode = treeStack.pop();
				treeList.add(currNode.val);
				currNode = currNode.right;
			}
		}
		return treeList;
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
		ArrayList<Integer> treeList = inOrder(root);
		for (Integer integer : treeList) {
			System.out.println(integer);
		}

		TreeNode nRoot = increasingBST(root);
		while (nRoot != null) {
			System.out.println(nRoot.val);
			nRoot = nRoot.right;
		}

	}
}
