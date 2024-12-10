package backjoon.silver.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B2644 {
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int targetA = Integer.parseInt(st.nextToken());
        int targetB = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st1.nextToken());
            int y = Integer.parseInt(st1.nextToken());

            list.get(x).add(y);
            list.get(y).add(x);
        }

        System.out.println(bfs(targetA, targetB));
    }

    private static int bfs(int start, int end) {
        visited[start] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});

        while (!queue.isEmpty()) {
            int[] inputs = queue.poll();
            int node = inputs[0];
            int count = inputs[1];

            if (node == end) {
                return count;
            }

            for (int neighbor : list.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(new int[]{neighbor, count + 1});
                }
            }
        }

        return -1;
    }
}
