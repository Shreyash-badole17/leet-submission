class MedianFinder {
    PriorityQueue<Integer> lower;
    PriorityQueue<Integer> upper;
    public MedianFinder() {
        lower= new PriorityQueue<>(Collections.reverseOrder());
        upper = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(lower.isEmpty()||lower.peek()>=num){
            lower.offer(num);
        }    
        else{
            upper.offer(num);
        }

        if(lower.size()>upper.size()+1){
            upper.offer(lower.poll());
        }
        else if(upper.size()>lower.size()){
            lower.offer(upper.poll());
        }   
    }
    
    public double findMedian() {
        if(lower.size()==upper.size()){
            return (double)(lower.peek()+upper.peek())/2;
        }
        else{
            return (double)lower.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */