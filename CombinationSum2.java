import java.util.*;

public class CombinationSum2 {

    /**
     * 
     * @param possible List<Integer> type which stores possible combinations of candidates
     * @param candidates int array
     * @param index of int, index of candidates array
     * @param target
     * @param result of List<List<Integer>> which stores list
     */
    private void combinations(List<Integer> possible, int[] candidates, int index, int target, List<List<Integer>> result)
    {
        if(index==candidates.length){
            if(target==0){
                List<Integer> tempL = new ArrayList<>(possible);
                Collections.sort(tempL);
                if(!result.contains(tempL))
                    result.add(tempL);
            }
            return;
        }
        else if(candidates[index]<=target){
            possible.add(candidates[index]);
            combinations(possible,candidates,index+1,target-candidates[index],result);
            possible.remove(possible.size()-1);
            
        }
        while(index<candidates.length-1 && candidates[index]==candidates[index+1]){
            index++;
        }
        combinations(possible,candidates,index+1,target,result);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinations(new ArrayList<>(), candidates, 0, target, result);
        return result;
    }
}
