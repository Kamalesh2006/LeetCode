import java.util.Arrays;

public class CombinationSum4 {

    public int combination(int[] nums, int target,int[] dp){
        int count =0;
        if(target==0)
            return 1;
        
        if(target<0){
            return 0;
        }
        if(dp[target-1]!=-1){
            return dp[target-1];
        }
            
        
        for(int i =0;i<nums.length;i++){
            
            count = count + combination(nums,target-nums[i],dp);
        }
        return dp[target-1]=count;
    }
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target];
        Arrays.fill(dp,-1);
        return combination(nums,target,dp);
    }
    
    public static void main(String[] args) {
        CombinationSum4 c = new CombinationSum4();
        System.out.println(c.combinationSum4(new int[]{1,2,3}, 4));
    }
}
