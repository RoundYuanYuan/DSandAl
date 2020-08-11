package base.dp;

/**
 * @program: LeetCode
 * @description: LeetCode 303 区域和检索，数据不可变
 * @author: Mr.Zhangmy
 * @create: 2020-08-10 09:48
 * ********************************
 * url:https://leetcode-cn.com/problems/range-sum-query-immutable/
 * 接题思路：
 * 一、建二维数组缓冲所有区域和
 * 结果内存超出
 * 二、sum(i,j)=sum(j)-sum(i-1)
 **/
public class NumArray {
    int sums[];
    public NumArray(int[] nums) {
        int len=nums.length;
        sums=new int[len+1];
        sums[0]=0;
        for (int i=1;i<len+1;i++){
            sums[i]=sums[i-1]+nums[i-1];
        }
    }

    public int sumRange(int i, int j) {
        return sums[j+1]-sums[i];
    }

    public static void main(String[] args) {
        int nums[]={-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));
    }
}
