public class _2943_Maximize_AreaOf_Square_Hole_inGrid {


    // Copy and Paste it in Solution Class in Leetcode

        public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
            int maxH = getMaxGap(hBars);
            int maxV = getMaxGap(vBars);

            int side = Math.min(maxH, maxV);
            return side * side;
        }

        private int getMaxGap(int[] bars) {
            Arrays.sort(bars);

            int maxConsecutive = 1;
            int current = 1;

            for (int i = 1; i < bars.length; i++) {
                if (bars[i] == bars[i - 1] + 1) {
                    current++;
                } else {
                    current = 1;
                }
                maxConsecutive = Math.max(maxConsecutive, current);
            }

            return maxConsecutive + 1;
        }
}
