import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        if (n < 4) return result;

        // 1) Sort the array so we can use two‐pointer and skip duplicates easily
        Arrays.sort(nums);

        // 2) First loop: fix the first element at index i
        for (int i = 0; i < n - 3; i++) {
            // Skip duplicate values for the first index
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Early exit: if the smallest possible sum with nums[i] is already > target
            long minSum1 = (long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            if (minSum1 > target) {
                break;  // no need to continue; further i will only increase the sum
            }
            // Early exit: if the largest possible sum with nums[i] is still < target
            long maxSum1 = (long) nums[i] + nums[n - 1] + nums[n - 2] + nums[n - 3];
            if (maxSum1 < target) {
                continue;  // try next i
            }

            // 3) Second loop: fix the second element at index j (j > i)
            for (int j = i + 1; j < n - 2; j++) {
                // Skip duplicate values for the second index
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                // Early exit / skip checks for (i, j)
                long minSum2 = (long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2];
                if (minSum2 > target) {
                    break;  // no need to try larger j, since array is sorted
                }
                long maxSum2 = (long) nums[i] + nums[j] + nums[n - 1] + nums[n - 2];
                if (maxSum2 < target) {
                    continue;  // even if we use the two largest elements, sum < target → try next j
                }

                // 4) Two‐pointer approach for the remaining two elements
                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    long currSum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (currSum == target) {
                        // Found one quadruplet
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // Skip duplicates on the 'left' pointer
                        int leftVal = nums[left];
                        while (left < right && nums[left] == leftVal) {
                            left++;
                        }

                        // Skip duplicates on the 'right' pointer
                        int rightVal = nums[right];
                        while (left < right && nums[right] == rightVal) {
                            right--;
                        }
                    }
                    else if (currSum < target) {
                        left++;
                    }
                    else { // currSum > target
                        right--;
                    }
                }
            }
        }

        return result;
    }
}
