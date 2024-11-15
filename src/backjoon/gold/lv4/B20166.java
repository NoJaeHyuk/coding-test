package backjoon.gold.lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B20166 {
    static int [] dx = {-1,-1,0,1,1,1,0,-1}; // 상부터 시계방향
    static int [] dy = {0,1,1,1,0,-1,-1,-1};

    static int N;
    static int M;
    static int K;
    static String[][] array;

    static Map<String,Integer> kMap; // K의 대한 문자열 갯수 파악을 위해 사용
    static int MAX_LENGTH = 0; // DFS의 종료를 위한 최대 depth ( 문자열 길이 )

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        array = new String[N][M];

        for(int i = 0; i < N; i++){
            char[] t = br.readLine().toCharArray();
            for(int j = 0; j < M; j++){
                array[i][j] = String.valueOf(t[j]);
            }
        }

        kMap = new HashMap<>();
        String[] kArray = new String[K];

        for(int i = 0; i < K; i++){
            String key = br.readLine();
            MAX_LENGTH = Math.max(MAX_LENGTH,key.length());
            kMap.put(key,0);
            kArray[i] = key;
        }

        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                solve(i,j, 1, array[i][j]);
            }
        }

        StringBuilder sb = new StringBuilder();

        for(String key: kArray) {
            sb.append(kMap.get(key)).append("\n");
        }

        System.out.println(sb);
    }

    public static void solve(int x, int y, int depth, String result){
        if(kMap.containsKey(result)){
            kMap.put(result, kMap.get(result) + 1);
        }

        if(depth == MAX_LENGTH){
            return;
        }

        //좌표이동
        for(int i=0; i< dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0){
                nx = N-1;
            }
            else if(nx >= N){
                nx = 0;
            }

            if(ny < 0){
                ny = M-1;
            }
            else if(ny >= M){
                ny = 0;
            }

            solve(nx,ny, depth+1, result+array[nx][ny]);
        }
    }
}
