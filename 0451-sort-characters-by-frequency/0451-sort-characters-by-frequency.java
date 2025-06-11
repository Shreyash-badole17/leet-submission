class Solution {

    static {
        // Warm-up block to potentially optimize JVM performance before running main logic
        for (int i = 0; i < 500; i++) {
            frequencySort(new String());
        }
    }

    // Helper method to find the index of the max frequency character
    public static int findMaxI(int[] f) {
        int maxi = 0;
        int max = 0;
        for (int i = 0; i < f.length; i++) {
            if (f[i] > max) {
                maxi = i;
                max = f[i];
            }
        }
        return maxi;
    }

    public static String frequencySort(String s) {
        int[] f = new int[128];
        for (char c : s.toCharArray()) {
            f[c] += 1;
        }
        char[] res = new char[s.length()];
        int i = 0;
        while (i < s.length()) {
            int maxi = findMaxI(f);
            int freq = f[maxi];
            while (freq > 0) {
                res[i++] = (char) (maxi);
                freq--;
            }
            f[maxi] = 0;
        }
        return new String(res);
    }
}