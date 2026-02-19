public class _696_CountBinarySubstrings {

    // Copy and Paste in Solution Class in Leetcode


        public int countBinarySubstrings(String s) {
            int prev = 0;     // length of previous group
            int curr = 1;     // length of current group
            int result = 0;

            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == s.charAt(i - 1)) {
                    curr++;
                } else {
                    result += Math.min(prev, curr);
                    prev = curr;
                    curr = 1;
                }
            }

            // Add for the last group
            result += Math.min(prev, curr);

            return result;
        }
    }
