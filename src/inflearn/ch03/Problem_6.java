package inflearn.ch03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
최대 길이 연속부분수열 (복합적 문제)
 */
public class Problem_6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(st.nextToken());

        int[] array = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        solution(N,K,array);
    }

    public static void solution(int N, int K, int[] array){
        int start = 0;
        int kCnt = 0;
        int answer = 0;
        int MAX = 0;

        for(int end = 0; end < N; end++){
            if(array[end] == 1){
                answer++;
            }

            while (array[end] == 0 && kCnt == K){
                if(array[start] == 1){
                    answer--;
                    start++;
                }else {
                    answer--;
                    start++;
                    kCnt--;
                }
            }

            if (array[end] == 0) {
                if(kCnt != K){
                    answer++;
                    kCnt++;
                }
            }

            MAX = Math.max(answer,MAX);
        }

        System.out.println(MAX);
    }
}
