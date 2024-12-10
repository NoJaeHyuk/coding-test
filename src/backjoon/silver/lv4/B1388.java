package backjoon.silver.lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1388 {
    private static int n, m;
    private static char[][] arr;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, arr[i][j]);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    private static void dfs(int x, int y, char direction) {
        visited[x][y] = true;

        int nx = x;
        int ny = y;

        // 방향에 따라 이동
        if (direction == '-') {
            ny = y + 1;
        } else if (direction == '|') {
            nx = x + 1;
        }

        // 범위 체크 및 재귀 호출
        if (nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] == direction && !visited[nx][ny]) {
            dfs(nx, ny, direction);
        }
    }
}
