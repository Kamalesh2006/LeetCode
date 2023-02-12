import java.util.LinkedList;
import java.util.Queue;

public class AsFarAsLand {
    class Pair{
        int row;
        int col;
        Pair(int r, int c){
            this.row = r;
            this.col = c;
        }
    }
    public int maxDistance(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        Queue<Pair> landPos = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];
        for(int i = 0;i<row;i++){
            for(int j =0;j<col;j++){
                if(grid[i][j]==1){
                    landPos.offer(new Pair(i,j));
                    visited[i][j]=true;
                }
            }
        }
        int level =0;
        Queue<Pair> tempPos = new LinkedList<>();
        while(!landPos.isEmpty()){
            
            int size = landPos.size();
            Pair tempPair = landPos.poll();
            int tempR = tempPair.row;
            int tempC = tempPair.col;
            if(tempR>0 && visited[tempR-1][tempC]==false &&  grid[tempR-1][tempC]==0){
                visited[tempR-1][tempC]=true;
                tempPos.offer(new Pair(tempR-1,tempC));
            }
            if(tempR<row-1 && visited[tempR+1][tempC]==false && grid[tempR+1][tempC]==0){
                visited[tempR+1][tempC]=true;
                tempPos.offer(new Pair(tempR+1,tempC));
            }
            if(tempC>0 && visited[tempR][tempC-1]==false && grid[tempR][tempC-1]==0){
                visited[tempR][tempC-1]=true;
                tempPos.offer(new Pair(tempR,tempC-1));
            }
            if(tempC<col-1 &&  visited[tempR][tempC+1]==false && grid[tempR][tempC+1]==0){
                visited[tempR][tempC+1]=true;
                tempPos.offer(new Pair(tempR,tempC+1));
            }
            size--;
            if(size==0 && !tempPos.isEmpty()){
                landPos = tempPos;
                tempPos = new LinkedList<>();
                level++;
            }
        }

        return level==0?-1:level;
    }
    public static void main(String[] args) {
        AsFarAsLand a = new AsFarAsLand();
        int[][] grid= {{1,0,1},{0,0,0},{1,0,1}};
        int result =a.maxDistance(grid);
        System.out.println(result);
    }
}
