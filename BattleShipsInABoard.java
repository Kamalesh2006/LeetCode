public class BattleShipsInABoard {
    public void countBattle(char[][] board,int r,int c,int row, int col){
        board[r][c]='.';
    
        if(c<col-1 && board[r][c+1]=='X')
            countBattle(board,r,c+1,row,col);
    
        else if(r<row-1 && board[r+1][c]=='X')
            countBattle(board,r+1,c,row,col);
        
    }
    public int countBattleships(char[][] board) {
        int count =0;
        int row = board.length;
        int col = board[0].length;
        for(int i =0;i<row;i++){
            for(int j =0;j<col;j++){
                if(board[i][j]=='X'){
                    countBattle(board,i,j,row,col);
                    count++;
                }
                    
            }
        }
        return count;
    }
    public static void main(String[] args) {
        char[][] board = {{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}};
        BattleShipsInABoard b = new BattleShipsInABoard();
        System.out.println(b.countBattleships(board));
    }
}
