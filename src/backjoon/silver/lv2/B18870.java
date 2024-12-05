package backjoon.silver.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = Integer.parseInt(st.nextToken());
        }

        int[] sorted = x.clone();
        Arrays.sort(sorted);

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int num : sorted) {
            if (!map.containsKey(num)) {
                map.put(num, count);
                count++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : x) {
            sb.append(map.get(num)).append(" ");
        }

        System.out.println(sb);
    }
}
