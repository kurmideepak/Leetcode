public class _3047_FindThe_Largest_AreaOfSquare_InsideTwoRectangles {

    // Copy and Paste it in Solution Class in Leetcode


    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int n = bottomLeft.length;
        int maxSide = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                int intersectRightX = Math.min(topRight[i][0], topRight[j][0]);
                int intersectLeftX  = Math.max(bottomLeft[i][0], bottomLeft[j][0]);
                int width = intersectRightX - intersectLeftX;

                int intersectTopY = Math.min(topRight[i][1], topRight[j][1]);
                int intersectBottomY = Math.max(bottomLeft[i][1], bottomLeft[j][1]);
                int height = intersectTopY - intersectBottomY;

                if (width > 0 && height > 0) {
                    int side = Math.min(width, height);
                    maxSide = Math.max(maxSide, side);
                }
            }
        }

        return (long) maxSide * maxSide;
    }
}
