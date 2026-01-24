public class _1877_MinimizeMaximumPairSum_InArray {

    // Copy and Paste it in Solution Class in Leetcode


    public int minPairSum(int[] nums) {
        int MAX = 100000;
        int[] freq = new int[MAX + 1];

        for (int num : nums) {
            freq[num]++;
        }

        int left = 0;
        int right = MAX;
        int maxSum = 0;

        while (left <= right) {
            while (left <= right && freq[left] == 0) left++;
            while (left <= right && freq[right] == 0) right--;

            if (left > right) break;

            maxSum = Math.max(maxSum, left + right);

            freq[left]--;
            freq[right]--;
        }

        return maxSum;
    }
}
