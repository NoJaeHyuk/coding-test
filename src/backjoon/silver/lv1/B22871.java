package backjoon.silver.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B22871 {
    static int[] array;
    static int N;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        array = new int[N+1];
        dp = new long[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1; i<=N; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        //구할수 있는 기본값 미리 세팅
        dp[1] = 0;
        dp[2] = (1+ Math.abs(array[1]-array[2]));

        solve(N);

        System.out.println(dp[N]);
    }

    /*
    idx -> N
     */
    public static void solve(int idx){
        //1,2 값은 미리 선언했으니 3부터 시작
        for(int i=3; i<=idx; i++){
            long temp = Long.MAX_VALUE;
            for (int j=1; j<i; j++){
                long power = (long)(i-j)*(1+Math.abs(array[j]-array[i]));
                power = Math.max(power,dp[j]);
                temp = Math.min(temp,power);
            }

            dp[i] = temp;
        }
    }
}
