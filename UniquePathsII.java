import java.util.Arrays;
public class UniquePathsII {
    public int uniquePaths(int r, int c, int row, int col, int[][] obstacleGrid,int[][] dp){

        if( r==row ||c==col)
            return 0;
        if(dp[r][c]!=-1)
            return dp[r][c];
        if(obstacleGrid[r][c]==1)
            return 0;
        if(r==row-1 && c==col-1)
            return 1;

        

        dp[r][c]=uniquePaths(r+1,c,row,col,obstacleGrid,dp) + uniquePaths(r,c+1,row,col,obstacleGrid,dp);
        return dp[r][c];

    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int[] arr: dp)
            Arrays.fill(arr,-1);
        return uniquePaths(0,0,obstacleGrid.length,obstacleGrid[0].length,obstacleGrid,dp);
    }
    public static void main(String[] args) {
        UniquePathsII up = new UniquePathsII();
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(up.uniquePathsWithObstacles(obstacleGrid));
    }
}