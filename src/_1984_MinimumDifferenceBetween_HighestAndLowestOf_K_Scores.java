public class _1984_MinimumDifferenceBetween_HighestAndLowestOf_K_Scores {

// Copy and Paste it in Solution Class in Leetcode

    public int minimumDifference(int[] nums, int k) {
        int lowest = Integer.MAX_VALUE;
        if (k <= 1) return 0;

        Arrays.sort(nums);
        for (int i = 0; i+k-1 < nums.length; i++){
            int diff = nums[i+k-1] - nums[i];
            lowest = Math.min(lowest, diff);
        }
        return lowest;
    }
}
