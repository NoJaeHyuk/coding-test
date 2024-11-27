package backjoon.bronze.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1524 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            br.readLine(); // 빈 줄 처리

            // N과 M 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            // 세준 병사들의 힘 입력
            PriorityQueue<Integer> sejun = new PriorityQueue<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                sejun.add(Integer.parseInt(st.nextToken()));
            }

            // 세비 병사들의 힘 입력
            PriorityQueue<Integer> sebi = new PriorityQueue<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                sebi.add(Integer.parseInt(st.nextToken()));
            }

            while (!sejun.isEmpty() && !sebi.isEmpty()) {
                if(sejun.peek() < sebi.peek()) {
                    sejun.poll();
                } else {
                    sebi.poll();
                }
            }

            if(sejun.isEmpty()){
                sb.append("B\n");
            } else{
                sb.append("S\n");
            }
        }

        System.out.print(sb);
    }
}
