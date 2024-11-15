package inflearn.ch08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1 {
    static int total = 0;
    static boolean flag = true;
    static String answer = "NO";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] array = new int[n];

        for(int i = 0; i < array.length; i++){
            array[i] = Integer.parseInt(st.nextToken());
            total += array[i];
        }

        solution(n, array);

        System.out.println(answer);
    }

    public static void solution(int n, int[] array){
        DFS(0,0, n, array);
    }

    private static void DFS(int i, int sum, int n, int[] array) {
        if(!flag){
            return;
        }
        if(i == n){
            if((total - sum) == sum){
                answer = "YES";
                flag = false;
            }
        }else {
            DFS(i+1, sum + array[i], n, array);
            DFS(i+1, sum, n, array);
        }
    }


}
