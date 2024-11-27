package backjoon.silver.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class B1417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int dasom = Integer.parseInt(br.readLine());
        int count = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n - 1; i++) {
            int input = Integer.parseInt(br.readLine());
            queue.add(input);
        }

        while (!queue.isEmpty() && queue.peek() >= dasom) {
            ++dasom;
            queue.add(queue.poll() - 1);
            ++count;
        }

        System.out.println(count);
    }
}
