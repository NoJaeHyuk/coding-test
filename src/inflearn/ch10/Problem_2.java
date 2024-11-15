package inflearn.ch10;

import java.util.Scanner;

public class Problem_2 {

    static public class Main {
        static int[] dp;

        public static int solution(int n){
            dp = new int[n+2];

            dp[1] = 1;
            dp[2] = 2;

            for(int i = 3; i <= n+1; i++){
                dp[i] = dp[i-2] + dp[i-1];
            }

            return dp[n+1];
        }

        public static void main(String[] args){
            Scanner in=new Scanner(System.in);
            int n = in.nextInt();

            System.out.println(solution(n));
        }
    }
}
