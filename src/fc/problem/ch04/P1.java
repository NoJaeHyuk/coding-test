package fc.problem.ch04;

import java.util.Stack;

public class P1 {
    static class Solution {
        public String solution(String str){
            Stack<Character> stack = new Stack<>();

            StringBuilder sb = new StringBuilder();

            for(char ch : str.toCharArray()){
                if(ch == '('){
                    stack.push(ch);
                } else if (ch == ')') {
                    if(!stack.isEmpty()){
                        stack.pop();
                    }
                } else{
                    if(stack.isEmpty()){
                        sb.append(ch);
                    }
                }
            }

            return sb.toString();
        }

        public static void main(String[] args){
            Solution T = new Solution();
            System.out.println(T.solution("(A(BC)D)EF(G(H)(IJ)K)LM(N)"));
        }
    }
}
