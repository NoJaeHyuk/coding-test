package backjoon.bronze.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2445 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 1 ~ N 까지의 루프
        for (int i = 1; i <= n; i++) {
            printStar(n, i);
        }

        // n-1 ~ 1 까지의 루프
        for (int i = n - 1; i >= 1; i--) {
            printStar(n, i);
        }
    }

    private static void printStar(int n, int i) {
        StringBuilder sb = new StringBuilder();
        for (int j = 1; j <= (n * 2); j++) {
            if (j <= i || j > n * 2 - i) {
                sb.append("*");
            } else {
                sb.append(" ");
            }
        }
        System.out.println(sb);
    }

    /*
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(createLine(n, i)).append("\n");
        }

        for (int i = n - 1; i >= 1; i--) {
            sb.append(createLine(n, i)).append("\n");
        }

        System.out.print(sb);
    }

    private static String createLine(int n, int i) {
        String stars = "*".repeat(i);
        String spaces = " ".repeat(2 * (n - i));
        return stars + spaces + stars;
    }
    */
}
