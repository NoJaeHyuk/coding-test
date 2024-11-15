package backjoon.bronze.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class B9933 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        String result = null;

        for (int i = 0; i < n; i++) {
            String text = br.readLine();
            String reverseText = new StringBuilder(text).reverse().toString();

            // Check if the string is a palindrome
            if (text.equals(reverseText)) {
                result = text.length() + " " + text.charAt(text.length() / 2);
                break;
            }

            // Check if the reverse of the string has been seen before
            if (map.containsKey(reverseText)) {
                result = text.length() + " " + text.charAt(text.length() / 2);
                break;
            }

            map.put(text, map.getOrDefault(text, 0) + 1);
        }

        // Print the result if found
        if (result != null) {
            System.out.println(result);
        }
    }
}
