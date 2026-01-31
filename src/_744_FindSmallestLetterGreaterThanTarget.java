public class _744_FindSmallestLetterGreaterThanTarget {

    // Copy and Paste it in Solution Class in Leetcode


    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int l = 0;
        int r = n-1;
        int pos = -1;
        while (l <= r){
            int mid = l + (r-l)/2;
            if(letters[mid] > target){
                pos = mid;
                r = mid-1;
            } else{
                l = mid+1;
            }
        }
        if(pos == -1){
            return letters[0];
        }
        return letters[pos];
    }
}
