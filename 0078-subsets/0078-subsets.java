class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> antim = new ArrayList<>();
        List<Integer> currSet = new ArrayList<>();
        backtrack(0,currSet,antim,nums);
        return antim;
    }
    private void backtrack(int start,List<Integer> currSet,List<List<Integer>> antim,int[] nums){
        antim.add(new ArrayList<>(currSet));
        for(int i=start;i<nums.length;i++){
            currSet.add(nums[i]);
            backtrack(i+1,currSet,antim,nums);
            currSet.remove(currSet.size()-1);
        }
    }
}