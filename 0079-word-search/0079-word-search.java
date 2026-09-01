class Solution {
    private boolean dfs(int row, int col, int num, char[][] board, boolean[][] vis, String word){
        vis[row][col] = true;
        int n = board.length;
        int m = board[0].length;
        if(num==word.length()-1) return true;

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        for(int i = 0; i<4; i++){
            int nrow = row+delRow[i];
            int ncol = col+delCol[i];
            if(nrow >=0 && nrow<n && ncol>=0 && ncol<m && !vis[nrow][ncol] && num<word.length()-1 && board[nrow][ncol] == word.charAt(num+1)){
                if(dfs(nrow, ncol, num+1, board, vis, word)) return true;
            }
        }
        vis[row][col] = false;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if((board[i][j] == word.charAt(0)) && !vis[i][j]){
                    if(dfs(i, j, 0, board, vis, word)) return true;
                }
            }
        }
        return false;
    }
}