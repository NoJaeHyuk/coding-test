package backjoon.silver.lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int lastElement = -1;  // 마지막으로 추가된 요소를 저장

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("push")) {
                lastElement = Integer.parseInt(st.nextToken());
                queue.add(lastElement);
            } else {
                queuePrint(command, queue, lastElement, sb);
            }
        }

        System.out.print(sb);  // 최종적으로 StringBuilder에 저장된 결과를 출력
    }

    public static void queuePrint(String command, Queue<Integer> queue, int lastElement, StringBuilder sb) {
        switch (command) {
            case "pop":
                if (queue.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(queue.poll()).append("\n");
                }
                break;
            case "size":
                sb.append(queue.size()).append("\n");
                break;
            case "empty":
                sb.append(queue.isEmpty() ? "1\n" : "0\n");
                break;
            case "front":
                if (queue.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(queue.peek()).append("\n");
                }
                break;
            case "back":
                if (queue.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(lastElement).append("\n");
                }
                break;
        }
    }
}
