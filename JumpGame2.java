public class JumpGame2 {
    public int jump(int[] nums) {
        int farthest = 0;
        int jump =0;
        int current =0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]+i>farthest){
               farthest = nums[i]+i;
           }
           if(i==current && current<farthest && current<nums.length-1){
                current = farthest;
                jump++;
                if(current>=nums.length-1){
                    break;
                }
           }
           
        //    System.out.println(farthest+" "+current+" "+jump);
           
        }
        return farthest>=nums.length-1?jump:0;
    }
}
