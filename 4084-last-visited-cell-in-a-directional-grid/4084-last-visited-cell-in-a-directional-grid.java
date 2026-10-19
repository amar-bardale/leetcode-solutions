class Solution {
    
    public int[] lastVisitedCell(char[][] grid) {
        int n= grid.length;
        int m=grid[0].length;
        int[][] visited=new int[n][m];
        int i=0,j=0;
        while(visited[i][j] == 0){
            int ni = i;
            int nj = j;
            visited[i][j]=1;
            if(grid[i][j] =='R') nj++;
            else if(grid[i][j] =='L') nj--;
            else if(grid[i][j] =='D') ni++;
            else if(grid[i][j] =='U') ni--;
            if (ni < 0 || ni >= n || nj < 0 || nj >= m) {
                break;
            }
            if (visited[ni][nj] == 1) {
                break;
            }
            i = ni;
            j = nj;
        }
        
        return new int[]{i, j};
        
    }
}