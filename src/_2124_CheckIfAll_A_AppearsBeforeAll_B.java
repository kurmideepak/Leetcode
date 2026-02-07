public class _2124_CheckIfAll_A_AppearsBeforeAll_B {

    // Copy and Paste in Solution Class in Leetcode


    public boolean checkString(String s) {
        boolean seenB = false;

        for (char ch : s.toCharArray()) {
            if (ch == 'b') {
                seenB = true;
            } else {
                if (seenB) {
                    return false;
                }
            }
        }

        return true;
    }
}
