class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n < 3) return 0;         // need at least 3 bars to trap water

        int totalWater = 0;
        Deque<Integer> stack = new ArrayDeque<>();  
        // We’ll keep indices of bars in a **decreasing** height order

        for (int i = 0; i < n; i++) {
            // While we have a “valley” that is bounded on the right by height[i]
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int mid = stack.pop();        // the bottom of the valley
                if (stack.isEmpty()) break;   // no left boundary

                int left = stack.peek();      // left boundary index
                int width = i - left - 1;     // horizontal distance between boundaries
                int boundedHeight = Math.min(height[left], height[i]) - height[mid];
                totalWater += width * boundedHeight;
            }
            // Push current bar’s index (could be a new boundary or start of next valley)
            stack.push(i);
        }

        return totalWater;
    }
}
