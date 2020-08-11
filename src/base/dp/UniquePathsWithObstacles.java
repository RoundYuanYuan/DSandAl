package base.dp;

/**
 * @program: LeetCode
 * @description: LeetCode63 不同路径 II
 * @author: Mr.Zhangmy
 * @create: 2020-08-11 14:40
 * *******************************************
 * 继承UniquePaths 的思路 只需要声明 有障碍物的方法 到达路径为0 即可
 **/
public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n=obstacleGrid.length;
        int m=obstacleGrid[0].length;
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (obstacleGrid[i][j]==1){
                    obstacleGrid[i][j]=0;
                }else if (i==0&&j==0){
                    obstacleGrid[i][j]=1;
                }
                else if (i==0){
                    obstacleGrid[i][j]=obstacleGrid[i][j-1];
                }else if (j==0){
                    obstacleGrid[i][j]=obstacleGrid[i-1][j];
                } else{
                    obstacleGrid[i][j]=obstacleGrid[i-1][j]+obstacleGrid[i][j-1];
                }
            }
        }
        return obstacleGrid[n-1][m-1];
    }

    public static void main(String[] args) {
        UniquePathsWithObstacles uniquePathsWithObstacles = new UniquePathsWithObstacles();
        int[][] arrays = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles.uniquePathsWithObstacles(arrays));
    }
}
