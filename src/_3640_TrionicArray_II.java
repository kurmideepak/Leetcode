public class _3640_TrionicArray_II {

    // Copy and Paste in Solution Class in Leetcode


    public long maxSumTrionic(int[] nums) {
        int n = nums.length;
        long INF = (long) 2e18;

        long[] inc = new long[n];
        long[] peak = new long[n];
        long[] trionic = new long[n];

        java.util.Arrays.fill(inc, -INF);
        java.util.Arrays.fill(peak, -INF);
        java.util.Arrays.fill(trionic, -INF);

        long maxSum = Long.MIN_VALUE;

        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                inc[i] = (long) nums[i] + Math.max((long) nums[i - 1], inc[i - 1]);

                long fromPeak = peak[i - 1] != -INF ? peak[i - 1] + nums[i] : -INF;
                long extendTrionic = trionic[i - 1] != -INF ? trionic[i - 1] + nums[i] : -INF;
                trionic[i] = Math.max(fromPeak, extendTrionic);
            }
            else if (nums[i] < nums[i - 1]) {
                long fromInc = inc[i - 1] != -INF ? inc[i - 1] + nums[i] : -INF;
                long extendPeak = peak[i - 1] != -INF ? peak[i - 1] + nums[i] : -INF;
                peak[i] = Math.max(fromInc, extendPeak);
            }

            if (trionic[i] != -INF) {
                maxSum = Math.max(maxSum, trionic[i]);
            }
        }

        return maxSum;
    }
}
