package backjoon.silver.lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15649 {
    static int n;
    static int m;
    static boolean[] count;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        count = new boolean[n];

        solve(0);
    }

    public static void solve(int depth){
        if(depth == m){
            for (int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }

        for(int j = 0; j < n; j++){
            if(!count[j]){
                count[j] = true;
                arr[depth] = j+1;
                solve(depth+1);
                count[j] = false;
            }
        }

    }
}
