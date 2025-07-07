import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 1) Build map: value → next greater in nums2
        Map<Integer,Integer> nextGreater = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int num : nums2) {
            // Pop all smaller elements: current num is their "next greater"
            while (!stack.isEmpty() && stack.peek() < num) {
                nextGreater.put(stack.pop(), num);
            }
            stack.push(num);
        }
        // Remaining elements have no greater to their right
        while (!stack.isEmpty()) {
            nextGreater.put(stack.pop(), -1);
        }
        
        // 2) Build result for nums1 by lookup
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = nextGreater.get(nums1[i]);
        }
        return res;
    }
}
