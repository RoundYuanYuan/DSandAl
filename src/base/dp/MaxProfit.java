package base.dp;

/**
 * @program: LeetCode
 * @description:
 * @author: Mr.Zhangmy
 * @create: 2020-08-07 16:39
 * ***************************************************************************
 * LeetCode 121
 * 题目链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * *****************************************************************************
 * 解题思路：
 * 创建收益存储数组：profit[n]
 * 第一天的收益：0  profit[0]=0
 * 第二天的收益：profit[1]=max(0,profit[0]+prices[1]-prices[0])
 * 第三天的收益：profit[2]=max(0,prices[2]-prices[1]+profit[1])
 * 第n天的收益: profit[n-1]=max(0,prices[n-1]-prices[n-2]+profit[n-2])
 * */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len<2){
            return 0;
        }
        int profit[]=new int[len];
        profit[0]=0;
        for (int i=1;i<len;i++){
            profit[i] = 0>profit[i-1]+prices[i]-prices[i-1]?0:profit[i-1]+prices[i]-prices[i-1];
        }
        int maxValue = getMaxValue(profit);
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
