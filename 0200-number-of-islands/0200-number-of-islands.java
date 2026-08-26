class Solution {
    public void dfs(int r, int c, int[][] vis, char[][] grid, int[] dr,int[] dc){
        vis[r][c] = 1;
        int n = grid.length, m = grid[0].length;

        for(int i = 0; i<4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr>=0 && nr<n && nc>=0 && nc<m && vis[nr][nc] == 0 && grid[nr][nc] == '1'){
                dfs(nr, nc, vis, grid, dr, dc);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int cnt = 0;
        int[][] vis = new int[n][m];
        int[] dr = {0, -1, 0, 1};
        int[] dc = {1, 0, -1, 0};
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j]=='1' && vis[i][j]==0){
                    dfs(i,j,vis,grid,dr,dc);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}