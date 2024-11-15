package inflearn.ch08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_9 {
    static int n, m;
    static int[] chk;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        chk = new int[m];

        DFS(0, 1);
    }

    private static void DFS(int L, int s) {
        if(L == m){
            for(int x : chk) System.out.print(x + " ");
            System.out.println();
        }else{
            for(int i = s; i <= n; i++){
                chk[L] = i;
                DFS(L+1, i+1);
            }
        }
    }
}
