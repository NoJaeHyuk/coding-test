package inflearn.ch08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_13 {
    static int[] dx = {0,1,-1,0,1,-1,-1,1};
    static int[] dy = {1,0,0,-1,1,-1,1,-1};

    static int[][] board;

    public static void main(String[] args) throws IOException {
        int answer = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        board = new int[n][n];

        StringTokenizer st;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 1){
                    answer++;
                    board[i][j] = 0;
                    BFS(i,j);
                }
            }
        }

        System.out.println(answer);
    }

    private static void BFS(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x,y));

        while (!q.isEmpty()){
            Point cur = q.poll();

            for(int i = 0; i < dx.length; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= board.length || ny >= board[0].length){
                    continue;
                }

                if(board[nx][ny] == 1){
                    board[nx][ny] = 0;
                    q.offer(new Point(nx,ny));
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
