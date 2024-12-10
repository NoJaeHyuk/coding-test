package backjoon.silver.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B18352_1 {
    static int k;
    static List<List<Integer>> list;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        distance = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
            distance[i] = Integer.MAX_VALUE; // 초기화
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
        }

        // BFS 시작
        bfs(x);

        // 결과 출력
        boolean found = false;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == k) {
                System.out.println(i);
                found = true;
            }
        }

        if (!found) {
            System.out.println(-1);
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        distance[start] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (Integer next : list.get(current)) {
                if (distance[next] == Integer.MAX_VALUE) { // 방문하지 않은 노드
                    distance[next] = distance[current] + 1;
                    queue.add(next);
                }
            }
        }
    }
}
