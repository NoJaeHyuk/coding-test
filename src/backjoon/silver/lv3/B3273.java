package backjoon.silver.lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] array = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int X = Integer.parseInt(br.readLine());

        solution(N, X, array);

    }

    public static void solution(int N, int X, int[] array) {
        int start = 0;
        int end = N-1;
        int count = 0;
        //정렬을 먼저 진행하자.
        //투포인터 사용은 정렬이 먼저이다.
        Arrays.sort(array);

        while (start < end){
            int sum = array[start] + array[end];
            if(sum == X){
                count++;
                end--;
                start++;
            }else if(sum > X){
                end--;
            }else {
                start++;
            }
        }

        System.out.println(count);
    }
}
