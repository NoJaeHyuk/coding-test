package inflearn.ch10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_3 {
    static public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(br.readLine());

            int[] array = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i = 0; i < n; i++){
                array[i] = Integer.parseInt(st.nextToken());
            }

            System.out.println(solution(n, array));
        }

        static int[] dp;
        private static int solution(int n, int[] array) {
            dp = new int[n+1];
            for(int i = 0; i < n; i++){
                dp[i] = 1;
                for(int j = 0; j < n; j++){
                    if(array[j] < array[i]){
                        dp[i] = Math.max(dp[i], dp[j]+1);
                    }
                }
            }

            return Arrays.stream(dp).max().getAsInt();
        }
    }
}
