class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int mid = n / 2;
        int result;

        // If there's only one element, return it directly
        if (n == 1) {
            return nums[0];
        }

        // Check if mid matches the element to its left
        if (mid > 0 && nums[mid] == nums[mid - 1]) {
            // Number of elements to the right of the pair at (mid-1, mid)
            int val = n - (mid - 1);
            if ((val % 2) == 0) {
                // If the right‐side segment has an even length, the single element is in the left segment
                result = searchForNum(nums, 0, mid - 2);
            } else {
                // Otherwise, the single element is in the right segment
                result = searchForNum(nums, mid + 1, n - 1);
            }
        }
        // Otherwise, check if mid matches the element to its right
        else if (mid + 1 < n && nums[mid] == nums[mid + 1]) {
            // Number of elements to the right of the pair at (mid, mid+1)
            int val = n - (mid + 1);
            if ((val % 2) == 1) {
                // If the right‐side segment has an odd length, the single element is in the left segment
                result = searchForNum(nums, 0, mid - 1);
            } else {
                // Otherwise, the single element is in the right segment
                result = searchForNum(nums, mid + 2, n - 1);
            }
        }
        // If nums[mid] doesn’t match either neighbor, it must be the single element
        else {
            return nums[mid];
        }

        return result;
    }

    /**
     * Scans linearly from index 'start' to 'end' (inclusive) and returns the first
     * element that does not equal its neighbor. If no mismatch is found in the loop,
     * returns nums[end].
     */
    private int searchForNum(int[] arr, int start, int end) {
        for (int i = start; i < end; i++) {
            if (arr[i] != arr[i + 1]) {
                return arr[i];
            }
            // Skip over the matched pair
            i++;
        }
        return arr[end];
    }
}
