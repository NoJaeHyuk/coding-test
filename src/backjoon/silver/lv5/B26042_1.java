package backjoon.silver.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B26042_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        int findStdunt = Integer.MAX_VALUE;
        int maxCount = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());

            if (command == 1) {
                int studentNumber = Integer.parseInt(st.nextToken());
                queue.add(studentNumber);
                if (maxCount < queue.size() || (maxCount == queue.size() && studentNumber < findStdunt)) {
                    findStdunt = studentNumber;
                    maxCount = queue.size();
                }
            } else {
                queue.poll();
            }
        }

        System.out.println(maxCount + " " + findStdunt);
    }
}
