class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }
        Deque<Integer> queue= new ArrayDeque<>();
        int n= nums.length;
        int[] res= new int[1+(n-k)];
        int j=0;
        for(int i=0;i<n;i++){
            while(!queue.isEmpty() && queue.peekFirst() < i - k + 1){ //if value of i=3 toh merko 
               queue.pollFirst();                                           //0 ko nikalna padega for that
            }                                                                //i need to do i-k +1

            while(!queue.isEmpty() && nums[queue.peekLast()] < nums[i]){
                queue.pollLast();
            }

            queue.offerLast(i);

            if(i >= k -1){
                res[j++]=nums[queue.peekFirst()];
            }
        }
        return res;
    }
}