public class _1320_MinimumDistanceToType_a_WordUsingTwoFingers {

    // Copy and Paste in Solution Class in Leetcode


    public int minimumDistance(String word) {
        int[] dp = new int[27];
        int res = 0;

        for (int i = 0; i < word.length() - 1; ++i) {
            int b = word.charAt(i) - 'A';
            int c = word.charAt(i + 1) - 'A';
            int[] newDp = dp.clone();

            for (int a = 0; a < 27; ++a) {
                newDp[b] = Math.max(newDp[b], dp[a] + dist(b, c) - dist(a, c));
            }

            dp = newDp;
            res += dist(b, c);
        }

        int maxSave = 0;
        for (int save : dp) {
            maxSave = Math.max(maxSave, save);
        }

        return res - maxSave;
    }

    private int dist(int a, int b) {
        if (a == 26) return 0;
        return Math.abs(a / 6 - b / 6) + Math.abs(a % 6 - b % 6);
    }
}
