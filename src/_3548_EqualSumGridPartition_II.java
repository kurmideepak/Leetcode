public class _3548_EqualSumGridPartition_II {

    // Copy and Paste in Solution Class in Leetcode


    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        long total = 0;
        Map<Integer, Integer> fullMap = new HashMap<>();
        for (int[] row : grid) {
            for (int val : row) {
                total += val;
                fullMap.put(val, fullMap.getOrDefault(val, 0) + 1);
            }
        }

        Map<Integer, Integer> topMap = new HashMap<>();
        Map<Integer, Integer> bottomMap = new HashMap<>(fullMap);

        long topSum = 0;

        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n; j++) {
                int val = grid[i][j];
                topSum += val;
                topMap.put(val, topMap.getOrDefault(val, 0) + 1);
                int count = bottomMap.getOrDefault(val, 0);
                if (count <= 1) bottomMap.remove(val);
                else bottomMap.put(val, count - 1);
            }

            long bottomSum = total - topSum;

            if (topSum == bottomSum) return true;

            long diff = Math.abs(topSum - bottomSum);

            if (topSum > bottomSum) {
                if (canRemove(grid, topMap, 0, i, 0, n - 1, diff)) return true;
            } else {
                if (canRemove(grid, bottomMap, i + 1, m - 1, 0, n - 1, diff)) return true;
            }
        }

        Map<Integer, Integer> leftMap = new HashMap<>();
        Map<Integer, Integer> rightMap = new HashMap<>(fullMap);

        long leftSum = 0;

        for (int j = 0; j < n - 1; j++) {
            for (int i = 0; i < m; i++) {
                int val = grid[i][j];
                leftSum += val;
                leftMap.put(val, leftMap.getOrDefault(val, 0) + 1);
                int count = rightMap.getOrDefault(val, 0);
                if (count <= 1) rightMap.remove(val);
                else rightMap.put(val, count - 1);
            }

            long rightSum = total - leftSum;

            if (leftSum == rightSum) return true;

            long diff = Math.abs(leftSum - rightSum);

            if (leftSum > rightSum) {
                if (canRemove(grid, leftMap, 0, m - 1, 0, j, diff)) return true;
            } else {
                if (canRemove(grid, rightMap, 0, m - 1, j + 1, n - 1, diff)) return true;
            }
        }

        return false;
    }

    private boolean canRemove(int[][] grid, Map<Integer, Integer> map,
                              int r1, int r2, int c1, int c2, long target) {

        if (target > Integer.MAX_VALUE || !map.containsKey((int) target)) return false;

        int targetInt = (int) target;
        int rows = r2 - r1 + 1;
        int cols = c2 - c1 + 1;

        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                if (grid[i][j] == targetInt) {
                    if (rows == 1) {
                        if (j == c1 || j == c2) return true;
                    } else if (cols == 1) {
                        if (i == r1 || i == r2) return true;
                    } else {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
