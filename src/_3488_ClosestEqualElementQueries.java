public class _3488_ClosestEqualElementQueries {

    // Copy and paste the below code in your solution


    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        Map<Integer, List<Integer>> positions = new HashMap<>();

        for (int i = 0; i < n; i++) {
            positions.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        int[] minDistance = new int[n];
        for (int i = 0; i < n; i++) {
            minDistance[i] = -1;
        }

        for (List<Integer> indices : positions.values()) {
            int size = indices.size();
            if (size > 1) {
                for (int i = 0; i < size; i++) {
                    int curr = indices.get(i);
                    int prev = indices.get((i - 1 + size) % size);
                    int next = indices.get((i + 1) % size);

                    int distToPrev = Math.abs(curr - prev);
                    distToPrev = Math.min(distToPrev, n - distToPrev);

                    int distToNext = Math.abs(curr - next);
                    distToNext = Math.min(distToNext, n - distToNext);

                    minDistance[curr] = Math.min(distToPrev, distToNext);
                }
            }
        }

        List<Integer> result = new ArrayList<>(queries.length);
        for (int q : queries) {
            result.add(minDistance[q]);
        }

        return result;
    }






}
