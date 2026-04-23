class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0, col = 0;
        int colSize = matrix[0].length - 1;
        int rowSize = matrix.length - 1;

        while(row <= rowSize) {
            if(target >= matrix[row][col] && target <= matrix[row][colSize]) {
                
                int l = 0, r = colSize;

                while(l<=r) {
                    int m = l + (r-l)/2;

                    if(matrix[row][m] == target) return true;
                    else if(matrix[row][m] > target){
                        r = m - 1;
                    } else {
                        l = m + 1;
                    }
                }
                break;
            } else {
                row++;
            }
        }

        return false;
    }
}
