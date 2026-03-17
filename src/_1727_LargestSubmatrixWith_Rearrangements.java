public class _1727_LargestSubmatrixWith_Rearrangements {

    // Copy and Paste inside Solution Class in Leetcode


    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] height = new int[n];
        int max = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 1){
                    height[j] += 1;
                } else{
                    height[j] = 0;
                }
            }
            int[] sorted = height.clone();
            Arrays.sort(sorted);
            for(int j = 0; j < n; j++){
                int h = sorted[n-1-j];
                int w = j+1;
                max = Math.max(max, h*w);
            }
        }
        return max;
    }
}
