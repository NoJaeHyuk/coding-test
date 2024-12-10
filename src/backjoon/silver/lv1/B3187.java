package backjoon.silver.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B3187 {
    static int R;
    static int C;
    static char[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        int totalSheep = 0;
        int totalWolf = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!visited[i][j] && (arr[i][j] == 'k' || arr[i][j] == 'v')) {
                    int[] result = dfs(i, j); // 탐색 결과 반환
                    if (result[0] > result[1]) { // 양 > 늑대
                        totalSheep += result[0];
                    } else {
                        totalWolf += result[1];
                    }
                }
            }
        }

        System.out.println(totalSheep + " " + totalWolf);
    }

    private static int[] dfs(int x, int y) {
        visited[x][y] = true;
        int sheepCount = 0;
        int wolfCount = 0;

        if (arr[x][y] == 'k') sheepCount++;
        if (arr[x][y] == 'v') wolfCount++;

        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < R && ny < C && !visited[nx][ny] && arr[nx][ny] != '#') {
                int[] result = dfs(nx, ny);
                sheepCount += result[0];
                wolfCount += result[1];
            }
        }

        return new int[]{sheepCount, wolfCount};
    }
}
