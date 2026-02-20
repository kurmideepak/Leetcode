public class _761_SpecialBinaryString {


    // Copy and Paste in Solution Class in Leetcode

    public String makeLargestSpecial(String s) {
        List<String> parts = new ArrayList<>();
        int balance = 0, start = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') balance++;
            else balance--;

            if (balance == 0) {
                String inner = s.substring(start + 1, i);
                parts.add("1" + makeLargestSpecial(inner) + "0");
                start = i + 1;
            }
        }

        parts.sort(Collections.reverseOrder());

        StringBuilder result = new StringBuilder();
        for (String part : parts) {
            result.append(part);
        }

        return result.toString();
    }
}
