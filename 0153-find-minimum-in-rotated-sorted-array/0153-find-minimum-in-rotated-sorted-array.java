class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        int drop =0;
        if(nums[0]>nums[n-1]){
            drop=1;
            for(int i=1;i<n-1;i++){
                if(nums[i]>nums[(i+1)%n]){
                    drop=i+1;
                    return nums[drop];
                }
            }
        }
        return nums[drop];
    }
}