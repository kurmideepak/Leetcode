public class _1312_MinimumInsertionSteps_to_Make_A_StringPlalindrome {

    // Copy and Paste in Solution Class in Leetcode

    public int mi(int i, int j, String s, String r, int[][] dp){
        if(i < 0 || j < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(s.charAt(i) == r.charAt(j)){
            return dp[i][j] = 1 + mi(i-1, j-1, s, r, dp);
        } else{
            return dp[i][j] = Math.max(mi(i-1, j, s, r, dp), mi(i, j-1, s, r, dp));
        }
    }
    public int minInsertions(String s) {
        int l = s.length();
        String r = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[l][l];
        for(int[] i : dp){
            Arrays.fill(i, -1);
        }
        return l - mi(l-1, l-1, s, r, dp);
    }
}
