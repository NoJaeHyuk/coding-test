package backjoon.silver.lv4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.LinkedList;

/**
 * 연결리스트 활용
 */
public class B1158_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i + 1);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int index = 0;
        while (!list.isEmpty()) {
            // 원형 큐, 회전초밥 ...
            // 인덱스의 k번째를 더하되 인덱스이기 때문에 -1 처리
            // n값을 넘으면 안되니깐 n으로 나눈 나머지 값을 이용
            // 대신 remove가 들어가므로 줄어진 리스트 사이즈 값을 기준으로 함
            index = (index + k - 1) % n;
            sb.append(list.get(index));
            list.remove(index);

            if (!list.isEmpty()) {
                sb.append(", ");
            }
        }

        sb.append(">");
        System.out.println(sb);
    }

}


