package backjoon.bronze.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B31562 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] arr = br.readLine().split(" ", 3);
            String key = arr[2].substring(0, 5);

            if (map.containsKey(key)) {
                map.put(key, "?");
            } else {
                map.put(key, arr[1]);
            }
        }

        for (int j = 0; j < m; j++) {
            String query = br.readLine();
            if (map.containsKey(query)) {
                System.out.println(map.get(query));
            } else {
                System.out.println("!");
            }
        }
    }
}
