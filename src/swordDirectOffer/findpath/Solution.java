package swordDirectOffer.findpath;

import java.util.ArrayList;

public class Solution {
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
    	ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> list=new ArrayList<Integer>();
    	help(root,target,0,list,res);
		return res;
    }
    public static void help(TreeNode node,int target,int sum,ArrayList<Integer> list,ArrayList<ArrayList<Integer>> res)
    {
    	if(node==null)
    		return;
    	sum+=node.val;
    	
    	if(sum>target)
    		return;
    		
    	if(node.left==null&&node.right==null)
    	{
    		if(sum==target)
        	{
    			list.add(node.val);
        		res.add(new ArrayList(list));
        		list.remove(list.size()-1);
        	}
    		return;
    	}
    	list.add(node.val);
    	help(node.left,target,sum,list,res);
    	help(node.right,target,sum,list,res);
    	list.remove(list.size()-1);
    }
    public static void main(String[] args) {
    	TreeNode root=new TreeNode(3);
    	root.left=new TreeNode(2);
    	root.right=new TreeNode(1);
    	root.left.left=new TreeNode(3);
    	root.left.right=new TreeNode(4);
    	root.right.right=new TreeNode(5);
    	
    	ArrayList<ArrayList<Integer>> findPath = FindPath(root,9);
    	for (ArrayList<Integer> arrayList : findPath) {
			for (Integer num : arrayList) {
				System.out.println(num);
			}
			System.out.println();
		}
    	
	}
    
}
