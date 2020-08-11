package base.dp;

/**
 * @program: LeetCode
 * @description: LeetCode391 判断子序列
 * @author: Mr.Zhangmy
 * @create: 2020-08-07 19:54
 * **************************
 * url:https://leetcode-cn.com/problems/is-subsequence/
 * **************************
 * 思路
 * 子字符串 s 字符串 t
 * 1、取子字符串第一个 、第二个  判断是否存在 且返回所在位置 Intex1=t.charAt(s[0]) Index2=t.charAt(s[1])
 * 2、寻找第二个字符串 比第一个大 的位置
 *
 **/
public class IsSubsequence {
    //动态规划解法
    public boolean isSubsequence(String s, String t) {
        boolean table[][] = new boolean[s.length() + 1][t.length() + 1];
        for (int col=0; col<table[0].length; col++) {
            table[0][col] = true;
        }
        for (int row=1; row<table.length; row++) {
            char ch1 = s.charAt(row-1);
            for (int col=1; col<table[row].length; col++) {
                char ch2 = t.charAt(col-1);
                if (ch1==ch2) {
                    table[row][col] = table[row-1][col-1];
                } else {
                    table[row][col] = table[row][col-1];
                }
            }
        }
        boolean[] lastRow = table[table.length-1];
        return lastRow[lastRow.length-1];
    }
    /* 解法1
    public boolean isSubsequence(String s, String t) {
        int slen=s.length();
        int index=-1;
        for (int i=0;i<slen;i++){
            char c = s.charAt(i);
            index= t.indexOf(c, index + 1);
            if (index<0){
                return false;
            }
        }
        return true;
    }*/
}
