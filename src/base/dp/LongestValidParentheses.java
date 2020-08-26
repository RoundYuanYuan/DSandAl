package base.dp;

/**
 * @program: LeetCode
 * @description: LeetCode32 最长有效括号
 * @author: Mr.Zhangmy
 * @create: 2020-08-26 09:26
 * ****************************************
 * url：https://leetcode-cn.com/problems/longest-valid-parentheses/
 * 解题思路：
 * 两种情况：
 * s[i]=')'&&s[i-1]='('
 * dp[i]=dp[i−2]+2
 * s[i]=')'&&s[i-1]=')' && s[i−dp[i−1]−1]=‘(’
 * dp[i]=dp[i−1]+dp[i−dp[i−1]−2]+2
 **/
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int slen=s.length();
        if (s==null||slen<2){
            return 0;
        }
        int dp[]=new int[slen];
        int maxnum=0;
        for (int i=1;i<slen;i++){
            char c = s.charAt(i - 1);
            char c1 = s.charAt(i);
            if (c1==')'){
                if (c=='('){
                    dp[i]=(i>=2?dp[i-2]:0)+2;
                }else if (i-dp[i-1]>0&&s.charAt(i-dp[i-1]-1)=='('){
                    dp[i]=dp[i-1]+((i-dp[i-1])>=2?dp[i-dp[i-1]-2]:0)+2;
                }
                maxnum=Math.max(maxnum,dp[i]);
            }
        }
        return maxnum;
    }
}
