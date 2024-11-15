package programmers.l0;

import java.util.Stack;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12906
 * 같은 숫자는 싫어
 */
public class P_12906 {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (stack.peek() != arr[i]) {
                stack.push(arr[i]);
            }
        }

        int[] answer = new int[stack.size()];

        for (int i = answer.length - 1; i >= 0; i--) {
            answer[i] = stack.pop();
        }

        return answer;
    }
}
