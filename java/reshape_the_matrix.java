class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        
        // If total elements don't match, reshape is impossible
        if (m * n != r * c) {
            return mat;
        }
        
        int[][] res = new int[r][c];
        int count = 0;
        
        // Traverse the original matrix and fill the new one
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Map the 1D index (count) to 2D coordinates in the result matrix
                res[count / c][count % c] = mat[i][j];
                count++;
            }
        }
        
        return res;
    }
}
