package swordDirectOffer.isBST;

import java.util.Arrays;

public class Solution {
	/**
	 * SwordDirectOffer-judge array is BST
	 * first：
	 * According to the	nature of BST：
	 * Root node value more than the left subtree
	 * and less than right sybtree
	 * @param args
	 */
	public static void main(String[] args) {
		int a[]= {1,7,3,10,12,14,9};
		System.out.println(VerifySquenceOfBST(a));
	}
	public static boolean VerifySquenceOfBST(int[] sequence)
	{
		if(sequence.length==0)
			return false;
		else
			return help(sequence);
	}
	public static boolean help(int[] sequence) {
		int len=sequence.length;
		if(len==1||len==0)
			return true;
		int boundary=len-1;
		for(int i=0;i<len-1;i++)
		{
			if(sequence[len-1]<sequence[i])
			{
				boundary=i;
				break;
			}
		}
		for(int i=boundary;i<len-1;i++)
		{
			if(sequence[len-1]>sequence[i])
				return false;
		}
		int [] leftSubTree=Arrays.copyOfRange(sequence, 0, boundary);
		int [] rightSubTree=Arrays.copyOfRange(sequence, boundary, len-1);
		return help(leftSubTree)&&help(rightSubTree);
	}
}
