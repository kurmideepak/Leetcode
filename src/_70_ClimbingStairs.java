public class _70_ClimbingStairs {

    // Copy and Paste in Solution Class in Leetcode


    public int way(int n, int[] dp){
        if(n == 1 || n == 2) return n;
        if(dp[n] != -1) return dp[n];
        return dp[n] = way(n-1, dp) + way(n-2, dp);
    }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return way(n, dp);
    }
}
