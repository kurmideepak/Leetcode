public class _05_LongestPalindromicSubstring {


    // Copy and Paste in Solution Class in Leetcode

    public String longestPalindrome(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        int start = 0;
        int maxLen = 1;

        for(int k = 0; k < n; k++){
            int i = 0, j = k;
            while(j<n){
                if(i==j){
                    dp[i][j] = 1;

                } else if(j == i+1){
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = 1;
                        start = i;
                        maxLen = 2;
                    }
                } else{
                    if(s.charAt(i) == s.charAt(j)){
                        if(dp[i+1][j-1] == 1){
                            dp[i][j] = 1;
                            start = i;
                            maxLen = j-i+1;
                        }
                    }
                }
                i++;
                j++;
            }
        }
        return s.substring(start, start + maxLen);
    }
}
