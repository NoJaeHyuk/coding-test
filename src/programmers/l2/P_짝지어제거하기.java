package programmers.l2;

import java.util.Stack;

public class P_짝지어제거하기 {
    public static void main(String[] args) {
        P_짝지어제거하기 p = new P_짝지어제거하기();

        p.solution("baabaa");
    }

    public int solution(String s)
    {
        int answer = 0;

        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(!stack.isEmpty() && stack.peek() == c){
                stack.pop();
            }else{
                stack.add(c);
            }
        }

        if(stack.isEmpty()){
            answer = 1;
        }

        return answer;
    }
}
