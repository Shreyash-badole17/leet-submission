class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            // Compare nums[mid] with its right neighbor.
            if (nums[mid] < nums[mid + 1]) {
                // If the right neighbor is bigger, a peak must lie to the right of mid
                left = mid + 1;
            } else {
                // Otherwise, a peak is at mid or to the left of mid
                right = mid;
            }
        }
        // At the end of the loop, left == right and points to a peak index
        return left;
    }
}
