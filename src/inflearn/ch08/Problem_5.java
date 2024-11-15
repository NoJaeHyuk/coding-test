package inflearn.ch08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Problem_5 {
    static int n;
    static int m;
    static int MIN = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        Integer[] arr = new Integer[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());

        Arrays.sort(arr, Collections.reverseOrder());

        solution(n, arr);

        System.out.println(MIN);
    }

    private static void solution(int n, Integer[] arr) {
        DFS(0,0,arr);
    }

    private static void DFS(int i, int sum, Integer[] arr) {
        if(sum > m){
            return;
        }
        if(i >= MIN){
            return;
        }
        if(sum == m){
            MIN = Math.min(i,MIN);
        }else{
            for(int j = 0; j < arr.length; j++){
                DFS(i+1, sum + arr[j], arr);
            }
        }
    }


}
