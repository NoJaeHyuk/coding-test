package backjoon.silver.lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 큐를 활용
 */
public class B1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            queue.add(i + 1);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while (!queue.isEmpty()) {
            // 큐를 이용하여 원형 데이터를 유지하는 방법
            // 원하는 값 이외 값들은 다시 큐에 넣어줘야 한다.
            for (int i = 0; i < k -1; i++) {
                queue.add(queue.poll());
            }
            // 조건에 맞는 k번째 값
            sb.append(queue.poll());

            // 마지막을 제외한 나머지 (, ) 추가
            if (!queue.isEmpty()) {
                sb.append(", ");
            }
        }

        // 출력
        sb.append(">");
        System.out.println(sb);
    }
}
