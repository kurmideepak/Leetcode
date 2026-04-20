public class _2078_TwoFurthestHousesWithDifferentColors {


    // Copy and paste the below code inside your solution class

    public int maxDistance(int[] colors) {
        int ans = 0;
        int n = colors.length;
        for(int i = 0; i < n; i++){
            if(colors[i] != colors[n-1]){
                ans = Math.max(ans, n-1-i);
                break;
            }
        }
        for(int i = n-1; i >= 0; i--){
            if(colors[i] != colors[0]){
                ans = Math.max(ans, i);
                break;
            }
        }
        return ans;
    }






}
