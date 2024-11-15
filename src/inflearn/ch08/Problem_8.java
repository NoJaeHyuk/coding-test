package inflearn.ch08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_8 {
    static int[][] dp = new int[12][12];
    static int[] chk,check,pm;
    static int n;
    static int f;
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer  st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        f = Integer.parseInt(st.nextToken());

        chk = new int[n];
        pm = new int[n];
        check = new int[n+1];

        for(int i = 0; i < n; i++){
            chk[i] = comi(n-1,i);
        }

        DFS(0,0);
    }

    private static void DFS(int L, int sum) {
        //찾으면 다음 재귀는 다 종료시켜야한다.
        if (flag) {
            return;
        }
        if(L == n){
            if(sum == f){
                for(int n : pm){
                    System.out.print(n + " ");
                    flag = true;
                }
            }
        }else{
            for(int i = 1; i <= n; i++){
                if(check[i] == 0){
                    check[i] = 1;
                    pm[L] = i;
                    DFS(L+1, sum + chk[L]*i);
                    check[i] = 0;
                }
            }

        }
    }

    private static int comi(int n, int r){
        if(dp[n][r] > 0){
            return dp[n][r];
        }
        if(r == 0 || n == r){
            return 1;
        }else {
            return dp[n][r] = comi(n-1,r-1) + comi(n-1,r);
        }
    }




}
