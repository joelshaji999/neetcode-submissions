class Solution {
    public boolean isValidSudoku(char[][] board) {

        for(int i=0; i<9; i++) {
            HashSet<Character> seen = new HashSet<Character>();
            
            for(int j=0; j<9; j++) {
                if(board[i][j] == '.')
                    continue;
                if(seen.contains(board[i][j]))
                    return false;
                
                seen.add(board[i][j]);
            }
        }

        for(int i=0; i<9; i++) {
            HashSet<Character> seen = new HashSet<Character>();
            
            for(int j=0; j<9; j++) {
                if(board[j][i] == '.')
                    continue;
                if(seen.contains(board[j][i]))
                    return false;
                
                seen.add(board[j][i]);
            }
        }

        for(int square=0; square<9; square++) {
            HashSet<Character> seen = new HashSet<Character>();
            
            for(int i=0; i<3; i++) {
                for(int j=0; j<3; j++){
                    int row = (square/3)*3+i;
                    int col = (square%3)*3+j;

                if(board[row][col] == '.')
                    continue;
                if(seen.contains(board[row][col]))
                    return false;
                
                seen.add(board[row][col]);
                }
            }
        }

        return true;

    }
}
