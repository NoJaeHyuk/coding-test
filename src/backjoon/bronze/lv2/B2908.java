package backjoon.bronze.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = br.readLine().split(" ");

        int reversedA = reverseNumber(numbers[0]);
        int reversedB = reverseNumber(numbers[1]);

        System.out.println(Math.max(reversedA, reversedB));
    }

    private static int reverseNumber(String number) {
        StringBuilder reversed = new StringBuilder(number).reverse();
        return Integer.parseInt(reversed.toString());
    }
}
