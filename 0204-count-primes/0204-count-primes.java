class Solution {
    public int countPrimes(int n) {
        if (n < 2) return 0;

        // isComposite[i] == true means "i is NOT prime"
        boolean[] isComposite = new boolean[n];
        int count = 0;

        // We only need to check i from 2 up to n−1
        for (int i = 2; i < n; i++) {
            if (!isComposite[i]) {
                count++;  // found a prime

                // Start marking multiples at i*i (all smaller multiples
                // have already been marked by smaller primes)
                if ((long)i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        isComposite[j] = true;
                    }
                }
            }
        }
        return count;
    }
}
