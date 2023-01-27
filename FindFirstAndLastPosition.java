class FindFirstAndLastPosition {
    public void binarySearch(int[] nums, int left, int right, int target, int[] result){

        int mid = (left+right)/2;
        if(left>right){
            return;
        }
        if(nums[mid]==target){
            if(mid<result[0] || result[0]==-1)
                result[0]=mid;
            if (mid >result[1] || result[1]==-1){
                result[1]=mid;
            }
            binarySearch(nums,left,mid-1,target,result);
            binarySearch(nums,mid+1,right,target,result);
        }
        if(nums[mid]>target){
            binarySearch(nums,left,mid-1,target,result);
        }
        if(nums[mid]<target){
            binarySearch(nums,mid+1,right,target,result);
        }
    }
    public int[] searchRange(int[] nums, int target) {

        int[] result = {-1,-1};
        binarySearch(nums,0,nums.length-1,target,result);
   
        return result;
    }
}
