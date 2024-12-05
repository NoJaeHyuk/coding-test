package backjoon.silver.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (t --> 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] applicants = new int[n][2];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                applicants[i][0] = Integer.parseInt(st.nextToken());
                applicants[i][1] = Integer.parseInt(st.nextToken());
            }

            // 성적 기준 오름차순 정렬
            Arrays.sort(applicants, (a, b) -> a[0] - b[0]);
            int minInterviewScore = applicants[0][1]; // 기준이 될 면접 순위
            int count = 1; // 첫 번째 사람은 반드시 선발
            // 면접 성적 기준으로 선발
            for (int i = 1; i < n; i++) {
                if (applicants[i][1] < minInterviewScore) {
                    count++;
                    minInterviewScore = applicants[i][1];
                }
            }

            sb.append(count + "\n");
        }

        System.out.println(sb);
    }
}
