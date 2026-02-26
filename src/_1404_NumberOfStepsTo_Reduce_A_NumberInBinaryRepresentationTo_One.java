public class _1404_NumberOfStepsTo_Reduce_A_NumberInBinaryRepresentationTo_One {

    // Copy and Paste in Solution Class in Leetcode


    public int numSteps(String s) {
        int steps = 0;
        int carry = 0;

        for (int i = s.length() - 1; i > 0; i--) {
            int bit = s.charAt(i) - '0';

            if (bit + carry == 1) {
                steps += 2;
                carry = 1;
            } else {
                steps += 1;
            }
        }
        return steps + carry;
    }
}
