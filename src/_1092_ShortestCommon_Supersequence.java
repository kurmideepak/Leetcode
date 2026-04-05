public class _1092_ShortestCommon_Supersequence {


    // Copy and Paste in Solution Class in Leetcode


    public String lcs(String a, String b){
        int m = a.length();
        int n = b.length();
        int[][] dp = new int[m+1][n+1];

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        StringBuilder str = new StringBuilder();
        int i = m, j = n;

        while(i > 0 && j > 0){
            if(a.charAt(i-1) == b.charAt(j-1)){
                str.append(a.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i-1][j] > dp[i][j-1]){
                i--;
            }
            else{
                j--;
            }
        }

        return str.reverse().toString();
    }
    public String shortestCommonSupersequence(String str1, String str2) {
        String LCS = lcs(str1, str2);
        int i = 0, j = 0, k = 0;
        String ans = "";
        while(i<str1.length() && j < str2.length() && k < LCS.length()){
            while(str1.charAt(i) != LCS.charAt(k)){
                ans += str1.charAt(i);
                i++;
            }
            while(str2.charAt(j) != LCS.charAt(k)){
                ans += str2.charAt(j);
                j++;
            }
            if(str1.charAt(i) == LCS.charAt(k) && str2.charAt(j) == LCS.charAt(k)){
                ans += str1.charAt(i);
                i++;
                j++;
                k++;
            }
        }
        while(j < str2.length()){
            ans += str2.charAt(j);
            j++;
        }
        while(i < str1.length()){
            ans += str1.charAt(i);
            i++;
        }
        return ans;
    }
}
