package inflearn.ch06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
1. 선택 정렬
 */
public class Problem_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] array = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        solution(n, array);
    }

    public static void solution(int n, int[] array){
        for(int i = 0; i < n; i++){
            int min = i;
            for(int j = i+1; j < n; j ++){
                if(array[j] < array[min]){
                    min = j;
                }
            }
            //swap
            if(array[min] < array[i]){
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }

        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }

    }
}
