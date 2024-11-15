package backjoon.silver.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B21318 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        int[] array_sum = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int mistake = 0;
        for (int i = 0; i < N - 1; i++) {
            if(array[i] > array[i+1]) {
                mistake++;
            }
            array_sum[i+1] = mistake;
        }

        int Q = Integer.parseInt(br.readLine());
        int start;
        int end;
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < Q; j++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken()) - 1;
            end = Integer.parseInt(st.nextToken()) - 1;
            sb.append(array_sum[end] - array_sum[start] + "\n");
        }

        System.out.println(sb.toString());
    }
}
