class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0) return 0;
        int[] heights = new int[matrix[0].length];
        int maxarea=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                heights[j]= (matrix[i][j]=='1')?
                            heights[j]+1:
                            0;
            }
            maxarea=Math.max(maxarea,largestrectanglearea(heights));
        }
        return maxarea;
    }
    int largestrectanglearea(int[] heights){
        int n= heights.length;
        Deque<Integer> st = new ArrayDeque<>();
        int max=0;
        for(int i=0;i<=n;i++){
            int currH=(i==n)?0:heights[i]; 
            while(!st.isEmpty() && currH<heights[st.peek()]){
                int height= heights[st.pop()];

                int width = st.isEmpty()?
                i :
                i - st.peek() - 1;

                max= Math.max(max,height*width);
            }
            st.push(i);
        }
        return max;
    }
}