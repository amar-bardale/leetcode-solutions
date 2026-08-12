class Solution {
    public void dfs(int r, int c, int[][] grid, int[][] vis, int[] dr, int[] dc){
        vis[r][c] = 1;

        int n = grid.length;
        int m = grid[0].length;

        for(int i = 0; i<4; i++){
            int nr = r+dr[i];
            int nc = c+dc[i];

            if(nr>=0 && nr<n && nc>=0 && nc<m && vis[nr][nc] == 0 && grid[nr][nc] == 1){
                dfs(nr, nc, grid, vis, dr, dc);
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];
        int[] dr = {0, -1, 0, 1};
        int[] dc = {-1, 0, 1, 0};

        for(int i = 0; i<m; i++){
            if(vis[0][i] == 0 && grid[0][i] == 1){
                dfs(0, i, grid, vis, dr, dc);
            }
            if(vis[n-1][i] == 0 && grid[n-1][i] == 1){
                dfs(n-1, i, grid, vis, dr, dc);
            }
        }

        for(int j = 0; j<n; j++){
            if(vis[j][0] == 0 && grid[j][0] == 1){
                dfs(j, 0, grid, vis, dr, dc);
            }
            if(vis[j][m-1] == 0 && grid[j][m-1] == 1){
                dfs(j, m-1, grid, vis, dr, dc);
            }
        }

        int ans = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(vis[i][j] == 0 && grid[i][j] == 1){
                    ans++;
                }
            }
        }
        return ans;
    }
}