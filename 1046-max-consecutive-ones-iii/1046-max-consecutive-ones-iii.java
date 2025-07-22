class Solution {
    public int longestOnes(int[] nums, int k) {
        int zeros=0,left=0,maxLen=0,len=0;
        for(int right=0;right<nums.length;right++){
            len=right-left+1;
            if(nums[right]==0){
                zeros++;
                if(zeros>k){
                    while(zeros>k){
                        if(nums[left]!=0){
                            left++;
                        }
                        else{
                            left++;
                            zeros--;
                        }
                    }
                    len=right-left+1;
                }
            }
            maxLen=Math.max(maxLen,len);
        }
        return maxLen;
    }
}