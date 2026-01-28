public class _3651_MinimumCostPathWithTeleportations {

    // Copy and Paste it in Solution Class in Leetcode


    static class State {
        int r, c, t, cost;
        State(int r, int c, int t, int cost) {
            this.r = r;
            this.c = c;
            this.t = t;
            this.cost = cost;
        }
    }

    public int minCost(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int INF = Integer.MAX_VALUE / 2;

        int[][][] dist = new int[k + 1][m][n];
        for (int t = 0; t <= k; t++)
            for (int i = 0; i < m; i++)
                Arrays.fill(dist[t][i], INF);

        PriorityQueue<State> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        dist[0][0][0] = 0;
        pq.offer(new State(0, 0, 0, 0));

        // Cells sorted by value
        List<int[]> cells = new ArrayList<>();
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                cells.add(new int[]{grid[i][j], i, j});
        cells.sort(Comparator.comparingInt(a -> a[0]));

        int[] teleportIdx = new int[k + 1];

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            int r = cur.r, c = cur.c, t = cur.t, cost = cur.cost;

            if (cost != dist[t][r][c]) continue;
            if (r == m - 1 && c == n - 1) return cost;

            if (r + 1 < m) {
                int nc = cost + grid[r + 1][c];
                if (nc < dist[t][r + 1][c]) {
                    dist[t][r + 1][c] = nc;
                    pq.offer(new State(r + 1, c, t, nc));
                }
            }
            if (c + 1 < n) {
                int nc = cost + grid[r][c + 1];
                if (nc < dist[t][r][c + 1]) {
                    dist[t][r][c + 1] = nc;
                    pq.offer(new State(r, c + 1, t, nc));
                }
            }

            if (t < k) {
                int idx = teleportIdx[t];
                while (idx < cells.size() && cells.get(idx)[0] <= grid[r][c]) {
                    int nr = cells.get(idx)[1];
                    int nc = cells.get(idx)[2];
                    if (cost < dist[t + 1][nr][nc]) {
                        dist[t + 1][nr][nc] = cost;
                        pq.offer(new State(nr, nc, t + 1, cost));
                    }
                    idx++;
                }
                teleportIdx[t] = idx;
            }
        }

        return -1;
    }
}
