package base.dp;

/**
 * @program: LeetCode
 * @description: LeetCode198.打家劫舍
 * @author: Mr.Zhangmy
 * @create: 2020-08-07 17:49
 * ****************************************************
 * url: https://leetcode-cn.com/problems/house-robber/
 * ****************************************************
 * 解题思路：
 * 可偷窃的户： nums[]
 * 最大偷窃金额: maxProfit[]
 * 1 : maxProfit[0]=nums[0]
 * 2 : maxProfit[1]=max(maxProfit[0],nums[1])
 * 3 : maxProfit[2]=max(maxProfit[0]+nums[2],maxProfit[1])
 * n : maxProfit[n-1]=max(maxProfit[n-3]+nums[n-1],maxProfit[n-2])
 **/
public class Rob {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len<1){
            return 0;
        }else if (len==1){
            return nums[0];
        }
        int[] maxProfit = new int[len];
        maxProfit[0]=nums[0];
        maxProfit[1]=nums[0]>nums[1]?nums[0]:nums[1];
        for (int i=2;i<len;i++){
            maxProfit[i]=maxProfit[i-2]+nums[i]>maxProfit[i-1]?maxProfit[i-2]+nums[i]:maxProfit[i-1];
        }
        int maxValue = getMaxValue(maxProfit);
        return maxValue;
    }
    public static int getMaxValue(int array[]){
        int max=array[0];
        for (int tmp: array) {
            max=max>=tmp?max:tmp;
        }
        return max;
    }
}
