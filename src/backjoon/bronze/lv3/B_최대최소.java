package backjoon.bronze.lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/10818
 * 배열문제
 */
public class B_최대최소 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        // 숫자의 개수만큼 정수 배열 생성
        int[] intNumbers = new int[n];
        int index = 0;

        // StringTokenizer를 사용하여 문자열을 정수로 변환
        while (st.hasMoreTokens()) {
            intNumbers[index++] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int num : intNumbers){
            if(min > num){
                min = num;
            }

            if(max < num){
                max = num;
            }
        }

        System.out.println(min + " " + max);
    }
}
