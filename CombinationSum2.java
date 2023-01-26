import java.util.*;

public class CombinationSum2 {
    private void combinations(List<Integer> l, int[] candidates, int index, int target, List<List<Integer>> result)
    {
        if(index==candidates.length){
            if(target==0){
                List<Integer> tempL = new ArrayList<>(l);
                Collections.sort(tempL);
                if(!result.contains(tempL))
                    result.add(tempL);
            }
            return;
        }
        else if(candidates[index]<=target){
            l.add(candidates[index]);
            combinations(l,candidates,index+1,target-candidates[index],result);
            l.remove(l.size()-1);
            
        }
        while(index<candidates.length-1 && candidates[index]==candidates[index+1]){
            index++;
        }
        combinations(l,candidates,index+1,target,result);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinations(new ArrayList<>(), candidates, 0, target, result);
        return result;
    }
}
