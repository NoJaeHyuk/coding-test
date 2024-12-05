package backjoon.gold.lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class B13975 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            Queue<Long> queue = new PriorityQueue<>();
            for (int j = 0; j < n; j++) {
                queue.add(Long.parseLong(st.nextToken()));
            }

            long sum = 0;
            while (queue.size() > 1) {
                long sumInput = queue.poll() + queue.poll();
                sum += sumInput;
                queue.add(sumInput);
            }
            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }
}
