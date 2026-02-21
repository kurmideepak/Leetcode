public class _762_PrimeNumberOfSetBits_InBinaryRepresentation {

    // Copy and Paste in Solution Class in Leetcode

    public static boolean isPrime(int n){
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++){
            int set = Integer.bitCount(i);
            if(isPrime(set)){
                count++;
            }
        }
        return count;
    }
}
