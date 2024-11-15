package inflearn.ch03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
5. 연속된 자연수의 합(투 포인터)
 */
public class Problem_5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] array = new int[N];

        for(int i = 0; i < N; i++){
            array[i] = i+1;
        }

        solution(N,array);
    }

    public static void solution(int N, int[] array){
        int start = 0;
        int end = 0;
        int sum = 0;
        int count = 0;

        while (end < N-1){
            sum += array[end++];
            if(sum == N){
                count++;
            }
            while (sum >= N){
                sum -= array[start++];
                if(sum == N){
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
