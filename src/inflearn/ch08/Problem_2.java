package inflearn.ch08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_2 {
    static int MAX = Integer.MIN_VALUE;
    static int c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        solution(c,n,arr);

        System.out.println(MAX);
    }

    private static void solution(int c, int n, int[] arr) {

        DFS(0,0,n,arr);

    }

    private static void DFS(int idx, int sum, int n, int[] arr) {
        if(sum > c){
            return;
        }
        if(idx == n){
            MAX = Math.max(sum, MAX);
        }else{
            DFS(idx+1, sum + arr[idx], n, arr);
            DFS(idx+1, sum, n, arr);
        }
    }


}
