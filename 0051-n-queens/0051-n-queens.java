class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();

        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        Set<Integer> cols = new HashSet<>();
        Set<Integer> diag1 = new HashSet<>();
        Set<Integer> diag2 = new HashSet<>();

        solve(0, n, board, ans, cols, diag1, diag2);

        return ans;
    }

    private void solve(int row, int n, char[][] board,
                       List<List<String>> ans,
                       Set<Integer> cols,
                       Set<Integer> diag1,
                       Set<Integer> diag2) {

        if (row == n) {
            List<String> temp = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                temp.add(new String(board[i]));
            }

            ans.add(temp);
            return;
        }

        for (int col = 0; col < n; col++) {

            if (cols.contains(col) ||
                diag1.contains(row - col) ||
                diag2.contains(row + col)) {
                continue;
            }

            // Place queen
            board[row][col] = 'Q';

            cols.add(col);
            diag1.add(row - col);
            diag2.add(row + col);

            solve(row + 1, n, board, ans, cols, diag1, diag2);

            // Backtrack
            board[row][col] = '.';

            cols.remove(col);
            diag1.remove(row - col);
            diag2.remove(row + col);
        }
    }
}