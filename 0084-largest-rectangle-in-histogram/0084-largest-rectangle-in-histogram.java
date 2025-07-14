class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxarea=0;
        Stack<Integer> st = new Stack<>();
        int n= heights.length;
        for(int i=0;i<=n;i++){
            int currHeight= i==n?0:heights[i];
            while(!st.isEmpty() && currHeight<heights[st.peek()]){
                int top=st.pop();
                int height=heights[top];

                int width= st.isEmpty() ?
                i   :
                i-st.peek()-1;

                maxarea= Math.max(maxarea,height*width);
            }
            st.push(i);
        }
        return maxarea;
    }
}