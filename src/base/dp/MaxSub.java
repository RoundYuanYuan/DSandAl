package base.dp;

/**
 * @program: LeetCode
 * @description: LeetCode 53题 最大子序和
 * @author: Mr.Zhangmy
 * @create: 2020-08-07 11:23
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * ****************************************************************************************
 * 实现逻辑
 * 初始最大值 maxSub[0] = nums[0]
 * 创建数组记maxSub[]载 最大子序和
 * 便利nums maxSub[i]=maxSub[i-1]+nums[i]>num[i]?maxSub[i-1]+nums[i]:num[i]
 *
 * 算法复杂度 O(n)
 **/
public class MaxSub {
    public int maxSubArray(int[] nums) {
        int len=nums.length;
        int[] maxSub = new int[len];
        maxSub[0]=nums[0];
        for (int i=1;i<len;i++){
            maxSub[i]=maxSub[i-1]+nums[i]>nums[i]?maxSub[i-1]+nums[i]:nums[i];
        }
        int maxValue = getMaxValue(maxSub);
        return maxValue;
    }
    public int getMaxValue(int array[]){
        int max=array[0];
        for (int tmp: array) {
            max=max>=tmp?max:tmp;
        }
        return max;
    }
}
