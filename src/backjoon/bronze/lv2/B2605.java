package backjoon.bronze.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B2605 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            list.add(i - input, i + 1);
        }

        for (Integer output : list) {
            System.out.print(output + " ");
        }
    }
}
