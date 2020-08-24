package base.dp;

/**
 * @program: LeetCode
 * @description: LeetCode44 通配符匹配
 * @author: Mr.Zhangmy
 * @create: 2020-08-24 11:26
 * ********************************
 * url：https://leetcode-cn.com/problems/wildcard-matching/
 * 解题思路：
 * 创建动态规划数组dp[slen+1][plen+1]
 * dp[0][0]=true
 * dp[0][n]= dp[0][n-1]&&(p[n]==*)     (n>=1<=plen)
 * p[n]=?  dp[n][n]=dp[n-1][n-1]
 * p[n]=*  dp[n][n]=dp[n][n-1]||dp[n-1][n]
 **/
public class IsMatch {
    public boolean isMatch(String s, String p) {
        int slen=s.length();
        int plen=p.length();
        boolean dp[][]=new boolean[slen+1][plen+1];
        dp[0][0]=true;
        for (int col=1;col<=plen;col++){
            if (p.charAt(col-1)=='*'){
                dp[0][col]=dp[0][col-1];
            }
        }
        for (int row=1;row<=slen;row++){
            char c1 = s.charAt(row - 1);
            for (int col=1;col<=plen;col++){
                char c2 = p.charAt(col - 1);
                if (c1==c2||c2=='?'){
                    dp[row][col]=dp[row-1][col-1];
                }else if (c2=='*'){
                    dp[row][col]=dp[row-1][col]||dp[row][col-1];
                }
            }
        }
        return dp[slen][plen];
    }

    public static void main(String[] args) {
        IsMatch isMatch = new IsMatch();
        System.out.println(isMatch.isMatch("aa", "*"));
    }
}
