package backjoon.bronze.lv1;

import java.util.Scanner;

public class B24416 {
    static long dp[];
    static int c1 = 0;
    static int c2 = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        fib(n);

        dp = new long[n+1];

        dp[1] = 1;
        dp[2] = 1;

        fibonacci(n);

        System.out.println(c1+" "+c2);

    }

    public static long fib(int n){
        if(n == 1 || n == 2){
            c1++;
            return 1;
        }

        return fib(n-1) + fib(n-2);
    }

    public static long fibonacci(int n){

        for(int i=3; i<=n; i++){
            c2++;
            dp[i] = dp[i-2] + dp[i-1];
        }

        return dp[n];
    }
}
