public class _2463_MinimumTotalDistanceTraveled {

    // Copy and paste the below code in your solution


    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> Integer.compare(a[0], b[0]));

        int n = robot.size();
        int m = factory.length;
        long[][] dp = new long[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], (long) 1e15);
        }

        for (int j = m - 1; j >= 0; j--) {
            dp[n][j] = 0;
            for (int i = n - 1; i >= 0; i--) {
                dp[i][j] = dp[i][j + 1];
                long dist = 0;
                for (int k = 1; k <= factory[j][1] && i + k <= n; k++) {
                    dist += Math.abs((long) robot.get(i + k - 1) - factory[j][0]);
                    dp[i][j] = Math.min(dp[i][j], dist + dp[i + k][j + 1]);
                }
            }
        }

        return dp[0][0];
    }
}
