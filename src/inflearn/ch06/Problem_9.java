package inflearn.ch06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_9 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] array = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        solution(n, m, array);
    }

    public static void solution(int n, int m, int[] array) {
        int start = Arrays.stream(array).max().getAsInt();
        int end = Arrays.stream(array).sum();
        int answer = 0;

        while (end-start >= 0){
            int cnt = 1;
            int sum = 0;
            int mid = (start+end)/2;
            for (int i = 0; i < n; i++) {
                sum += array[i];
                if(sum > mid){
                    cnt++;
                    sum = array[i];
                }
            }

            if(cnt <= m){
                answer = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        System.out.println(answer);

    }
}
