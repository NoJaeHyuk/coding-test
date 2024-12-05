package backjoon.bronze.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제해석
 * 입력값에 테스트 케이스가 주어지고 각 테스트 케이스 만큼 학교값과 마신 술의량이 주어진다.
 * 각 테스트 케이스마다 가장 술을 많이 마신 학교를 출력한다.
 * <p>
 * 문제풀이
 * 테스트 케이스는 T, T 내에서 학교의 숫자가 N
 * 학교이름, 술마실량을 입력 받는다.
 * 선택정렬 - 최댓값 갱신방법
 * - 술마신량의 최대값이 되면 학교의 값을 갱신하는 형태
 */
public class B11557_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            int maxCount = 0;
            String maxName = "";
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String schoolName = st.nextToken();// 학교명
                int alcoholCount = Integer.parseInt(st.nextToken()); // 마신 술량

                if (maxCount < alcoholCount) {
                    maxName = schoolName;
                    maxCount = alcoholCount;
                }
            }
            sb.append(maxName + "\n");
        }

        System.out.println(sb);
    }
}
