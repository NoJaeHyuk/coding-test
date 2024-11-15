package backjoon.bronze.lv1;

import java.util.Scanner;

/*
피보나치 수2
 */
public class B2748 {

    static long[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        dp = new long[n+1];

        for(int i=0; i<=n; i++){
            dp[i] = -1;
        }

        dp[0] = 0;
        dp[1] = 1;

        System.out.println(topDown(n));
    }

    public static long topDown(int n){
        if(dp[n] == -1) {
            dp[n] = topDown(n - 1) + topDown(n - 2);
        }
        return dp[n];
    }
}
