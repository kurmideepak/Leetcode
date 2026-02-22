public class _868_BinaryGap {

    // Copy and Paste in Solution Class in Leetcode


    public int binaryGap(int n) {
        int last = -1;
        int maxGap = 0;
        int pos = 0;

        while (n > 0) {
            if ((n & 1) == 1) {
                if (last != -1) {
                    maxGap = Math.max(maxGap, pos - last);
                }
                last = pos;
            }
            pos++;
            n >>= 1;
        }

        return maxGap;
    }
}
