class Solution {
    public int beautySum(String s) {
        int n = s.length();
        int totalBeauty = 0;

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];  // frequency map for 'a' to 'z'

            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'a']++;

                int max = 0, min = Integer.MAX_VALUE;

                for (int f : freq) {
                    if (f > 0) {
                        max = Math.max(max, f);
                        min = Math.min(min, f);
                    }
                }

                totalBeauty += (max - min);
            }
        }

        return totalBeauty;
    }
}
