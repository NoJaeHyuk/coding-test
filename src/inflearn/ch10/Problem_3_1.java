package inflearn.ch10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_3_1 {
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
            int answer = 0;

            dp = new int[n];
            dp[0] = 1;
            for(int i = 1; i < n; i++){
                int max = 0;
                for(int j = i-1; j >=0; j--){
                    if(array[j] < array[i] && dp[j] > max){
                        max = dp[j];
                    }
                }
                dp[i] = max + 1;
                answer = Math.max(answer, dp[i]);
            }

            return answer;
        }
    }

}
