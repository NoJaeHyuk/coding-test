package backjoon.bronze.lv2;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B15829 {
    public static final int BASE = 31;
    public static final int MOV = 1234567891;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String L = br.readLine();
        String text = br.readLine();

        long sum = 0;
        long power = 1;
        for (char ch : text.toCharArray()) {
            int number = (int)ch - 96;
            sum = (sum + number * power) % MOV;
            power = (power * BASE) % MOV;
        }

        System.out.println(sum);
    }
}
