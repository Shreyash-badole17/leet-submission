class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int low=1,high=0;
        int n=bloomDay.length;

        if(n<(long)m*k){
            return -1;
        }

        for(int bloom:bloomDay){
            if(high<bloom){
                high=bloom;
            }
        }

        
        int answer=high;
        while(low<=high){
            int mid=low+(high-low)/2;
            int totalBqe=computeBloomed(bloomDay,k,mid);
            if(totalBqe<m){
                low=mid+1;
            }
            else{
                high=mid-1;
                answer=mid;
            }
        }
        return answer;
    }
    int computeBloomed(int bloomDay[], int k, int mid){
        int count=0,totalBqe=0;
        boolean conti=true;
        for(int val:bloomDay){
            if(val<=mid){
                conti=true;
                count++;
                if(count!=k)
                continue;
            }
            else{
                count=0;
                conti=false;
            }
            if(count==k&&conti==true){
                totalBqe+=1;
                count=0;
            }
        }
        return totalBqe;
    }
}