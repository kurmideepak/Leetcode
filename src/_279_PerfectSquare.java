public class _279_PerfectSquare {

    // Copy and Paste inside Solution Class in Leetcode



    public boolean isPerfect(int n){
        int num = (int)(Math.sqrt(n));
        return (num*num == n);
    }

    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for(int i = 0; i <= n; i++){
            if(isPerfect(i)) dp[i] = 1;
            else{
                int min = Integer.MAX_VALUE;
                for(int j = 1; j*j <= i; j++){
                    int count = dp[j*j] + dp[i-j*j];
                    min = Math.min(count, min);
                }
                dp[i] = min;
            }
        }
        return dp[n];
    }
}
