public class _3454_SeparateSquare_II {

    // Copy and Paste it in Solution Class in Leetcode

    static class Event {
        long y;
        int x1, x2;
        int type;
        Event(long y, int x1, int x2, int type) {
            this.y = y;
            this.x1 = x1;
            this.x2 = x2;
            this.type = type;
        }
    }

    static class SegmentTree {
        int n;
        int[] count;
        long[] length;
        long[] xs;

        SegmentTree(long[] xs) {
            this.xs = xs;
            this.n = xs.length - 1;
            count = new int[4 * n];
            length = new long[4 * n];
        }

        void update(int idx, int l, int r, int ql, int qr, int val) {
            if (qr <= l || r <= ql) return;
            if (ql <= l && r <= qr) {
                count[idx] += val;
            } else {
                int mid = (l + r) / 2;
                update(idx * 2, l, mid, ql, qr, val);
                update(idx * 2 + 1, mid, r, ql, qr, val);
            }

            if (count[idx] > 0) {
                length[idx] = xs[r] - xs[l];
            } else if (l + 1 == r) {
                length[idx] = 0;
            } else {
                length[idx] = length[idx * 2] + length[idx * 2 + 1];
            }
        }

        long query() {
            return length[1];
        }
    }

    public double separateSquares(int[][] squares) {

        List<Long> xVals = new ArrayList<>();
        List<Event> events = new ArrayList<>();

        for (int[] s : squares) {
            long x = s[0], y = s[1], l = s[2];
            xVals.add(x);
            xVals.add(x + l);
        }

        Collections.sort(xVals);
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < xVals.size(); i++) {
            map.putIfAbsent(xVals.get(i), map.size());
        }

        long[] xs = new long[map.size()];
        for (Map.Entry<Long, Integer> e : map.entrySet()) {
            xs[e.getValue()] = e.getKey();
        }

        for (int[] s : squares) {
            long x = s[0], y = s[1], l = s[2];
            int x1 = map.get(x);
            int x2 = map.get(x + l);
            events.add(new Event(y, x1, x2, +1));
            events.add(new Event(y + l, x1, x2, -1));
        }

        events.sort(Comparator.comparingLong(e -> e.y));

        SegmentTree st = new SegmentTree(xs);

        double totalArea = 0;
        long prevY = events.get(0).y;
        List<double[]> strips = new ArrayList<>();

        for (Event e : events) {
            long currY = e.y;
            long width = st.query();
            if (currY > prevY && width > 0) {
                double area = width * (currY - prevY);
                strips.add(new double[]{prevY, currY, width});
                totalArea += area;
            }
            st.update(1, 0, st.n, e.x1, e.x2, e.type);
            prevY = currY;
        }

        double half = totalArea / 2;
        double curr = 0;

        for (double[] s : strips) {
            double area = (s[1] - s[0]) * s[2];
            if (curr + area >= half) {
                return s[0] + (half - curr) / s[2];
            }
            curr += area;
        }
        return 0;
    }
}
