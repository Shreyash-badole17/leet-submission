class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxc= Integer.MIN_VALUE;
        int count=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==1){
                count++;
                maxc=Math.max(maxc,count);
            }    
            if(nums[i]==0){
                count=0;
            }
        }
        if(count>maxc){
            return count;
        }
        return maxc;
    }
}