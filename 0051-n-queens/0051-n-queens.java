class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        char[][] board = new char[n][n];

        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1];  
        boolean[] diag2 = new boolean[2 * n - 1];  

        backtrack(0, board, cols, diag1, diag2, solutions);
        return solutions;
    }

    private void backtrack(int row, char[][] board, boolean[] cols, boolean[] diag1, boolean[] diag2, List<List<String>> solutions) {
        int n = board.length;
        if (row == n) {
            List<String> result = new ArrayList<>();
            for (char[] r : board) {
                result.add(new String(r));
            }
            solutions.add(result);
            return;
        }

        for (int col = 0; col < n; col++) {
            int d1 = row - col + n - 1;
            int d2 = row + col;

            if (cols[col] || diag1[d1] || diag2[d2]) continue;

            board[row][col] = 'Q';
            cols[col] = diag1[d1] = diag2[d2] = true;

            backtrack(row + 1, board, cols, diag1, diag2, solutions);

            board[row][col] = '.';
            cols[col] = diag1[d1] = diag2[d2] = false;
        }
    }
}