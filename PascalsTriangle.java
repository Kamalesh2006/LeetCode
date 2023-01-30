import java.util.List;
import java.util.ArrayList;

class PascalsTriangle {
    /**
     * Given an integer numRows, return the first numRows of Pascal's triangle.

        In Pascal's triangle, each number is the sum of the two numbers.
     * @param numRows 
     * @return List<List<Integer>> of all the arrayList formed
     */
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> previous = new ArrayList<>();

        for(int i =1;i<=numRows;i++){

            List<Integer> al = new ArrayList<>();

            for(int j =1;j<=i;j++){
                if(j==1 ||j==i){
                    al.add(1);
                }
                else{
                    int sum = previous.get(j-2)+previous.get(j-1);
                    al.add(sum);
                }
            }

            previous = new ArrayList<>(al);
            result.add(al);
        }
        return result;
    }
}
