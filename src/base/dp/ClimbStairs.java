package base.dp;

/**
 * @program: LeetCode
 * @description: LeetCode70 爬楼梯
 * @author: Mr.Zhangmy
 * @create: 2020-08-07 16:16
 * 解题思路：
 * 楼梯数  方法
 * 1      1
 * 2      1+1，2
 * 3      1+1+1,2+1
 * 4      1+1+1+1,2+1+1,1+1+2,2+2
 * n      f(n-1)+1,f(n-2)+2
 *
 * 推出公式为：
 * f(n)=f(n-1)+f(n-2)
 * 时间复杂度 O(n)
 **/
public class ClimbStairs {
    public int climbStairs(int n) {
        if (n<3){
            return n;
        }
        int[] dp = new int[n];
        dp[0]=1;
        dp[1]=2;
        for (int i=2;i<n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n-1];
    }
}
