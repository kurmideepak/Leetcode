public class _728_SelfDividingNumbers {

    // Copy and Paste inside Solution Class in Leetcode

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ls = new ArrayList<>();
        for(int i = left; i <= right; i++){
            int num = i;
            boolean valid = true;
            while (num > 0){
                int digit = num%10;
                if(digit == 0 || i % digit != 0){
                    valid = false;
                    break;
                }
                num = num/10;
            }
            if(valid) ls.add(i);
        }

        return ls;
    }
}
