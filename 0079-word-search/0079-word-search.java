class Solution {
    private int m, n;
    private char[][] board;
    private String word;
    
    public boolean exist(char[][] board, String word) {
        this.m = board.length;
        if (m == 0) return false;
        this.n = board[0].length;
        this.board = board;
        this.word = word;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(int r, int c, int idx) {
        if (idx == word.length()) return true;                      // matched all
        
        // boundary and match check
        if (r < 0 || r >= m || c < 0 || c >= n 
            || board[r][c] != word.charAt(idx)) {
            return false;
        }
        
        char temp = board[r][c];
        board[r][c] = '#';                                          // mark visited
        
        // explore neighbors
        boolean found = dfs(r + 1, c, idx + 1)
                     || dfs(r - 1, c, idx + 1)
                     || dfs(r, c + 1, idx + 1)
                     || dfs(r, c - 1, idx + 1);
        
        board[r][c] = temp;                                         // backtrack
        return found;
    }
}
