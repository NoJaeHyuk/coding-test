package inflearn.ch05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
2. 괄호문자제거
 */
public class Problem_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();

        solution(s1);
    }

    public static void solution(String s1){
        Stack<Character> stack = new Stack<>();

        StringBuilder result = new StringBuilder();

        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) == '('){
                stack.push(s1.charAt(i));
            }else if(s1.charAt(i) == ')'){
                stack.pop();
            }else{
                if(stack.size() == 0){
                    result.append(s1.charAt(i));
                }
            }
        }

        System.out.println(result);
    }
}
