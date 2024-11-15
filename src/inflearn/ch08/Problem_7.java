package inflearn.ch08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_7 {
    static int[][] dy = new int[35][35];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        DFS(n,r);

        System.out.println(dy[n][r]);
    }

    private static int DFS(int n, int r) {
        if(dy[n][r] != 0){
            return dy[n][r];
        }
        if(n == r || r == 0){
            return 1;
        }else{
            return dy[n][r] = DFS(n-1,r-1) + DFS(n-1,r);
        }

    }
}
