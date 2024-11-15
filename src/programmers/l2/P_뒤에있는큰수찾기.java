package programmers.l2;

import java.util.Stack;

public class P_뒤에있는큰수찾기 {
    public static void main(String[] args) {
        P_뒤에있는큰수찾기 p = new P_뒤에있는큰수찾기();
        p.solution(new int[]{2,3,4,5});
    }

    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        Stack<Integer> stack = new Stack<>();
        //뒤로 가서 체크
        for(int i = numbers.length-1; i >= 0; i--){
            if(i == numbers.length-1){
                answer[i] = -1;
            }
            int cur = numbers[i];
            while (!stack.isEmpty()){
                if(cur < stack.peek()){
                    answer[i] = stack.peek();
                    break;
                }
                stack.pop();
            }

            if(stack.isEmpty()){
                answer[i] = -1;
            }

            stack.push(cur);
        }

        return answer;
    }
}
