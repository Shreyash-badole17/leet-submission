class Solution {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int result=0,count=0,index=0,n=0;
        for(int i : nums){
            count=0;
            while(index>0){
                if(index%2==1){
                    count++;
                }
                index=index/2;
            }
            if(count==k){
                result+=i;
            }
            index=++n;
        }return result;
    }
}