package backjoon.gold.lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
2636 치즈문제
 */
public class B2636 {
    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;
    static int N;
    static int M;
    static int[][] array;
    static int cheese, time, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        array = new int[N][M];
        cheese = 0;
        time = 0;
        cnt = 0;

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
                if(array[i][j] == 1){
                    cheese++;
                }
            }
        }

        while (cheese != 0) {
            time++;
            cnt = cheese;
            bfs(0,0);
        }

        System.out.println(time);
        System.out.println(cnt);
    }

    //치즈가 다 떨어질때 까지 돌아야하나?
    public static void bfs(int idx1, int idx2){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{idx1,idx2});
        visited = new boolean[N][M];
        visited[idx1][idx2] = true;

        //C치즈 찾기
        while (!queue.isEmpty()){
            int[] current = queue.poll();

            //방향 탐색
            for(int i = 0; i < dx.length; i ++){
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                //방문한적 없는 곳만 가야 시간 별 체크 가능
                if(nx >= 0 && ny >= 0 && nx < N && ny < M && visited[nx][ny] == false) {
                    visited[nx][ny] = true;
                    if(array[nx][ny] == 0) {
                        queue.add(new int[] {nx, ny});
                    } else {
                        cheese--;
                        array[nx][ny] = 0;
                    }
                }
            }
        }
    }
}
