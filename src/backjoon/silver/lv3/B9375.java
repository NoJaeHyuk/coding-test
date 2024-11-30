package backjoon.silver.lv3;

import java.io.*;
import java.util.*;

public class B9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine()); // 의상 수
            Map<String, Integer> clothing = new HashMap<>();

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken(); // 의상 이름은 필요 없음
                String type = st.nextToken();
                clothing.put(type, clothing.getOrDefault(type, 0) + 1);
            }

            int result = 1;
            for (int count : clothing.values()) {
                result *= (count + 1); // 해당 종류의 경우의 수를 곱함
            }

            sb.append(result - 1).append("\n"); // 아무것도 착용하지 않는 경우 제외
        }

        System.out.print(sb);
    }
}
