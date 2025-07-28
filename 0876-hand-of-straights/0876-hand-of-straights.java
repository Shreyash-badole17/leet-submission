class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0)return false;
        HashMap<Integer,Integer> freq = new HashMap<>();
        for(int h:hand){
            freq.put(h,freq.getOrDefault(h,0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(freq.keySet());

        while(!pq.isEmpty()){
            int start= pq.peek();
            for(int i=start;i<start+groupSize;i++){
                Integer count = freq.get(i);
                if(count==null){
                    return false;
                }
                if(count==1){
                    freq.remove(i);
                    pq.remove(i);
                }
                else{
                    freq.put(i,count-1);
                }
            }
        }
        return true;
    }
}