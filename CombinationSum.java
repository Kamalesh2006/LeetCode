import java.util.*;

class CombinationSum {
    /***
     * 
     * @param possible List<Integer> type which stores possible combinations of candidates
     * @param index of int, index of candidates array
     * @param candidates int array
     * @param target int
     * @param result of List<List<Integer>> which stores list
     */
    void combinations(List<Integer> possible,int index, int[] candidates, int target, List<List<Integer>> result){
        if(index==candidates.length){
            if(target==0){
                result.add(new ArrayList<>(possible));
            }
            return;
        }
        else if(candidates[index]<=target){
            possible.add(candidates[index]);
            combinations(possible,index,candidates,target-candidates[index],result);
            possible.remove(possible.size()-1);
        }
        combinations(possible,index+1,candidates,target,result);
        
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinations(new ArrayList<>(), 0, candidates, target, result);
        return result;
    }
}