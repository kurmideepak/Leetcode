public class _516_LongestPalindromicSubsequence {

    // Copy and Paste in Solution Class in Leetcode


    public int lps(int i, int j, String str1, String str2, int[][] dp){
        if(i < 0 || j < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(str1.charAt(i) == str2.charAt(j)){
            return dp[i][j] = 1 + lps(i-1, j-1, str1, str2, dp);
        } else {
            return dp[i][j] = Math.max(lps(i-1, j, str1, str2, dp), lps(i, j-1, str1, str2, dp));
        }
    }
    public int longestPalindromeSubseq(String s) {
        int l = s.length();
        String r = "";
        for(int i = l-1; i >= 0; i--){
            r += s.charAt(i);
        }
        int[][] dp = new int[l][l];
        for(int[] i : dp){
            Arrays.fill(i, -1);
        }
        return lps(l-1, l-1, s, r, dp);
    }
}
