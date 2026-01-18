public class _1895_LargestMagicSquare {

// Copy and Paste it in Solution Class in Leetcode

    public int largestMagicSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] row = new int[m][n + 1];
        int[][] col = new int[m + 1][n];
        int[][] diag1 = new int[m + 1][n + 1];
        int[][] diag2 = new int[m + 1][n + 1];

        // Prefix sums
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                row[i][j + 1] = row[i][j] + grid[i][j];
                col[i + 1][j] = col[i][j] + grid[i][j];
                diag1[i + 1][j + 1] = diag1[i][j] + grid[i][j];
                diag2[i + 1][j] = diag2[i][j + 1] + grid[i][j];
            }
        }

        for (int k = Math.min(m, n); k >= 2; k--) {
            for (int i = 0; i + k <= m; i++) {
                for (int j = 0; j + k <= n; j++) {

                    int target = row[i][j + k] - row[i][j];
                    boolean valid = true;

                    // Check rows
                    for (int r = i; r < i + k; r++) {
                        if (row[r][j + k] - row[r][j] != target) {
                            valid = false;
                            break;
                        }
                    }

                    // Check columns
                    for (int c = j; c < j + k && valid; c++) {
                        if (col[i + k][c] - col[i][c] != target) {
                            valid = false;
                            break;
                        }
                    }

                    // Check diagonals
                    int d1 = diag1[i + k][j + k] - diag1[i][j];
                    int d2 = diag2[i + k][j] - diag2[i][j + k];

                    if (valid && d1 == target && d2 == target) {
                        return k;
                    }
                }
            }
        }

        return 1;
    }
}
