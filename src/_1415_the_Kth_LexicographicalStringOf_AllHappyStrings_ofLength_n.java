public class _1415_the_Kth_LexicographicalStringOf_AllHappyStrings_ofLength_n {

    // Copy and Paste inside Solution Class in Leetcode


    public String getHappyString(int n, int k) {

        int total = 3 * (1 << (n - 1));
        if (k > total) return "";

        StringBuilder result = new StringBuilder();
        char prev = '#';

        for (int i = 0; i < n; i++) {

            int block = 1 << (n - i - 1);

            for (char c : new char[]{'a','b','c'}) {

                if (c == prev) continue;

                if (k > block) {
                    k -= block;
                } else {
                    result.append(c);
                    prev = c;
                    break;
                }
            }
        }

        return result.toString();
    }
}
