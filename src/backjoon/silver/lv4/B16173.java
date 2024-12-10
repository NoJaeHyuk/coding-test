package backjoon.silver.lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B16173 {
    private static int N;
    private static int[][] arr;
    private static boolean[][] visited;
    private static int[] dx = {1, 0}; // 아래, 오른쪽
    private static int[] dy = {0, 1}; // 아래, 오른쪽

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println("Hing");
    }

    private static void dfs(int x, int y) {
        if (arr[x][y] == -1) {
            System.out.println("HaruHaru");
            System.exit(0);
        }

        for (int i = 0; i < 2; i++) {
            int nx = x + arr[x][y] * dx[i];
            int ny = y + arr[x][y] * dy[i];

            if (nx >= N || ny >= N || visited[nx][ny]) continue;

            visited[x][y] = true;
            dfs(nx, ny);
        }
    }
}
