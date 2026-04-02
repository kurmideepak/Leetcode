public class _3418_MaximumAmount_Of_MoneyRobotCan_Earn {

    // Copy and Paste in Solution Class in Leetcode


    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;
        int[][][] dp = new int[m][n][3];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][0] = Integer.MIN_VALUE / 2;
                dp[i][j][1] = Integer.MIN_VALUE / 2;
                dp[i][j][2] = Integer.MIN_VALUE / 2;
            }
        }

        dp[0][0][0] = coins[0][0];
        if (coins[0][0] < 0) {
            dp[0][0][1] = 0;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;

                int val = coins[i][j];

                for (int k = 0; k < 3; k++) {
                    int prev = Integer.MIN_VALUE / 2;
                    if (i > 0) prev = Math.max(prev, dp[i - 1][j][k]);
                    if (j > 0) prev = Math.max(prev, dp[i][j - 1][k]);

                    dp[i][j][k] = Math.max(dp[i][j][k], prev + val);

                    if (val < 0 && k > 0) {
                        int prevK = Integer.MIN_VALUE / 2;
                        if (i > 0) prevK = Math.max(prevK, dp[i - 1][j][k - 1]);
                        if (j > 0) prevK = Math.max(prevK, dp[i][j - 1][k - 1]);
                        dp[i][j][k] = Math.max(dp[i][j][k], prevK);
                    }
                }
            }
        }

        return Math.max(dp[m - 1][n - 1][0], Math.max(dp[m - 1][n - 1][1], dp[m - 1][n - 1][2]));
    }
}
