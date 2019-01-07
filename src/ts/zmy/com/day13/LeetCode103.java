package ts.zmy.com.day13;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import ts.zmy.com.day11.*;

public class LeetCode103 {
	public static void main(String[] args) throws Exception, IOException {
		TreeStorage treeStorage = new TreeStorage();
		ts.zmy.com.day11.TreeNode root=treeStorage.readTree("Tree102");
		List<List<Integer>> zigzagLevelOrder = zigzagLevelOrder(root);
		for (List<Integer> list : zigzagLevelOrder) {
			for (Integer integer : list) {
				System.out.print(integer);
			}
			System.out.println();
		}
	}
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		boolean flag=true;//定义正序还是反序
		LinkedList<TreeNode> quee = new LinkedList<TreeNode>();
		if(root!=null)
			quee.offer(root);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		while(!quee.isEmpty())
		{
			ArrayList<Integer> list = new ArrayList<Integer>();
			int len=quee.size();
			for(int i=0;i<len;i++)
			{
				TreeNode treeNode = quee.remove();
				list.add(treeNode.val);
				if(treeNode.left!=null)
					quee.offer(treeNode.left);
				if(treeNode.right!=null)
					quee.offer(treeNode.right);
			}
			if(!flag)
				Collections.reverse(list);
			res.add(list);
			flag=!flag;
		}
		return res;
	}
}
