package inflearn.ch03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
3. 최대매출 - 슬라이딩 윈도우
 */
public class Problem_3 {
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
        ArrayList<Integer> arrayList = new ArrayList<>();

        int Max = Integer.MIN_VALUE;
        int sum = 0;

        //우선 K 만큼 더해준다.
        for (int i = 0; i < K; i++){
            sum += array[i];
            Max = Math.max(sum,Max);
        }

        for(int j = K; j < N; j++){
            sum += (array[j] - array[j-K]);
            Max = Math.max(sum,Max);
        }

        /*
        for(int i = 0;  i < (N-K); i++){
            int sum = 0;
            for(int j = i;  j < (i+K); j++){
                sum += array[j];
            }
            Max = Math.max(sum,Max);
        }
        */

        System.out.println(Max);
    }
}
