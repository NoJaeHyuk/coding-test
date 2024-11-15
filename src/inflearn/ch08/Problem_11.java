package inflearn.ch08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_11 {
    static int[] dx = {0,1,-1,0};
    static int[] dy = {1,0,0,-1};

    static int[][] arr;
    static int[][] cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[8][8];
        cnt = new int[8][8];
        StringTokenizer st;
        for(int i = 1; i <= 7; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= 7; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        BFS(1,1);

        if(cnt[7][7] == 0){
            System.out.println(-1);
        }else{
            System.out.println(cnt[7][7]);
        }
    }

    private static void BFS(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x,y));
        arr[1][1] = 1;

        while (!q.isEmpty()){
            Point cur = q.poll();

            for(int i = 0; i < dx.length; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 1 || ny < 1 || nx > 7 || ny > 7){
                    continue;
                }

                if(arr[nx][ny] != 1){
                    arr[nx][ny] = 1;
                    q.offer(new Point(nx,ny));
                    cnt[nx][ny] = cnt[cur.x][cur.y] + 1;
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
