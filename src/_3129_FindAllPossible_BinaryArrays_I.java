public class _3129_FindAllPossible_BinaryArrays_I {

    // Copy and Paste inside Solution Class in Leetcode



    int M = 1000000007;
    public int solve(int onesLeft, int zerosLeft, boolean lastOne, int limit, int[][][] dp){
        if(onesLeft == 0 && zerosLeft == 0) return 1;
        int result = 0;
        int idx = lastOne ? 1 : 0;
        if(dp[onesLeft][zerosLeft][idx] != -1) return dp[onesLeft][zerosLeft][idx];
        if(lastOne == true){
            for(int i = 1; i <= Math.min(zerosLeft, limit); i++){
                result = (result + solve(onesLeft, zerosLeft - i, false, limit, dp)) % M;
            }
        } else{
            for(int i = 1; i <= Math.min(onesLeft, limit); i++){
                result = (result + solve(onesLeft-i, zerosLeft, true, limit, dp)) % M;
            }
        }
        return dp[onesLeft][zerosLeft][idx] = result;
    }
    public int numberOfStableArrays(int zero, int one, int limit) {
        int[][][] dp = new int[201][201][2];
        for(int i = 0; i < 201; i++){
            for(int j = 0; j < 201; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        int startWithOne = solve(one, zero, false, limit, dp);
        int startWithZero = solve(one, zero, true, limit, dp);
        return (startWithOne + startWithZero) % M;
    }
}
