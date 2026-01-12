public class _1266_Minimum_Time_VisitingAllTime {

// Copy and Paste it in Solution Class in Leetcode

    public int minTimeToVisitAllPoints(int[][] points) {
        int time = 0;
        for (int i = 1; i < points.length; i++) {
            int dx = points[i][0] - points[i - 1][0];
            int dy = points[i][1] - points[i - 1][1];

            if (dx < 0) dx = -dx;
            if (dy < 0) dy = -dy;

            time += dx > dy ? dx : dy;
        }
        return time;
    }
}
