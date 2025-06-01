class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int[] result = new int[]{ -1, -1 };

        // 1) Find leftmost index where nums[idx] == target
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                // nums[mid] >= target → keep searching left
                high = mid - 1;
            }
        }
        // At loop exit, low is the first index ≥ target.
        if (low >= n || nums[low] != target) {
            // target not present
            return result;
        }
        result[0] = low;

        // 2) Find rightmost index where nums[idx] == target
        low = 0;
        high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] <= target) {
                // If nums[mid] == target, we might still want to go right
                low = mid + 1;
            } else {
                // nums[mid] > target → search left
                high = mid - 1;
            }
        }
        // At loop exit, high is the last index ≤ target (and since we know target exists, nums[high] == target).
        result[1] = high;

        return result;
    }
}
