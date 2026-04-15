public class _2515_ShortestDistanceTo_TargetStringIn_A_CircularArray {

    // Copy and paste the below code in your solution


    public int closestTarget(String[] elements, String goal, int beginPos) {
        int size = elements.length;
        int minSteps = Integer.MAX_VALUE;

        for (int idx = 0; idx < size; idx++) {
            if (elements[idx].equals(goal)) {
                int directDist = Math.abs(idx - beginPos);
                int wrapDist = size - directDist;
                int currentShortest = Math.min(directDist, wrapDist);
                minSteps = Math.min(minSteps, currentShortest);
            }
        }

        return minSteps == Integer.MAX_VALUE ? -1 : minSteps;
    }
}
