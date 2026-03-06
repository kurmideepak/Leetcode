public class _1784_CheckIfBinaryStringHas_atMost_OneSegmentOfOnes {

    // Copy and Paste inside Solution Class in Leetcode


    public boolean checkOnesSegment(String s) {
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '1' && s.charAt(i - 1) == '0') {
                return false;
            }
        }
        return true;
    }
}
