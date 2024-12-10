package backjoon.silver.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B18352 {
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

        distance[x] = 0;
        dfs(x, 0);

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

    private static void dfs(int x, int move) {
        if (move > k) { // 목표 거리를 초과하면 종료
            return;
        }

        for (Integer next : list.get(x)) {
            // 다음 도시까지의 거리가 더 짧은 경우만 갱신
            if (distance[next] > move + 1) {
                distance[next] = move + 1;
                dfs(next, move + 1);
            }
        }
    }
}
