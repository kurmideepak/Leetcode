public class _1461_CheckIfA_StringContainsAllBinary_CodesOfSize_K {

    // Copy and Paste in Solution Class in Leetcode


    public boolean hasAllCodes(String s, int k) {
        int n = s.length();
        if (n < k) return false;

        int totalCodes = 1 << k;
        boolean[] seen = new boolean[totalCodes];

        int mask = totalCodes - 1;
        int hash = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            hash = ((hash << 1) & mask) | (s.charAt(i) - '0');

            if (i >= k - 1 && !seen[hash]) {
                seen[hash] = true;
                count++;

                if (count == totalCodes) {
                    return true;
                }
            }
        }
        return false;
    }
}
