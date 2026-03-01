public class _1689_PartitioningInto_MinimumNumberOf_Deci_BinaryNumbers {

    // Copy and Paste inside Solution Class in Leetcode


    public int minPartitions(String n) {
        int maxDigit = 0;

        for (char c : n.toCharArray()) {
            int digit = c - '0';
            maxDigit = Math.max(maxDigit, digit);

            if (maxDigit == 9) {
                return 9;
            }
        }

        return maxDigit;
    }
}
