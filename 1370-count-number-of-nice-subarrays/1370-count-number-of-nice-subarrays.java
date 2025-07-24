class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int count1=oddcount(nums,k);
        int count2=oddcount(nums,k-1);
        return count1-count2;
    }
    int oddcount(int[] nums,int k){
        int l=0,oddnum=0,cnt=0,n=nums.length;
        if(k<0) return 0;
        for(int r=0;r<nums.length;r++){
            if((nums[r]&1)==1){
                oddnum++;
            }
            while(oddnum>k){
                if(nums[l]%2==1){
                    oddnum--;
                }
                l++;    
            }
            cnt=cnt+(r-l+1);
        }
        return cnt;
    }
}