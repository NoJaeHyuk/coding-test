package inflearn.ch05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
1. 올바른 괄호
 */
public class Problem_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        solution(s1);
    }

    public static void solution(String s1) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) == '('){
                stack.push(s1.charAt(i));
            }else{
                if(stack.size() == 0){
                    System.out.println("NO");
                    return;
                }

                stack.pop();
            }
        }

        if(stack.size() == 0){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }

}
