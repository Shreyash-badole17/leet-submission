class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int arr[]=new int[points.length],result=0;
        for(int i=0;i<points.length;i++){
            arr[i]=points[i][0];
        }
        Arrays.sort(arr);
        for(int i=1;i<points.length;i++){
            result=Math.max(result,arr[i]-arr[i-1]);
        }
        return result;
}
}