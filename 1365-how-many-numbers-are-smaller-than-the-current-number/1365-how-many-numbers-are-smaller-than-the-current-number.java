class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] arr= new int[nums.length];
        int[] target=new int[nums.length];
        int count=0;
        
        for(int i=0;i<nums.length;i++){
            arr[i]=nums[i];
            for(int j=0;j<nums.length;j++){
                if(arr[i]>nums[j]){
                    count++;
                }
            }
            target[i]=count;
            count=0;
        }return target;
    }
}