public class _3650_MinimumCostPath_WithEdgeReversals {

    // Copy and Paste it in Solution Class in Leetcode


    public int minCost(int n, int[][] edges) {

        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];

            graph.get(u).add(new int[]{v, w});
            graph.get(v).add(new int[]{u, 2 * w});
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        pq.offer(new long[]{0, 0});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            int node = (int) cur[0];
            long cost = cur[1];

            if (cost > dist[node]) continue;
            if (node == n - 1) return (int) cost;

            for (int[] next : graph.get(node)) {
                int nei = next[0];
                int w = next[1];

                if (dist[node] + w < dist[nei]) {
                    dist[nei] = dist[node] + w;
                    pq.offer(new long[]{nei, dist[nei]});
                }
            }
        }

        return -1;
    }
}
