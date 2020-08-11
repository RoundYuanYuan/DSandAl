package base.dp;

/**
 * @program: LeetCode
 * @description: LeetCode64 最小路径和
 * @author: Mr.Zhangmy
 * @create: 2020-08-11 15:22
 * *****************************************
 * url: https://leetcode-cn.com/problems/minimum-path-sum/
 * 从 0,0 节点开始
 **/
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int dp[][]=new int[row][col];

        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                if (i==0&&j==0){
                    dp[i][j]=grid[i][j];
                }else if (i==0){
                    dp[i][j]=dp[i][j-1]+grid[i][j];
                }else if (j==0){
                    dp[i][j]=dp[i-1][j]+grid[i][j];
                }else {
                    dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
                }
            }
        }
        return dp[row-1][col-1];
    }
}
