class Solution {
    // Constraint tables
    private boolean[][] rows = new boolean[9][10];
    private boolean[][] cols = new boolean[9][10];
    private boolean[][] boxes = new boolean[9][10];
    private char[][] board;

    public void solveSudoku(char[][] board) {
        this.board = board;
        // Initialize constraints
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char ch = board[r][c];
                if (ch != '.') {
                    int d = ch - '0';
                    int b = (r / 3) * 3 + (c / 3);
                    rows[r][d] = cols[c][d] = boxes[b][d] = true;
                }
            }
        }
        backtrack();
    }
    
    private boolean backtrack() {
        // Find next empty cell
        for (int i = 0; i < 81; i++) {
            int r = i / 9, c = i % 9;
            if (board[r][c] == '.') {
                int b = (r / 3) * 3 + (c / 3);
                // Try digits 1–9
                for (int d = 1; d <= 9; d++) {
                    if (!rows[r][d] && !cols[c][d] && !boxes[b][d]) {
                        // Place d
                        board[r][c] = (char)('0' + d);
                        rows[r][d] = cols[c][d] = boxes[b][d] = true;
                        
                        if (backtrack()) return true;
                        
                        // Undo
                        board[r][c] = '.';
                        rows[r][d] = cols[c][d] = boxes[b][d] = false;
                    }
                }
                // No digit fits here → trigger backtrack
                return false;
            }
        }
        // All cells filled
        return true;
    }
}
