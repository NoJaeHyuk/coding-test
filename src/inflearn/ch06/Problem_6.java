package inflearn.ch06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
장난꾸러기
 */
public class Problem_6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        solution(n,array);
    }

    public static void solution(int n, int[] array){
        int[] temp = array.clone();

        Arrays.sort(temp);

        for(int i = 0; i < n; i ++){
            if(temp[i] != array[i]){
                System.out.print((i+1) + " ");
            }
        }
    }
}
