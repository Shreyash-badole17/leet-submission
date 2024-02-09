class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list=new ArrayList<Boolean>();
        int maxel=0;
        for(int k=0;k<candies.length;k++){
            if(maxel<candies[k])
            maxel=candies[k];
        }
        for(int i=0;i<candies.length;i++){
            int Max=candies[i]+extraCandies;
            if(Max>=maxel){
                list.add(true); 
            }
            else{
                list.add(false);
            }
        }
    return list;
    }
}