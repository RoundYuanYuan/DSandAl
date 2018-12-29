package ts.zmy.com.day09;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class LeetCode429 {
	/**
	 * 429. N叉树的层序遍历 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。 例如，给定一个 3叉树 :
	 */
	public static List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(root==null)
			return res;
		// 1、创建队列
		LinkedList<Node> queue = new LinkedList<Node>();
		// 2、树的根节点进队列
		queue.offer(root);
		ArrayList<Integer> levelList;
		while (!queue.isEmpty()) {
			levelList = new ArrayList<Integer>();
			int size = queue.size();
			Node node;
			// 3、根节点出队列
			// 4、出队列的子节点进队列 ---重复 直到队列为空
			for (int i = 0; i < size; i++) {
				node = queue.remove();
				levelList.add(node.val);
				List<Node> childrenNodeList = node.children;
				if(childrenNodeList!=null)
				{
					for (Node node2 : childrenNodeList) {
						queue.offer(node2);
					}
				}
				
			}
			res.add(levelList);
		}
		return res;
	}

	public static Node createTree() {
		Node node = new Node();
		node.val = 1;
		List<Node> childNodeList = new ArrayList<Node>();
		Node childNode = new Node();
		for (int i = 0; i < 4; i++) {
			childNode = new Node();
			childNode.val = i;
			childNodeList.add(childNode);
		}
		node.children = childNodeList;
		return node;
	}

	public static void main(String[] args) {
		Node root = createTree();
		List<List<Integer>> levelOrder = levelOrder(root);
		for (List<Integer> list : levelOrder) {
			for (Integer integer : list) {
				System.out.print(integer);
			}
			System.out.println();
		}
	}
}
