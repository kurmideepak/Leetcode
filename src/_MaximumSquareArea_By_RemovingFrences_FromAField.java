public class _MaximumSquareArea_By_RemovingFrences_FromAField {

    // Copy and Paste it in Solution Class in Leetcode

    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        final int MOD = 1_000_000_007;

        int[] h = new int[hFences.length + 2];
        int[] v = new int[vFences.length + 2];

        h[0] = 1;
        h[h.length - 1] = m;
        v[0] = 1;
        v[v.length - 1] = n;

        System.arraycopy(hFences, 0, h, 1, hFences.length);
        System.arraycopy(vFences, 0, v, 1, vFences.length);

        Arrays.sort(h);
        Arrays.sort(v);

        Set<Long> heights = new HashSet<>();
        for (int i = 0; i < h.length; i++) {
            for (int j = i + 1; j < h.length; j++) {
                heights.add((long) h[j] - h[i]);
            }
        }

        long maxSide = -1;

        for (int i = 0; i < v.length; i++) {
            for (int j = i + 1; j < v.length; j++) {
                long width = (long) v[j] - v[i];
                if (heights.contains(width)) {
                    maxSide = Math.max(maxSide, width);
                }
            }
        }

        if (maxSide == -1) return -1;

        return (int) ((maxSide * maxSide) % MOD);
    }
}
