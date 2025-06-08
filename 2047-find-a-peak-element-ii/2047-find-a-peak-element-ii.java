class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;           // number of rows
        int m = mat[0].length;        // number of columns

        int low = 0, high = m - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // find the row index of the maximum element in column mid
            int row = findMaxRow(mat, n, mid);
            int curr = mat[row][mid];

            // check left neighbor (if any)
            int left = (mid > 0)      ? mat[row][mid - 1] : -1;
            // check right neighbor (if any)
            int right = (mid < m - 1) ? mat[row][mid + 1] : -1;

            if (left > curr) {
                // there’s a bigger neighbor on the left, so search left
                high = mid - 1;
            }
            else if (right > curr) {
                // there’s a bigger neighbor on the right, so search right
                low = mid + 1;
            }
            else {
                // mat[row][mid] is greater than both neighbors ⇒ peak!
                // Inline array creation + return in one line:
                return new int[]{ row, mid };
            }
        }

        // (Problem guarantees at least one peak, so we should never get here;
        // but Java methods must return something on all code paths.)
        return new int[]{ -1, -1 };
    }

    private int findMaxRow(int[][] mat, int n, int col) {
        int maxRow = 0;
        for (int i = 1; i < n; i++) {
            if (mat[i][col] > mat[maxRow][col]) {
                maxRow = i;
            }
        }
        return maxRow;
    }
}
