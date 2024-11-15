package backjoon.silver.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B2161 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        StringBuilder result = new StringBuilder();
        while (queue.size() > 1) {  // 남은 카드가 하나일 때까지 반복
            result.append(queue.poll()).append(" ");
            queue.add(queue.poll()); // 두 번째 카드를 맨 뒤로 이동
        }
        result.append(queue.poll()); // 마지막 카드 추가
        System.out.println(result);
    }
}
