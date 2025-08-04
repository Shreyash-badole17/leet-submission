class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> arr = new LinkedList<>();
        int i=0;
        while(i<n && intervals[i][1]<newInterval[0]){
            arr.add(intervals[i]);
            i++;
        }
        while(i<n && intervals[i][0]<=newInterval[1]){
            newInterval[0]= Math.min(intervals[i][0],newInterval[0]);
            newInterval[1]= Math.max(intervals[i][1],newInterval[1]);
            i++;
        }
        arr.add(newInterval);
        while(i<n){
            arr.add(intervals[i]);
            i++;
        }
        return arr.toArray(new int[arr.size()][]);
    }
}