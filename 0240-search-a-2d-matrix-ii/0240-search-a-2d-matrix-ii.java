class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int row = 0, col = n - 1;              // start at top-right corner
        
        while (row < m && col >= 0) {
            int val = matrix[row][col];
            if      (val == target) return true;
            else if (val >  target) col--;     // go left to smaller values
            else                     row++;    // go down to larger values
        }
        
        return false;  // scanned all possible “staircase” positions
    }
}
