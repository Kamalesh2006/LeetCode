import java.util.*;

class Solution {
    
    private static void subset(List<List<Integer>> result, List<Integer> l, List<Integer> dt){
        List<Integer> tempL = new ArrayList<>(l);
        result.add(tempL);
        if(dt.size()==0){
            return;
        }
        List<Integer> tempDt = new ArrayList<>(dt);
        while(tempDt.size()!=0){
            tempL.add(tempDt.remove(0));
            subset(result,tempL,tempDt);
            tempL.remove(tempL.size()-1);
        }    

    }
    /**
     * 
     * @param nums nums array of (int) type 
     * @return List<List<Integer>>
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> dt=new ArrayList<>();
        //decision tree
        for(int i:nums){
            dt.add(i);
        }
        List<List<Integer>> result = new ArrayList<>();
        subset(result, new ArrayList<Integer>(),dt);
        return result;
    }
}