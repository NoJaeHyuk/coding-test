package fc.problem.ch04;

import java.util.Stack;

public class P2 {
    static class Solution {
        public String solution(String s){
            Stack<Character> stack = new Stack<>();

            for(char ch : s.toCharArray()){
                if(stack.isEmpty()){
                    stack.push(ch);
                }else{
                    if(ch == stack.peek()){
                        stack.pop();
                    }else{
                        stack.push(ch);
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            for(char x : stack) {
                sb.append(x);
            }

            return sb.toString();
        }

        public static void main(String[] args){
            Solution T = new Solution();
            System.out.println(T.solution("acbbcaa"));
            System.out.println(T.solution("bacccaba"));
            System.out.println(T.solution("aabaababbaa"));
            System.out.println(T.solution("bcaacccbaabccabbaa"));
            System.out.println(T.solution("cacaabbc"));
        }
    }

}
