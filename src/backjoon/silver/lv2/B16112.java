package backjoon.silver.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B16112 {
    public static void main(String[] args) throws IOException {
        // 높은 수를 나중에 진행해야 많은 스톤을 활성화 시켜 높은 점수를 얻을수 있다
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 퀘스트 수
        int N = Integer.parseInt(st.nextToken());
        // 활성화 시킬수 있는 스톤의 수
        int K = Integer.parseInt(st.nextToken());

        long[] arr = new long[N];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st1.nextToken());
        }

        //오름차순
        Arrays.sort(arr);

        long max = 0;
        int getStone = 1;

        // 경험치는 활성화된 돌에 대해 + 되는 개념
        // 단, 주의할 점은 깬 다음에 활성 여부를 결정할 수 있는 것
        // 그래서 활성++가 뒤에 있는 것
        for (int i = 1; i < N; i++) {
            if (getStone < K) {
                max += arr[i] * getStone;
                getStone++;
            } else {
                max += arr[i] * getStone;
            }
        }

        System.out.println(max);
    }
}
