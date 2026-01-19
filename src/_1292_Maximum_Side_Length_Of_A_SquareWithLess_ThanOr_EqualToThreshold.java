public class _1292_Maximum_Side_Length_Of_A_SquareWithLess_ThanOr_EqualToThreshold {

// Copy and Paste it in Solution Class in Leetcode

    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length, n = mat[0].length;

        // Step 1: Prefix sum
        int[][] prefix = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefix[i][j] = mat[i - 1][j - 1]
                        + prefix[i - 1][j]
                        + prefix[i][j - 1]
                        - prefix[i - 1][j - 1];
            }
        }

        int left = 1, right = Math.min(m, n);
        int ans = 0;

        // Step 2: Binary Search on side length
        while (left <= right) {
            int mid = (left + right) / 2;
            if (existsSquare(prefix, m, n, mid, threshold)) {
                ans = mid;
                left = mid + 1; // try bigger square
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    private boolean existsSquare(int[][] prefix, int m, int n, int k, int threshold) {
        for (int i = k; i <= m; i++) {
            for (int j = k; j <= n; j++) {
                int sum = prefix[i][j]
                        - prefix[i - k][j]
                        - prefix[i][j - k]
                        + prefix[i - k][j - k];
                if (sum <= threshold) return true;
            }
        }
        return false;
    }
}
