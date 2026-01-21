public class _3315_ConstructTheMinimumBitwiseArrayII {

    // Copy and Paste it in Solution Class in Leetcode

    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int num = nums.get(i);

            if ((num & 1) == 0) {
                ans[i] = -1;
                continue;
            }

            int best = -1;

            for (int b = 0; b < 31; b++) {
                int candidate = num ^ (1 << b);

                if (candidate >= 0 && (candidate | (candidate + 1)) == num) {
                    if (best == -1 || candidate < best) {
                        best = candidate;
                    }
                }
            }

            ans[i] = best;
        }

        return ans;
    }
}
