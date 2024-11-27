package backjoon.silver.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Sb 문자열 맨앞에 붙이는 방법, equels, 가장 뒷 문자 삭제
 * Map.of() 사용법
 * 리펙토링
 */
public class B27497 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Character> deque = new ArrayDeque<>(); // 앞뒤 삽입/삭제를 위한 Deque
        Stack<Integer> stack = new Stack<>(); // 명령 추적용 Stack

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());

            if (command == 1 || command == 2) {
                char ch = st.nextToken().charAt(0);
                handleInsert(deque, stack, ch, command);
            } else { // command == 3
                handleUndo(stack, deque);
            }
        }

        // 결과 출력
        printDeque(deque);
    }

    // 삽입 처리 메서드
    private static void handleInsert(Deque<Character> deque, Stack<Integer> stack, char ch, int command) {
        if (command == 1) {
            deque.addLast(ch); // 뒤에 추가
        } else {
            deque.addFirst(ch); // 앞에 추가
        }
        stack.push(command);
    }

    // 되돌리기 처리 메서드
    private static void handleUndo(Stack<Integer> stack, Deque<Character> deque) {
        if (!stack.isEmpty()) {
            int lastCommand = stack.pop(); // 마지막 명령 확인
            if (lastCommand == 1 && !deque.isEmpty()) {
                deque.pollLast(); // 뒤에서 삭제
            } else if (lastCommand == 2 && !deque.isEmpty()) {
                deque.pollFirst(); // 앞에서 삭제
            }
        }
    }

    // 출력 처리 메서드
    private static void printDeque(Deque<Character> deque) {
        if (deque.isEmpty()) {
            System.out.println(0);
        } else {
            StringBuilder sb = new StringBuilder();
            for (char ch : deque) {
                sb.append(ch);
            }
            System.out.println(sb);
        }
    }
}
