public class _3507_MinimumPairRemovalToSortArrayI {

        // Copy and Paste it in Solution Class in Leetcode

    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        int[] arr = nums.clone();
        int size = n;
        int operations = 0;

        while (!isSorted(arr, size)) {
            int minSum = Integer.MAX_VALUE;
            int index = 0;

            for (int i = 0; i < size - 1; i++) {
                int sum = arr[i] + arr[i + 1];
                if (sum < minSum) {
                    minSum = sum;
                    index = i;
                }
            }

            arr[index] = arr[index] + arr[index + 1];
            for (int i = index + 1; i < size - 1; i++) {
                arr[i] = arr[i + 1];
            }

            size--;
            operations++;
        }

        return operations;
    }

    private boolean isSorted(int[] arr, int size) {
        for (int i = 1; i < size; i++) {
            if (arr[i] < arr[i - 1]) return false;
        }
        return true;
    }
}
