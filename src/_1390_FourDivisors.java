public class _1390_FourDivisors {

    // Copy and Paste in Solution Class in Leetcode


    public int findSumDivisor(int num){
        int divisor = 0;
        int sum = 0;
        for(int fact = 1; fact*fact <= num; fact++){
            if(num % fact == 0){
                int other = num/fact;

                if(other == fact){
                    divisor += 1;
                    sum += fact;
                } else{
                    divisor += 2;
                    sum += fact + other;
                }
            }
            if(divisor > 4){
                return 0;
            }
        }
        if(divisor == 4){
            return sum;
        } else{
            return 0;
        }
    }
    public int sumFourDivisors(int[] nums) {
        int result = 0;
        for(int num : nums){
            result += findSumDivisor(num);
        }
        return result;
    }
}
