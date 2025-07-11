class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        if(asteroids.length<2) return asteroids;
        Deque<Integer> stack= new ArrayDeque<>(); 
        for(int ast : asteroids){
            boolean alive=true;
            while(alive && ast<0 && !stack.isEmpty() && stack.peek()>0){
                if(stack.peek()<-ast){
                    stack.pop();
                    continue;
                }
                else if(stack.peek()==-ast){
                    stack.pop();
                }
                alive=false;
            }
            if(alive)
            stack.push(ast);
        }
        int Stsize= stack.size();
        int[] res= new int[Stsize]; 
        for(int i=Stsize-1;i>=0;i--){
            res[i]=stack.pop();
        }
        return res;
    }
}