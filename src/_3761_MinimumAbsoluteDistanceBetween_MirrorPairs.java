public class _3761_MinimumAbsoluteDistanceBetween_MirrorPairs {

    // Copy and paste the below code in your solution


    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> lastSeen = new HashMap<>(nums.length);
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];

            if (lastSeen.containsKey(current)) {
                int dist = i - lastSeen.get(current);
                if (dist < minDistance) {
                    minDistance = dist;
                }
            }

            int rev = 0;
            int temp = current;
            while (temp > 0) {
                rev = rev * 10 + temp % 10;
                temp /= 10;
            }

            lastSeen.put(rev, i);
        }

        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }









}
