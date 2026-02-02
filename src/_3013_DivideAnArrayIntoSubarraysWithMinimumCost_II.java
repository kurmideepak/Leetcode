public class _3013_DivideAnArrayIntoSubarraysWithMinimumCost_II {

    // Copy and Paste it in Solution Class in Leetcode

    public long minimumCost(int[] nums, int k, int dist) {
        long baseCost = nums[0];

        int target = k - 1;

        if (target == 0) return baseCost;

        long result = Long.MAX_VALUE;
        long currentSum = 0;

        TreeMap<Integer, Integer> top = new TreeMap<>();
        TreeMap<Integer, Integer> rest = new TreeMap<>();
        int topSize = 0;

        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];

            top.put(val, top.getOrDefault(val, 0) + 1);
            topSize++;
            currentSum += val;

            if (topSize > target) {
                int last = top.lastKey();
                remove(top, last);
                topSize--;
                currentSum -= last;
                rest.put(last, rest.getOrDefault(last, 0) + 1);
            }

            if (i > dist + 1) {
                int outVal = nums[i - (dist + 1)];
                int maxTop = top.lastKey();

                if (outVal > maxTop) {
                    remove(rest, outVal);
                } else if (outVal < maxTop) {
                    remove(top, outVal);
                    topSize--;
                    currentSum -= outVal;
                } else {
                    if (rest.containsKey(outVal)) {
                        remove(rest, outVal);
                    } else {
                        remove(top, outVal);
                        topSize--;
                        currentSum -= outVal;
                    }
                }
            }

            while (topSize < target && !rest.isEmpty()) {
                int first = rest.firstKey();
                remove(rest, first);
                top.put(first, top.getOrDefault(first, 0) + 1);
                topSize++;
                currentSum += first;
            }

            if (topSize == target) {
                result = Math.min(result, currentSum);
            }
        }

        return baseCost + result;
    }

    private void remove(TreeMap<Integer, Integer> map, int val) {
        int count = map.get(val);
        if (count == 1) {
            map.remove(val);
        } else {
            map.put(val, count - 1);
        }
    }
}
