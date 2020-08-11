package base.dp;

/**
 * @program: LeetCode
 * @description: LeetCode62 不同的路径
 * @author: Mr.Zhangmy
 * @create: 2020-08-11 11:17
 * ***************************
 * 解题思路：倒推法
 * m*n 的网格 构成数组 array[n-1][m-1]
 * f(n-1,m-1)=f(n-2,m-1)+f(n-1,m-2)等同于 f[n][m]=f[n-1][m]+f[n][m-1]
 * f[0][0]=0
 * f[0][1]=1,f[1][0]=1
 * f[1][1]=f[0][1]+f[1][0]=2
 **/
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int path[][]=new int[n][m];
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (i==0||j==0){
                    path[i][j]=1;
                }else {
                    path[i][j]=path[i-1][j]+path[i][j-1];
                }
            }
        }
        return path[n-1][m-1];
    }

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePaths(7 ,3));
    }
}
