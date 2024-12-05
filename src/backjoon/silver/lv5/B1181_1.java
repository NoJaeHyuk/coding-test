package backjoon.silver.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1181_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // TreeSet을 사용해 중복 제거 및 정렬
        Set<String> set = new TreeSet<>((o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2); // 길이가 같으면 사전순 정렬
            }
            return o1.length() - o2.length(); // 길이 기준 정렬
        });

        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for (String word : set) {
            sb.append(word).append("\n");
        }
        System.out.println(sb);
    }
}
