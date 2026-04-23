class Solution {
    int maxArea = 0;
    int[][] directions = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} }; 

    public int maxAreaOfIsland(int[][] grid) {
        
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && isVisited[i][j] == false)
                    bfs(grid, isVisited, i, j);
            }
        }

        return maxArea;
    }

    private void bfs(int[][] grid, boolean[][] isVisited, int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r,c});
        isVisited[r][c] = true;
        int area = 1;

        while(!q.isEmpty()) {
            int[] node = q.poll();
            int row = node[0];
            int col = node[1];
            
            for(int[] dir : directions) {
                int nr = row + dir[0];
                int nc = col + dir[1];
                
                if (nr >= 0 && nr < grid.length
                && nc >= 0 && nc < grid[0].length
                && grid[nr][nc] == 1
                && isVisited[nr][nc] == false
                ) {
                    q.add(new int[] {nr, nc});
                    area++;
                    isVisited[nr][nc] = true;
                }
            }
        }
        
        maxArea = Math.max(area, maxArea);
    }
}
