public class _1980_FindUniqueBinaryString {

    // Copy and Paste inside Solution Class in Leetcode


    public String findDifferentBinaryString(String[] nums) {
        int length = nums.length;
        String result = "";
        for(int i = 0; i < length; i++){
            char ch = nums[i].charAt(i);
            if(ch == '0'){
                result += "1";
            } else{
                result += "0";
            }
        }
        return result;
    }
}
