class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        // 1. Find the rightmost “drop” where nums[i] < nums[i+1]
        int drop = n - 2;
        while (drop >= 0 && nums[drop] >= nums[drop + 1]) {
            drop--;
        }
        if (drop >= 0) {
            // 2. Find the smallest element > nums[drop] to the right
            int bigger = n - 1;
            while (nums[bigger] <= nums[drop]) {
                bigger--;
            }
            swap(nums, drop, bigger);
        }
        // 3. Reverse everything after drop
        reverse(nums, drop + 1, n - 1);
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i]; a[i] = a[j]; a[j] = t;
    }

    private void reverse(int[] a, int left, int right) {
        while (left < right) {
            swap(a, left++, right--);
        }
    }
}
