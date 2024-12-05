package backjoon.bronze.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 선형탐색 이용한 방법
 */
public class B11557 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            int maxAlcohol = 0;
            String maxSchool = "";

            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String schoolName = st.nextToken();
                int alcoholCount = Integer.parseInt(st.nextToken());

                if (alcoholCount > maxAlcohol) {
                    maxAlcohol = alcoholCount;
                    maxSchool = schoolName;
                }
            }

            System.out.println(maxSchool);
        }

        br.close();
    }

}
