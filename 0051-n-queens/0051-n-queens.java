class Solution {
    private int n;
    private char[][] board;
    private boolean[] cols, diag, anti;
    private List<List<String>> ans;
    
    public List<List<String>> solveNQueens(int n) {
        this.n     = n;
        this.ans   = new ArrayList<>();
        this.board = new char[n][n];
        this.cols  = new boolean[n];
        this.diag  = new boolean[2*n - 1];
        this.anti  = new boolean[2*n - 1];
        
        // Initialize board with '.'
        for (int i = 0; i < n; i++)
            Arrays.fill(board[i], '.');
        
        backtrack(0);
        return ans;
    }
    
    private void backtrack(int r) {
        if (r == n) {
            ans.add(constructBoard());
            return;
        }
        
        for (int c = 0; c < n; c++) {
            int d = r - c + n - 1;
            int a = r + c;
            if (cols[c] || diag[d] || anti[a]) continue;
            
            // Place queen
            cols[c] = diag[d] = anti[a] = true;
            board[r][c] = 'Q';
            
            backtrack(r + 1);
            
            // Remove queen
            cols[c] = diag[d] = anti[a] = false;
            board[r][c] = '.';
        }
    }
    
    private List<String> constructBoard() {
        List<String> snapshot = new ArrayList<>(n);
        for (char[] row : board)
            snapshot.add(new String(row));
        return snapshot;
    }
}
