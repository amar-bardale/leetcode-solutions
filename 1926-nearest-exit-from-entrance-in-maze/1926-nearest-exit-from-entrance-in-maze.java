class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] vis = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(vis[i], 0);
        }

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(maze[i][j]=='+'){
                    vis[i][j] = 1;
                }
            }
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{entrance[0], entrance[1], 0});
        vis[entrance[0]][entrance[1]] = 1;
        int[] delRow = {0, -1, 0, 1};
        int[] delCol = {1, 0, -1, 0};
        while(!q.isEmpty()){
            int[] pos = q.poll();
            int row = pos[0];
            int col = pos[1];
            int steps = pos[2];

            if ((row == 0 || row == m - 1 || col == 0 || col == n - 1) && (row != entrance[0] || col != entrance[1])) { 
                return steps; 
            }

            for(int i = 0; i<4; i++){
                int nRow = row+delRow[i];
                int nCol = col+delCol[i];

                if(nRow>=0 && nRow<m && nCol>=0 && nCol<n && vis[nRow][nCol]!=1){
                    vis[nRow][nCol] = 1;
                    q.add(new int[]{nRow, nCol, steps+1});
                }
            }
        }
        return -1;
    }
}