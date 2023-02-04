import java.util.*;
public class RottingOranges {
    class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row = row;
            this.col = col;
        }
    }
    public int orangesRotting(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;
        int[][] visited = new int[row][col];
        Queue<Pair> orange = new LinkedList<>();
        int time =0; 
        int countFresh=0;

        for(int i =0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==2){
                    orange.offer(new Pair(i,j));
                    visited[i][j]=2;
                }
                else if(grid[i][j]==1){
                    countFresh++;
                    visited[i][j]=1;
                }  
            }
        }

        int count=0;
        while(!orange.isEmpty()){
            Queue<Pair> tempOrange = new LinkedList<>();
            while(!orange.isEmpty()){
                Pair getPair = orange.poll();
                int nRow = getPair.row;
                int nCol = getPair.col;
                if(nRow>0){
                    if(visited[nRow-1][nCol]==1){
                        tempOrange.offer(new Pair(nRow-1,nCol));
                        visited[nRow-1][nCol]=2;
                        count++;
                    }
                        
                }
                if(nRow<row-1){
                    if(visited[nRow+1][nCol]==1){
                        tempOrange.offer(new Pair(nRow+1,nCol));
                        visited[nRow+1][nCol]=2;
                        count++;
                    }
                }
                if(nCol>0){
                    if(visited[nRow][nCol-1]==1){
                        tempOrange.offer(new Pair(nRow,nCol-1));
                        visited[nRow][nCol-1]=2;
                        count++;
                    }
                }
                if(nCol<col-1){
                    if(visited[nRow][nCol+1]==1){
                        tempOrange.offer(new Pair(nRow,nCol+1));
                        visited[nRow][nCol+1]=2;
                        count++;
                    }
                }
            }
            orange = tempOrange;
            if(orange.isEmpty())
                break;
            time++;
        }
        //checking if there is a orange which isn't rotten
        if(count!=countFresh)
            return -1;
        
        return time;

    }

    public static void main(String[] args) {
        RottingOranges r = new RottingOranges();
        int[][] orange = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(r.orangesRotting(orange));
    }
}
