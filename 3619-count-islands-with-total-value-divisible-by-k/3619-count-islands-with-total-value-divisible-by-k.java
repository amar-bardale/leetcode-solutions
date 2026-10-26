class Solution {
    private long dfs(int row, int col, int[][] grid, int[][] vis){
        int m = grid.length;
        int n = grid[0].length;
        long ans = grid[row][col];

        vis[row][col] = 1;

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, -1, 0, 1};

        for(int i = 0; i<4; i++){
            int nRow = row+delRow[i];
            int nCol = col+delCol[i];

            if(nRow>=0 && nRow<m && nCol>=0 && nCol<n && vis[nRow][nCol]==0){
                ans+=dfs(nRow, nCol, grid, vis);
            }
        }
        return ans;
    }
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        int ans = 0;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j]==0){
                    vis[i][j] = 1;
                }
                else vis[i][j] = 0;
            }
        }
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(vis[i][j]==0 && ((dfs(i, j, grid, vis))%k)==0){
                    ans++;
                }
            }
        }
        return ans;
    }
}