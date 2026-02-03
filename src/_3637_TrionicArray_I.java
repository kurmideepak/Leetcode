public class _3637_TrionicArray_I {

    // Copy and Paste it in Solution Class in Leetcode

    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        int i = 0;
        while(i < n-1 && nums[i] < nums[i+1]){
            i++;
        }
        if (i == 0 || i == n-1) return false;
        while(i < n-1 && nums[i] > nums[i+1]){
            i++;
        }
        if(i == n-1) return false;
        while(i < n-1 && nums[i] < nums[i+1]){
            i++;
        }

        if(i == n-1){
            return true;
        } else{
            return false;
        }
    }
}
