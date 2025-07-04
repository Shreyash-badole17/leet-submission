class Solution {
    public int minBitFlips(int start, int goal) {
        int count=0;
        while(goal > 0 && start > 0){
            if(goal%2 != start%2){
                count++;
            }
            goal=goal/2;
            start=start/2;
        }
        if(start>0){
            while(start>0){
                if(start%2==1){
                    count++;
                }
                start/=2;
            }
        }
        if(goal>0){
            while(goal>0){
                if(goal%2==1){
                    count++;
                }
                goal/=2;
            }
        }
        return count;
    }
}