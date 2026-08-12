class Solution {
    private void dfs(int r, int c, char[][] board, int[][] vis, int[] dr, int[] dc){
        vis[r][c] = 1;
        int n = board.length;
        int m = board[0].length;

        for(int i = 0; i<4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr>=0 && nr<n && nc>=0 && nc<m && vis[nr][nc] == 0 && board[nr][nc] == 'O'){
                dfs(nr, nc, board, vis, dr, dc);
            }
        }
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;


        int[][] vis = new int[n][m];
        int[] dr = {0, -1, 0, 1};
        int[] dc = {1, 0, -1, 0};

        for(int i = 0; i<m; i++){
            if(vis[0][i] == 0 && board[0][i] == 'O'){
                dfs(0, i, board, vis, dr, dc);
            }

            if(vis[n-1][i] == 0 && board[n-1][i]=='O'){
                dfs(n-1, i, board, vis, dr, dc);
            }
        }

        for(int j = 0; j<n; j++){
            if(vis[j][0] == 0 && board[j][0] == 'O'){
                dfs(j, 0, board, vis, dr, dc);
            }

            if(vis[j][m-1] == 0 && board[j][m-1] == 'O'){
                dfs(j, m-1, board, vis, dr, dc);
            }
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(vis[i][j] == 0 && board[i][j]=='O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
}