class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res= new ArrayList<>();
        backtrack(1,k,n,new ArrayList<>(),res);
        return res;
    }
    void backtrack(int start,int count,int remaining,List<Integer> curr,List<List<Integer>> res){
        if(count == 0 && remaining == 0){
            res.add(new ArrayList<>(curr));
            return;
        }
        else if(count == 0){
            return;
        }
        for(int i=start;i<10;i++){
            curr.add(i);
            backtrack(i+1,count-1,remaining-i,curr,res);
            curr.remove(curr.size()-1);
        }
    }
}