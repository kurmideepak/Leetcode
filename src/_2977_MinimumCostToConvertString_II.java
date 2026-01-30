public class _2977_MinimumCostToConvertString_II {

// Copy and Paste it in Solution Class in Leetcode



    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        int n = source.length();
        Map<String, Integer> id = new HashMap<>();
        List<String> all = new ArrayList<>();

        for (int i = 0; i < original.length; i++) {
            if (!id.containsKey(original[i])) {
                id.put(original[i], all.size());
                all.add(original[i]);
            }
            if (!id.containsKey(changed[i])) {
                id.put(changed[i], all.size());
                all.add(changed[i]);
            }
        }

        int m = all.size();
        long INF = Long.MAX_VALUE / 4;
        long[][] dist = new long[m][m];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int i = 0; i < original.length; i++) {
            int u = id.get(original[i]);
            int v = id.get(changed[i]);
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }

        for (int k = 0; k < m; k++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        long[] dp = new long[n + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            if (dp[i] == INF) continue;

            if (source.charAt(i) == target.charAt(i)) {
                dp[i + 1] = Math.min(dp[i + 1], dp[i]);
            }

            for (String s : id.keySet()) {
                int len = s.length();
                if (i + len > n) continue;

                String srcSub = source.substring(i, i + len);
                String tgtSub = target.substring(i, i + len);

                if (!srcSub.equals(s)) continue;
                if (!id.containsKey(tgtSub)) continue;

                long c = dist[id.get(srcSub)][id.get(tgtSub)];
                if (c < INF) {
                    dp[i + len] = Math.min(dp[i + len], dp[i] + c);
                }
            }
        }

        return dp[n] == INF ? -1 : dp[n];
    }
}
