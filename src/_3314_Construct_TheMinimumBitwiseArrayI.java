public class _3314_Construct_TheMinimumBitwiseArrayI {

// Copy and Paste it in Solution Class in Leetcode

    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int p = nums.get(i);
            ans[i] = -1;

            // Try all possible x to find the minimum valid one
            for (int x = 0; x <= p; x++) {
                if ((x | (x + 1)) == p) {
                    ans[i] = x;
                    break;
                }
            }
        }
        return ans;
    }
}
