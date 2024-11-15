package backjoon.bronze.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int sum = 0;
        for (String input : inputs) {
            int num = Integer.parseInt(input);
            sum += num * num;  // 제곱을 더하기
        }

        System.out.println(sum % 10);
    }
}
