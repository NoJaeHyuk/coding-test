package backjoon.silver.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // Set을 사용해 중복 제거
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        // Set을 List로 변환
        List<String> list = new ArrayList<>(set);

        // 정렬: 길이 기준 → 길이가 같으면 사전순
        Collections.sort(list, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2); // 사전순 정렬
            }
            return o1.length() - o2.length(); // 길이 기준 정렬
        });

        // 출력
        StringBuilder sb = new StringBuilder();
        for (String word : list) {
            sb.append(word).append("\n");
        }
        System.out.println(sb);
    }
}
