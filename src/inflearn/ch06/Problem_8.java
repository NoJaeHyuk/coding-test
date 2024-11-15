package inflearn.ch06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] array = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        solution(n,m,array);
    }

    public static void solution(int n, int m, int[] array){
        int start = 0;
        int end  = n-1;
        int mid = (start+end)/2;

        Arrays.sort(array);

        while (end-start >= 0){
            if(array[mid] == m){
                System.out.println(mid+1);
                return;
            } else if (array[mid] < m) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = (start+end)/2;
        }
    }
}
