class Solution {
    public int[] runningSum(int[] nums) {
        int[] list=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<1+i;j++){
                list[i]+=nums[j];
            }
        }
        return list;
    }
}