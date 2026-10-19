class Solution {
    public int[] lastVisitedCell(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int r = 0, c = 0;

        while (true) {
            char dir = grid[r][c];
            grid[r][c] = '#'; // Mark current cell visited

            int nr = r;
            int nc = c;

            if (dir == 'U') nr--;
            else if (dir == 'D') nr++;
            else if (dir == 'L') nc--;
            else if (dir == 'R') nc++;

            // Check boundary or cycle before moving
            if (nr < 0 || nr >= m || nc < 0 || nc >= n || grid[nr][nc] == '#') {
                return new int[]{r, c};
            }

            r = nr;
            c = nc;
        }
    }
}