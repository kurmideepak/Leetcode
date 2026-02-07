public class _1653_MinimumDeletionsToMakeStringBalanced {

    // Copy and Paste in Solution Class in Leetcode


    public int minimumDeletions(String s) {
        int countB = 0;
        int deletions = 0;

        for (char ch : s.toCharArray()) {
            if (ch == 'b') {
                countB++;
            } else {
                deletions = Math.min(deletions + 1, countB);
            }
        }

        return deletions;
    }
}
