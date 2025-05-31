class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n < 2) {
            return intervals;
        }

        // 1) Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> list = new ArrayList<>();

        // 2) Initialize the “current” interval using intervals[0]
        int currentLeft  = intervals[0][0];
        int currentRight = intervals[0][1];

        // 3) Loop from i = 0 instead of i = 1:
        for (int i = 0; i < n; i++) {
            int nextLeft  = intervals[i][0];
            int nextRight = intervals[i][1];

            // If the next interval overlaps (or touches) the “current” interval
            if (nextLeft <= currentRight) {
                // Merge by extending currentRight if needed
                currentRight = Math.max(currentRight, nextRight);
            }
            else {
                // No overlap → add the finished “current” to the list,
                // then start a brand-new “current” interval
                list.add(new int[] { currentLeft, currentRight });
                currentLeft  = nextLeft;
                currentRight = nextRight;
            }
        }

        // 4) After the loop, add the final “current” interval
        list.add(new int[] { currentLeft, currentRight });

        // 5) Convert List<int[]> back into int[][]
        int[][] nums = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }
}
