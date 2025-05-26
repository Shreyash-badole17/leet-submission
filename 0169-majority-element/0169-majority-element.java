class Solution {
    public int majorityElement(int[] nums) {
        // Arrays.sort(nums);
        // int n=nums.length;
        // return nums[n/2];

        int val = me(nums, nums[0], 0);
    return val;}

//using recursions
     int me(int[] arr, int val,int index){
        int count =0;
        for(int i =index;i<arr.length;i++){
            if(arr[i] == val)
                count++;
            else count--;
            if(count<0) return me(arr, arr[index], i);
        }
        return val;
    
    }
}