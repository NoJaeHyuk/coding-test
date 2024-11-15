package backjoon.bronze.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class B25593 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                String[] days = br.readLine().split(" ",7);
                if (j == 0 || j == 2) {
                    for (String str : days) {
                        if (!str.equals("-")) {
                            map.put(str, map.getOrDefault(str, 0) + 4);
                        }
                    }
                } else if (j == 1) {
                    for (String str : days) {
                        if (!str.equals("-")) {
                            map.put(str, map.getOrDefault(str, 0) + 6);
                        }
                    }
                } else {
                    for (String str : days) {
                        if (!str.equals("-")) {
                            map.put(str, map.getOrDefault(str, 0) + 10);
                        }
                    }
                }
            }
        }

        if (map.isEmpty()) {
            System.out.println("Yes");
            return;
        }

        // 최대값 구하기
        Map.Entry<String, Integer> maxEntry = Collections.max(map.entrySet(), Map.Entry.comparingByValue());
        // 최소값 구하기
        Map.Entry<String, Integer> minEntry = Collections.min(map.entrySet(), Map.Entry.comparingByValue());

        if (maxEntry.getValue() - minEntry.getValue() > 12) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
    }
}
