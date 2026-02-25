package DynamicProgramming;
import java.util.Arrays;
import java.util.Scanner;
public class friendPairingProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of friends: ");
        int num = sc.nextInt();
        int[] dp = new int[num+1];
        Arrays.fill(dp, -1);
        //System.out.println(pair(num, dp));

        System.out.println(friend(num));
    }

    private static int friend(int num){
        int[] dp = new int[num + 1];
        dp[1] = 1;
        if(num > 1) dp[2] = 2;
        for(int i = 3; i <= num; i++){
            dp[i] = dp[i-1] + (i-1) * dp[i - 2];
        }
        return dp[num];
    }
    private static int  pair(int num, int[] dp) {
        if(num <= 2) return num;
        if(dp[num] != -1) return dp[num];
        return dp[num] = pair(num-1, dp) + (num-1) * pair(num-2, dp);
    }
}
