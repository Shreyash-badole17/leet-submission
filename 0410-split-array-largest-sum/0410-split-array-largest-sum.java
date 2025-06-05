class Solution {
    public int splitArray(int[] nums, int k) {
        // 1) Compute the lower and upper bounds for binary search:
        //    lo  = max element in nums  (because no subarray can be smaller than the largest single element)
        //    hi  = sum of all elements in nums (if k = 1, you take the whole array as one slice)
        int lo = 0;
        int hi = 0;
        for (int n : nums) {
            lo = Math.max(lo, n);
            hi += n;
        }

        int answer = hi;  // We will minimize this over the binary search.
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            // requiredPieces(mid) tells us how many subarrays we need if no subarray is allowed to exceed sum = mid
            int needed = requiredPieces(nums, mid);

            if (needed > k) {
                // We needed more than k pieces to keep each piece ≤ mid,
                // so mid is too small. We must increase the allowed max chunk sum.
                lo = mid + 1;
            } else {
                // We can split the array into 'needed' ≤ k pieces, each with sum ≤ mid.
                // That means mid is a valid candidate; try to see if we can lower it further.
                answer = mid;
                hi = mid - 1;
            }
        }

        return answer;
    }

    /**
     * Greedily count how many contiguous subarrays (pieces) we need if each piece's sum cannot exceed 'cap'.
     * 
     * Walk through nums[], keep a running 'currentSum'. 
     * Whenever adding nums[i] would push currentSum > cap, we start a new piece (count++),
     * reset currentSum = nums[i], and continue.
     *
     * In the end, count + 1 is the total number of pieces.
     */
    private int requiredPieces(int[] nums, int cap) {
        int pieces = 1;      // At least one piece is needed.
        int currentSum = 0;

        for (int x : nums) {
            if (currentSum + x <= cap) {
                // Add to the current slice
                currentSum += x;
            } else {
                // Start a new slice
                pieces++;
                currentSum = x;
            }
        }
        return pieces;
    }
}
