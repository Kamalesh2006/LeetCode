class WordSearch{
    private static int wordsearch(char[][] board, int r, int c, int row, int col, char[] wordArr, int index){
        char temp= board[r][c];
        board[r][c]='.';
        int tempIndex = index; 

        if(index==wordArr.length-1){
            return index;
        }
        if(r>0 && wordArr[index+1]==board[r-1][c]){
            index = wordsearch(board, r-1,c,row, col, wordArr, index+1);
             if(index == wordArr.length-1)
                return index;
             else 
                index = tempIndex;
        }
        
        if(r<row-1 && wordArr[index+1]==board[r+1][c]){
            index = wordsearch(board, r+1,c,row,col,wordArr,index+1);
            if(index == wordArr.length-1)
                return index;
            else 
                index = tempIndex;
        }
        
        if(c>0 && wordArr[index+1]==board[r][c-1]){
            index = wordsearch(board, r,c-1,row,col, wordArr, index+1);
             if(index == wordArr.length-1)
                return index;
            else 
                index = tempIndex;
        }
        
        
        if(c<col-1 && wordArr[index+1]==board[r][c+1]){
            index = wordsearch(board,r,c+1,row,col,wordArr, index+1);
             if(index == wordArr.length-1)
                return index;
            else 
                index = tempIndex;
        }
        board[r][c]=temp;
        return index;

    }
    public boolean exist(char[][] board, String word) {
        if(word.length()==0)
            return true;
        char[] wordArr = word.toCharArray();
        
        int row = board.length;
        int col = board[0].length;

        int index = 0;
        for(int i =0;i<row;i++){
            for(int j =0;j<col;j++){
                if(wordArr[0]==board[i][j]){
                    System.out.println(i+" "+j+" "+"function called");
                    index = wordsearch(board, i,j,row,col,wordArr,index);
                    if(index == wordArr.length-1){
                        return true;
                    }
                    else{
                        index =0;
                    }
                }
            }
            
        }
        return false;
    }
}
