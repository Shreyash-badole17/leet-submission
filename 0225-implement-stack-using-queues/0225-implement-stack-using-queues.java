class MyStack {
    Queue<Integer> qA;
    Queue<Integer> qB;

    public MyStack() {
        qA = new LinkedList<>();
        qB = new LinkedList<>();
    }
    
    public void push(int x) {
        qB.offer(x);
        while(!qA.isEmpty()){
            qB.offer(qA.poll());
        }
        Queue<Integer> temp = qA;
        qA=qB;
        qB=temp;
    }
    
    public int pop() {
        return qA.poll();
    }
    
    public int top() {
        return qA.peek();
    }
    
    public boolean empty() {
        return qA.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */