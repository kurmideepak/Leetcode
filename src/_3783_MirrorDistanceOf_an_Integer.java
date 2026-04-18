public class _3783_MirrorDistanceOf_an_Integer {

    // Copy and paste the below code inside your solution class

    public int mirrorDistance(int n) {
        int reversed = 0;
        for (int temp = n; temp > 0; temp /= 10) {
            reversed = reversed * 10 + (temp % 10);
        }
        return Math.abs(n - reversed);
    }




}
