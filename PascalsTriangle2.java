import java.util.List;
import java.util.ArrayList;

public class PascalsTriangle2 {
    /**
     * Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
     * @param rowIndex of int starts from zero
     * @return
     */
    public List<Integer> getRow(int rowIndex) {

        List<Integer> al = new ArrayList<>();
        al.add(1);

        for(int i=1;i<=rowIndex;i++){

            if(i==1){
                al.add(1);
                continue;
            }
            //we are adding zero at the last so that we can add last element and last-1 element 
            //from the end of the array list
            
            al.add(0);

            for(int j=al.size()-1;j>0;j--){
                int insert = al.get(j)+al.get(j-1);
                al.set(j,insert);
            }

        }
        return al;
    }
    
}