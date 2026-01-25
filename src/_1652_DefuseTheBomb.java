public class _1652_DefuseTheBomb {

// Copy and Paste it in Solution Class in Leetcode


    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] arr = new int[n];
        if (k == 0) return arr;
        for(int i = 0; i < code.length; i++){
            if(k < 0){
                for (int j = i - Math.abs(k); j < i; j++){
                    arr[i] += code[(j + n)%n];
                }
            }
            else if (k > 0){
                for (int j = i+1; j <= i+k; j++){
                    arr[i] += code[j%n];
                }
            }
        }
        return arr;
    }
}
