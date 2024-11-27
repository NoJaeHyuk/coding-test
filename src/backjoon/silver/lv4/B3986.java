package backjoon.silver.lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 스택을 이용한 문제
 * 문제에 대한 이해가 필요
 * 스택이 빈 경우에만 좋은 단어로 판명
 */
public class B3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < n; i++) {
            String word = br.readLine();

            Stack<Character> stack = new Stack<>();
            for (char ch : word.toCharArray()) {
                if (stack.isEmpty() || stack.peek() != ch) {
                    stack.push(ch);
                    continue;
                }
                stack.pop();
            }

            if (isGoodWord(stack)) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static boolean isGoodWord(Stack<Character> stack) {
        return stack.isEmpty();
    }
}
