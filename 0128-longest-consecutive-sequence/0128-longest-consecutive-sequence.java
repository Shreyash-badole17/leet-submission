class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        // 1) Put everything into a set for O(1) lookups
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        // 2) For each number, only try to build a sequence if it’s the start
        for (int num : set) {
            // if there's no predecessor, this is the sequence head
            if (!set.contains(num - 1)) {
                int current = num;
                int streak = 1;

                // count upwards while next numbers exist
                while (set.contains(current + 1)) {
                    current++;
                    streak++;
                }

                longest = Math.max(longest, streak);
            }
        }

        return longest;
    }
}
