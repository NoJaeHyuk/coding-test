package backjoon.bronze.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int repeatCount = Integer.parseInt(st.nextToken());
            String inputString = st.nextToken();

            for(char ch : inputString.toCharArray()) {
                result.append(String.valueOf(ch).repeat(repeatCount));
            }
            result.append("\n");
        }

        System.out.println(result);
    }
}
