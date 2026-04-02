class Solution {
    public int numIslands(char[][] grid) {

        int result = 0;

        for(int i = 0 ; i < grid.length ; i++) {
            for(int j = 0 ; j < grid[0].length ; j++) {
                result += updateIsland(grid, i, j);
            }
        }

        return result;
    }

    public int updateIsland(char[][] grid, int i, int j) {
        if(grid[i][j] == '0') {

            return 0;

        } else {
            grid[i][j] = '0';

            // up
            if(i > 0) {
                updateIsland(grid, i - 1, j);
            }

            // down
            if(i < grid.length - 1) {
                updateIsland(grid, i + 1, j);
            }

            // left
            if(j > 0) {
                updateIsland(grid, i, j - 1);
            }

            // left
            if(j < grid[i].length - 1) {
                updateIsland(grid, i, j + 1);
            }

            return 1;
        }
    }
}
