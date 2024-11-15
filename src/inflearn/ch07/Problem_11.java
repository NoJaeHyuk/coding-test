package inflearn.ch07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_11 {
    static int[] ch;
    static int answer = 0;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] array = new int[n+1][n+1];
        ch = new int[n+1];
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            array[row][col] = 1;
        }

        ch[1] = 1;
        DFS(1,array);
        System.out.println(answer);
    }

    private static void DFS(int idx, int[][] array) {
        if(idx == n){
            answer++;
            return;
        }else{
            for(int i=1; i < array.length; i++){
                if(array[idx][i] != 0 && ch[i] != 1){
                    ch[i] = 1;
                    DFS(i,array);
                    ch[i] = 0;
                }
            }
        }
    }

}
