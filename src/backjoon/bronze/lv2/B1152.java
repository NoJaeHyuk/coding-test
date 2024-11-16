package backjoon.bronze.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1152 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /*
        String input = br.readLine().trim();

        if (input.isEmpty()) {
            System.out.println(0);
        } else {
            // split에서는 반드시 배열을 반환하기 때문에 1로 출력됩니다
            String[] words = input.split(" ");
            System.out.println(words.length);
        }
        */

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        System.out.println(st.countTokens());
    }
}
