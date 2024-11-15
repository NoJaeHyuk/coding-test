package inflearn.ch03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
4. 연속부분수열 (투포인터)
 */
public class Problem_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] array = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        solution(N, M, array);

    }

    public static void solution(int N, int M, int[] array){
        int start = 0;
        int sum = 0;
        int count = 0;

        for(int end = 0; end < N; end++){
            sum += array[end];
            if(sum == M){
                count++;
            }
            while (sum >= M){
                sum -= array[start++];
                if(sum == M){
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
