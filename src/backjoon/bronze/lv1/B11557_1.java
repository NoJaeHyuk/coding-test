package backjoon.bronze.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 객체 이용
 */
public class B11557_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            List<School> schools = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String schoolName = st.nextToken();
                int alcoholCount = Integer.parseInt(st.nextToken());
                schools.add(new School(schoolName, alcoholCount));
            }

            Collections.sort(schools,(o1, o2) -> o2.getCount() - o1.getCount());
            System.out.println(schools.get(0).getName());
        }

        br.close();
    }

    private static class School {
        private String name;
        private int count;

        public School(String name, int count) {
            this.name = name;
            this.count = count;
        }

        public String getName() {
            return name;
        }

        public int getCount() {
            return count;
        }
    }
}
