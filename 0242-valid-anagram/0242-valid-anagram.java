class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] h = new int[256];
        int[] g = new int[256];

        for (char c : t.toCharArray()) {
            h[c]++;
        }
        for (char c : s.toCharArray()) {
            g[c]++;
            if (h[c]<g[c]) {
                return false;
            }
        }
        return true;
    }
}
