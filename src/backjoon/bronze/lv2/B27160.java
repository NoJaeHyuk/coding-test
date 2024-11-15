package backjoon.bronze.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class B27160 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> countMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] parts = br.readLine().split(" ");
            countMap.put(parts[0], Integer.valueOf(countMap.getOrDefault(parts[0], 0)) + Integer.parseInt(parts[1]));
        }

        for (Integer value : countMap.values()) {
            if(value == 5) {
                System.out.printf("YES");
                return;
            }
        }

        System.out.printf("NO");
    }
}
