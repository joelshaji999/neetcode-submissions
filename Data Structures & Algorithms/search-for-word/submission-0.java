class Solution {
    public boolean exist(char[][] board, String word) {
        int r = board.length;
        int c = board[0].length;

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(dfs(board, word.toCharArray(), new boolean[r][c], i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, char[] word, boolean[][] isVisited, int i, int j, int k) {
        System.out.println("i " + i);
        System.out.println("j " + j);
        System.out.println("k " + k);

        if(k == word.length){
            return true;
        }

        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || k >= word.length || board[i][j] != word[k] || isVisited[i][j]) {
            return false;
        }

        isVisited[i][j] = true;
        boolean res = dfs(board, word, isVisited, i + 1, j, k + 1) ||
        dfs(board, word, isVisited, i - 1, j, k + 1) ||
        dfs(board, word, isVisited, i, j + 1, k + 1) ||
        dfs(board, word, isVisited, i, j - 1, k + 1);
        isVisited[i][j] = false;

        return res;
    }
}
