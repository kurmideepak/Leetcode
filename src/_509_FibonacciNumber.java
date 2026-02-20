public class _509_FibonacciNumber {

    // Copy and Paste in Solution Class in Leetcode


    static int[] dp;
    public int fibo(int n) {
        if(n <= 1) return n;
        if(dp[n] != 0) return dp[n];
        int ans = fibo(n-1) + fibo(n-2);
        dp[n] = ans;
        return ans;
    }

    public int fib(int n){
        dp = new int[n+1];
        return fibo(n);
    }
}
