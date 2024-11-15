package inflearn.ch10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_5 {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] coin = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            int idx = Integer.parseInt(st.nextToken());
            coin[i] = idx;
        }

        int m = Integer.parseInt(br.readLine());
        dp = new int[m+1];

        System.out.println(solution(n,m,coin));
    }

    private static int solution(int n, int m, int[] coin) {
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        for(int i = 0; i < n; i++){
            for(int j = coin[i]; j <= m; j++){
                dp[j] = Math.min(dp[j], dp[j-coin[i]] + 1);
            }
        }

        return dp[m];
    }
}
