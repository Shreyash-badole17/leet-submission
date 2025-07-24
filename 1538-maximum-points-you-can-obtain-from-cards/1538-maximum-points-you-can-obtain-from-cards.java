class Solution {
    public int maxScore(int[] cP, int k) {
        int lsum=0,rsum=0,maxSum=0;
        for(int i=0;i<k;i++){
            lsum+=cP[i];
        }
        maxSum=lsum;
        int rghtidx=cP.length-1;
        for(int l=k-1;l>=0;l--){
            lsum-=cP[l];
            rsum+=cP[rghtidx--];
            maxSum=Math.max(maxSum,lsum+rsum);
        }
        return maxSum;
    }
}