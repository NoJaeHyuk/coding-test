package backjoon.silver.lv3;

import java.util.Scanner;

public class B_행성x3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] residentNames = new int[n];
        for (int i = 0; i < n; i++) {
            residentNames[i] = scanner.nextInt();
        }

        long result = 0;

        // 각 비트 위치별로 계산
        for (int bit = 0; bit < 20; bit++) { // 최대 20비트 (1000000 < 2^20)
            long count1 = 0;
            long count0 = 0;

            for (int i = 0; i < n; i++) {
                if ((residentNames[i] & (1 << bit)) != 0) {
                    count1++;
                } else {
                    count0++;
                }
            }

            result += count1 * count0 * (1L << bit);
        }

        System.out.println(result);
    }
}
