package backjoon.silver.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B6186 {
    // 전역 변수 선언
    private static Character[][] arr;
    private static boolean[][] visited;
    private static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    private static int[] dy = {0, 0, -1, 1}; // 상하좌우
    private static int R, C; // 행, 열 크기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new Character[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        int grassCount = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] == '#' && !visited[i][j]) {
                    dfs(i, j);
                    grassCount++;
                }
            }
        }

        System.out.println(grassCount);
    }

    // DFS 메서드
    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 배열 범위를 벗어나지 않고, 방문하지 않았으며, '#'인 경우
            if (nx >= 0 && nx < R && ny >= 0 && ny < C && arr[nx][ny] == '#' && !visited[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }
}
