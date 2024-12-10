package backjoon.silver.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B24444 {
    static List<List<Integer>> adjList;
    static int[] order;
    static int cnt;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        adjList = new ArrayList<>();
        visited = new boolean[n + 1];
        order = new int[n + 1];
        cnt = 1;

        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st1.nextToken());
            int v = Integer.parseInt(st1.nextToken());

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        // 정점 번호를 오름차순으로 방문하기 위해 정렬
        for (int i = 1; i <= n; i++) {
            Collections.sort(adjList.get(i));
        }

        bfs(r);

        for (int i = 1; i <= n; i++) {
            System.out.println(order[i]);
        }
    }

    private static void bfs(int r) {
        visited[r] = true;
        order[r] = cnt++;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(r);

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int next : adjList.get(u)) {
                if (!visited[next]) {
                    visited[next] = true;
                    order[next] = cnt++;
                    queue.add(next);
                }
            }
        }
    }
}
