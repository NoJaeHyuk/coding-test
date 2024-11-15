package inflearn.ch08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_10 {
    static int[] dx = {0,1,-1,0};
    static int[] dy = {1,0,0,-1};

    static int[][] arr;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[8][8];

        StringTokenizer st;

        for(int i = 1; i <= 7; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= 7; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        arr[1][1] = 1;
        DFS(1,1);

        System.out.println(cnt);
    }

    private static void DFS(int x, int y) {
        if(x == 7 && y == 7){
            cnt++;
        }else{
            for(int k = 0; k < dx.length; k++){
                int fx = x + dx[k];
                int fy = y + dy[k];

                if(fx < 1 || fy < 1 || fx > 7|| fy > 7){
                    continue;
                }

                if(arr[fx][fy] != 1){
                    //상하좌우를 다 확인하므로 이미 간곳은 1로 변경해줘야한다.
                    arr[fx][fy] = 1;
                    DFS(fx,fy);
                    //재귀가 끝난 후에는 1로 변경한 부분을 다시 원래대로 돌린다.
                    arr[fx][fy] = 0;
                }
            }
        }
    }


}
