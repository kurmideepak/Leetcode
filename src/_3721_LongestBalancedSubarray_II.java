public class _3721_LongestBalancedSubarray_II {

    // Copy and Paste in Solution Class in Leetcode


    private int[] minVal, maxVal, lazy;
    private int n;

    public int longestBalanced(int[] nums) {
        n = nums.length;
        minVal = new int[4 * n];
        maxVal = new int[4 * n];
        lazy = new int[4 * n];

        Arrays.fill(minVal, 1000000);
        Arrays.fill(maxVal, 1000000);

        int[] last = new int[100001];
        Arrays.fill(last, -1);

        int maxLen = 0;
        for (int r = 0; r < n; r++) {
            updatePoint(1, 0, n - 1, r, 0);

            int val = (nums[r] % 2 == 0) ? 1 : -1;
            int start = last[nums[r]] + 1;
            updateRange(1, 0, n - 1, start, r, val);

            int l = findFirstZero(1, 0, n - 1, 0, r);
            if (l != -1) {
                maxLen = Math.max(maxLen, r - l + 1);
            }
            last[nums[r]] = r;
        }
        return maxLen;
    }

    private void push(int v) {
        if (lazy[v] != 0) {
            minVal[2 * v] += lazy[v];
            maxVal[2 * v] += lazy[v];
            lazy[2 * v] += lazy[v];
            minVal[2 * v + 1] += lazy[v];
            maxVal[2 * v + 1] += lazy[v];
            lazy[2 * v + 1] += lazy[v];
            lazy[v] = 0;
        }
    }

    private void updatePoint(int v, int tl, int tr, int pos, int newVal) {
        if (tl == tr) {
            minVal[v] = newVal;
            maxVal[v] = newVal;
            lazy[v] = 0;
        } else {
            push(v);
            int tm = (tl + tr) / 2;
            if (pos <= tm) updatePoint(2 * v, tl, tm, pos, newVal);
            else updatePoint(2 * v + 1, tm + 1, tr, pos, newVal);
            minVal[v] = Math.min(minVal[2 * v], minVal[2 * v + 1]);
            maxVal[v] = Math.max(maxVal[2 * v], maxVal[2 * v + 1]);
        }
    }

    private void updateRange(int v, int tl, int tr, int l, int r, int add) {
        if (l > r) return;
        if (l == tl && r == tr) {
            minVal[v] += add;
            maxVal[v] += add;
            lazy[v] += add;
        } else {
            push(v);
            int tm = (tl + tr) / 2;
            updateRange(2 * v, tl, tm, l, Math.min(r, tm), add);
            updateRange(2 * v + 1, tm + 1, tr, Math.max(l, tm + 1), r, add);
            minVal[v] = Math.min(minVal[2 * v], minVal[2 * v + 1]);
            maxVal[v] = Math.max(maxVal[2 * v], maxVal[2 * v + 1]);
        }
    }

    private int findFirstZero(int v, int tl, int tr, int l, int r) {
        if (l > r || minVal[v] > 0 || maxVal[v] < 0) return -1;
        if (tl == tr) return tl;
        push(v);
        int tm = (tl + tr) / 2;
        int res = findFirstZero(2 * v, tl, tm, l, Math.min(r, tm));
        if (res == -1) {
            res = findFirstZero(2 * v + 1, tm + 1, tr, Math.max(l, tm + 1), r);
        }
        return res;
    }
}
