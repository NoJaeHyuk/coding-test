package backjoon.silver.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B7562 {
    static int[][] directions = {
            {-2, -1}, {-1, -2}, {1, -2}, {2, -1},
            {2, 1}, {1, 2}, {-1, 2}, {-2, 1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int x = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            Queue<int[]> queue = new LinkedList<>();
            boolean[][] visited = new boolean[x][x];
            queue.add(new int[]{x1, y1, 0});
            visited[x1][y1] = true;

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int row = current[0], col = current[1], move = current[2];

                if (row == x2 && col == y2) {
                    sb.append(move).append("\n");
                    break;
                }

                for (int[] direction : directions) {
                    int nx = row + direction[0];
                    int ny = col + direction[1];

                    if (nx >= 0 && ny >= 0 && nx < x && ny < x && !visited[nx][ny]) {
                        queue.add(new int[]{nx, ny, move + 1});
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        System.out.println(sb);
    }
}
