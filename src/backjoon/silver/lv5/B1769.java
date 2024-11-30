package backjoon.silver.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1769 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String x = br.readLine();
        int transform = 0;

        while (x.length() > 1) {
            int sum = 0;
            transform++;
            for (char ch : x.toCharArray()) {
                sum += ch - '0';
            }
            x = String.valueOf(sum);
        }

        System.out.println(transform);
        if (Integer.parseInt(x) % 3 == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
