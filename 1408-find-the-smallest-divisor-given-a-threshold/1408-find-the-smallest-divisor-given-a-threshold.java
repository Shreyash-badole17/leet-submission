class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int high=0,low=1;
        for(int val:nums){
            if(high<val){
                high=val;
            }
        }

        int answer=high;
        while(low<=high){
            int mid=low+(high-low)/2;
            int computed= computedSum(nums,threshold,mid);

            if(threshold<computed){
                low=mid+1;
            }
            else{
                high=mid-1;
                answer=mid;
            }
        }
        return answer;
    }

    int computedSum(int nums[], int k, int mid){
        int sum=0;
        for(int val:nums){
            sum+=(val+mid-1)/mid;
        }
        return sum;
    }
}