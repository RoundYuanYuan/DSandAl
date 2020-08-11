package base.dp;

/**
 * @program: LeetCode
 * @description: LeetCode746 使用最小花费爬楼梯
 * @author: Mr.Zhangmy
 * @create: 2020-08-10 20:05
 *
 * url: https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 * **************************************************************
 * 解题思路：
 * 构建 dp 数组 dp[]
 * 台阶数量
 * 1    dp[0]=cost[0]
 * 2    dp[1]=cost[1]
 * 3    dp[2]=max(dp[0]+cost[2],dp[1])
 * 4    dp[3]=max(dp[1]+cost[3],dp[2])
 *
 * n    dp[n-1]=(max[n-3]+cost[n-1],dp[n-2])
 **/
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len];
        dp[0]=cost[0];
        dp[1]=cost[1];
        for (int i=2;i<len;i++){
            dp[i]=cost[i]+Math.min(dp[i-2],dp[i-1]);
        }
        return Math.min(dp[len-1],dp[len-2]);
    }

    public static void main(String[] args) {
        MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs();
        int array[]={1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs.minCostClimbingStairs(array));
    }
}
