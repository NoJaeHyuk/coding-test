package backjoon.bronze.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B26041 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] words = br.readLine().split(" ");
        String target = br.readLine();

        int count = 0;

        for (String word : words) {
            if(!word.equals(target) && word.startsWith(target)) {
                count++;
            }
        }

        System.out.println(count);
    }
}
