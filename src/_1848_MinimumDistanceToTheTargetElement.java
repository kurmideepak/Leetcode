public class _1848_MinimumDistanceToTheTargetElement {

    // Copy and Paste in Solution Class in Leetcode


    public int getMinDistance(int[] nums, int target, int start) {
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                ans = Math.min(Math.abs(i - start), ans);
            }
        }
        return ans;
    }
}
