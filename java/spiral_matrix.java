import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return result;

        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // 1. Move Right: across the top row
            for (int i = left; i <= right; i++) result.add(matrix[top][i]);
            top++;

            // 2. Move Down: along the right column
            for (int i = top; i <= bottom; i++) result.add(matrix[i][right]);
            right--;

            // 3. Move Left: across the bottom row (if rows remain)
            if (top <= bottom) {
                for (int i = right; i >= left; i--) result.add(matrix[bottom][i]);
                bottom--;
            }

            // 4. Move Up: along the left column (if columns remain)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) result.add(matrix[i][left]);
                left++;
            }
        }
        return result;
    }
}
