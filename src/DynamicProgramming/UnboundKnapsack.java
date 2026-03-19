package DynamicProgramming;

public class UnboundKnapsack {
    public static int profit(int i, int[] wt, int[] val, int C, int[][] dp){
        if(i == wt.length) return 0;
        if(dp[i][C] != -1) return dp[i][C];
        int skip = profit(i+1, wt, val, C, dp);
        if(wt[i] > C) return dp[i][C] = skip;
        int pick = val[i] + profit(i, wt, val, C-wt[i], dp);
        return dp[i][C] = Math.max(skip, pick);
    }
    public static void main(String[] args) {
        int[] wt = {1, 2, 8, 10};
        int[] val = {5, 3, 9, 16};
        int C = 9;
        int n = wt.length;
        int[][] dp = new int[n][C+1];
        for(int i = 0; i < dp.length; i++){
            for (int j = 0; j < dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        System.out.println(profit(0, wt, val, C, dp));
    }
}
