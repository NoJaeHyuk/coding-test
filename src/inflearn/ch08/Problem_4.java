package inflearn.ch08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_4 {
    static int n,m;
    static int[] pm;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        pm = new int[m];

        DFS(0);
    }

    private static void DFS(int L) {
        if(L == m){
            for(int d : pm){
                System.out.print(d+" ");
            }
            System.out.println();
        }else{
            for(int i = 1; i <= n; i++){
                pm[L] = i;
                DFS(L+1);
            }
        }
    }
}
