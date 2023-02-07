import java.util.Arrays;
import java.util.Scanner;

public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = n*n;
        int start =1;
        int rowStart =0;
        int rowEnd = n;
        int colStart =0;
        int colEnd=n;
        while(start<=num){
            if(rowStart<rowEnd){
                for(int i =colStart;i<colEnd;i++){
                    matrix[rowStart][i]=start++;
                }
                rowStart++;
            }
            if(colEnd>colStart){
                for(int i = rowStart;i<rowEnd;i++){
                    matrix[i][colEnd-1]=start++;
                }
                colEnd--;
            }
            if(rowEnd>rowStart){
                for(int i = colEnd-1;i>=colStart;i--){
                    matrix[rowEnd-1][i]=start++;
                }
                rowEnd--;
            }
            if(colStart<colEnd){
                for(int i = rowEnd-1;i>=rowStart;i--){
                    matrix[i][colStart]=start++;
                }
                colStart++;
            }

        }
        return matrix;
    }
    public static void main(String[] args) {
        SpiralMatrixII s2 = new SpiralMatrixII();
        Scanner sh = new Scanner(System.in);
        System.out.println("Enter the size of the matrix: ");
        int size = sh.nextInt();
        int[][] matrix = s2.generateMatrix(size);
        System.out.println(Arrays.deepToString(matrix));
        sh.close();
    }
}
