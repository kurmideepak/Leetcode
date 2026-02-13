public class _3714_LongestBalancedSubstring_II {

    // Copy and Paste in Solution Class in Leetcode


    public int longestBalanced(String s) {
        int a = 0, b = 0, c = 0;
        int maxLen = 0;

        Map<String, Integer> mapAll = new HashMap<>();
        Map<String, Integer> mapAB = new HashMap<>();
        Map<String, Integer> mapAC = new HashMap<>();
        Map<String, Integer> mapBC = new HashMap<>();

        mapAll.put("0#0", -1);
        mapAB.put("0#0", -1);
        mapAC.put("0#0", -1);
        mapBC.put("0#0", -1);

        int runLen = 1;
        maxLen = 1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'a') a++;
            else if (ch == 'b') b++;
            else c++;

            if (i > 0 && s.charAt(i) == s.charAt(i - 1)) runLen++;
            else runLen = 1;
            maxLen = Math.max(maxLen, runLen);

            String keyAll = (a - b) + "#" + (a - c);
            String keyAB  = (a - b) + "#" + c;
            String keyAC  = (a - c) + "#" + b;
            String keyBC  = (b - c) + "#" + a;

            if (mapAll.containsKey(keyAll))
                maxLen = Math.max(maxLen, i - mapAll.get(keyAll));
            else mapAll.put(keyAll, i);

            if (mapAB.containsKey(keyAB))
                maxLen = Math.max(maxLen, i - mapAB.get(keyAB));
            else mapAB.put(keyAB, i);

            if (mapAC.containsKey(keyAC))
                maxLen = Math.max(maxLen, i - mapAC.get(keyAC));
            else mapAC.put(keyAC, i);

            if (mapBC.containsKey(keyBC))
                maxLen = Math.max(maxLen, i - mapBC.get(keyBC));
            else mapBC.put(keyBC, i);
        }

        return maxLen;
    }
}
