package inflearn.ch08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_12 {
    static int[] dx = {0,1,-1,0};
    static int[] dy = {1,0,0,-1};
    static Queue<Point> q = new LinkedList<>();
    static int[][] board;
    static int[][] dis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        dis = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                //BFS가 돌기전에 큐에 1의 값을 넣어준다.
                if(board[i][j] == 1){
                    q.offer(new Point(i,j));
                }
            }
        }

        BFS();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 0){
                    System.out.println("-1");
                    return;
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                answer = Math.max(answer, dis[i][j]);
            }
        }

        System.out.println(answer);
    }

    private static void BFS() {
        while (!q.isEmpty()){
            Point cur = q.poll();

            for(int i = 0; i < dx.length; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= board.length || ny >= board[0].length){
                    continue;
                }

                if(board[nx][ny] == 0){
                    board[nx][ny] = 1;
                    q.offer(new Point(nx,ny));
                    dis[nx][ny] = dis[cur.x][cur.y] + 1;
                }
            }
        }
    }

    static class Point{
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
