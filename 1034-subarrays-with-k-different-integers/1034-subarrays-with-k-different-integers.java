class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int count1= countarrays(nums,k);
        int count2= countarrays(nums,k-1);
        return count1-count2;
    }
    int countarrays(int[] nums,int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        if(k<0) return 0;
        int l=0,n=nums.length,res=0;
        for(int r=0;r<n;r++){
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            while(map.size()>k){
                int cnt=map.get(nums[l])-1;
                if(cnt==0){
                    map.remove(nums[l]);
                }
                else{
                    map.put(nums[l],cnt);
                }
                l++;
            }
            res=res+(r-l+1);
        }
        return res;
    }
}