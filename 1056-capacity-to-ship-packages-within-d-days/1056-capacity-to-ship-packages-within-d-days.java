class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        // 1) Lower bound = the maximum single-package weight
        int low = 0;
        // 2) Upper bound = the sum of all weights
        int high = 0;
        for (int w : weights) {
            low = Math.max(low, w);
            high += w;
        }

        int answer = high;  // worst‐case: you ship everything in one day

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // How many days does it actually take if capacity = mid?
            int neededDays = computeDays(weights, mid);

            if (neededDays > days) {
                // Too many days → capacity mid is too small
                low = mid + 1;
            } else {
                // You can ship within 'days' days (or fewer) at capacity = mid
                answer = mid;
                high = mid - 1;
            }
        }

        return answer;
    }

    // Returns how many days are required if ship capacity = cap
    private int computeDays(int[] weights, int cap) {
        int daysNeeded = 1;      // start on day #1
        int currentLoad = 0;     // load on the current day

        for (int w : weights) {
            // If adding w would exceed cap, start a new day
            if (currentLoad + w > cap) {
                daysNeeded++;
                currentLoad = w;
            } else {
                currentLoad += w;
            }
        }
        return daysNeeded;
    }
}
