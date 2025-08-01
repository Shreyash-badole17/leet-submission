class Solution {
    public boolean canJump(int[] nums) {
        int maxposition = 0,n= nums.length,i=0;
        while(maxposition < nums.length && maxposition >= i){
            if(maxposition>=n-1) break;
            else if(maxposition<(i+nums[i])){
                maxposition=i+nums[i];
            }
            i++;
        }
        return (maxposition>=n-1);
    }
}