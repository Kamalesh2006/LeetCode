import java.util.*;
public class SpiralMatrix{
    public List<Integer> spiralOrder(int[][] matrix) {
        int sRow =0;
        int eRow = matrix.length;
        int sCol =0;
        int eCol = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        while(sRow< eRow || sCol<eCol){
            if(sRow<eRow){
                for(int i =sCol;i<eCol;i++){
                    result.add(matrix[sRow][i]);
                }
                sRow++;
            }
            if(eCol>sCol){
                for(int i = sRow;i<eRow;i++){
                    result.add(matrix[i][eCol-1]);
                }
                eCol--;
            }
            if(eRow>sRow){
                for(int i =eCol-1;i>=sCol;i--){
                    result.add(matrix[eRow-1][i]);
                }
                eRow--;
            }
            if(sCol<eCol){
                for(int i=eRow-1;i>=sRow;i--){
                    result.add(matrix[i][sCol]);
                }
                sCol++;
            }
            
        }
        return result;
    }
    public static void main(String[] args) {
        SpiralMatrix s = new SpiralMatrix();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(s.spiralOrder(matrix));
        
    }
}