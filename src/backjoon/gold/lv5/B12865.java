package backjoon.gold.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 평볌한 배낭
 */
public class B12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] dp = new int[m+1];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            int ps = Integer.parseInt(st.nextToken());
            int pt = Integer.parseInt(st.nextToken());

            for(int j = m; j >= ps; j--){
                dp[j] = Math.max(dp[j], dp[j-ps]+pt);
            }
        }

        System.out.println(dp[m]);
    }
}
