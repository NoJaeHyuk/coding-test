package inflearn.ch06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        solution(n, array);
    }

    public static void solution(int n, int[] array){
        Arrays.sort(array);

        for(int i = 0; i < n-1; i++){
            if(array[i] == array[i+1]){
                System.out.println("D");
                return;
            }
        }

        System.out.println("U");
    }
}
