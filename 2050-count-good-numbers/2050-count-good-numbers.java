class Solution {
    private static final int MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {
        // number of “even‐digit” slots = ceil(n/2)
        long evenSlots = (n + 1) / 2;
        // number of “odd‐digit” slots = floor(n/2)
        long oddSlots  = n / 2;

        long pow5 = modPow(5, evenSlots);
        long pow4 = modPow(4, oddSlots);

        // multiply and take mod
        return (int)((pow5 * pow4) % MOD);
    }

    // iterative O(log n) modular exponentiation
    private long modPow(long base, long exp) {
    if (exp == 0) {
        return 1;
    }
    // compute base^(exp/2) recursively
    long half = modPow(base, exp / 2);
    // square it, taking mod
    long result = (half * half) % MOD;
    // if exp is odd, multiply by one extra base
    if (exp % 2 == 1) {
        result = (result * (base % MOD)) % MOD;
    }
    return result;
    }
}
