package inflearn.ch06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] array = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        solution(n, c, array);
    }

    public static void solution(int n, int c, int[] array) {
        int answer = 0;
        Arrays.sort(array);
        int start = Arrays.stream(array).min().getAsInt();
        int end = Arrays.stream(array).max().getAsInt();

        while (end >= start){
            int mid = (end+start)/2;

            int cnt = 1;
            int ep = array[0];
            for(int i = 1; i < array.length; i++){
                if(array[i] - ep >= mid){
                    cnt++;
                    ep = array[i];
                }
            }

            //최대값을 구하는것
            if(cnt >= c){
                start = mid + 1;
                answer = mid;
            }else{
                end = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
