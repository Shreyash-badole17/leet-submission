class Solution {
    public int divide(int dividend, int divisor) {
        // Handle overflow case upfront:
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        
        // Determine sign of the result:
        boolean negative = (dividend < 0) ^ (divisor < 0);
        
        // Work with positives in long to avoid overflow
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);
        int result = 0;
        
        // Subtract the largest shifted divisor each time
        for (int shift = 31; shift >= 0; shift--) {
            // If (dvs << shift) fits into the remaining dividend:
            if ((dvs << shift) <= dvd) {
                dvd -= (dvs << shift);
                result += 1 << shift;
            }
        }
        
        return negative ? -result : result;
    }
}
