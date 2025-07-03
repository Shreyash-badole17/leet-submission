class Solution {
    public boolean isPowerOfTwo(int n) {
        // must be positive, and n&(n-1) clears the lowest set bit
        return n > 0 && (n & (n - 1)) == 0;
    }
}
