class Solution {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] left= new int[len],right = new int[len];
        left[0]=1;
        for(int i=1;i<len;i++){
            if(ratings[i]>ratings[i-1]){
                left[i]=left[i-1]+1;
            }
            else{
                left[i]=1;
            }
        }
        right[len-1]=1;
        // int sum=Math.max(left[len-1],1);
        for(int i=len-2;i>=0;i--){
            if(ratings[i+1]<ratings[i]){
                right[i]=right[i+1]+1;
            }
            else{
                right[i]=1;
            }
            // sum=sum+(Math.max(left[i],right[i]));
        }
        int sum = 0;
        for(int i=0;i<len;i++){
            sum=sum+(Math.max(left[i],right[i]));
        }
        return sum;
    }
}