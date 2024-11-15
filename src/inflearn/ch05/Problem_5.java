package inflearn.ch05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
/*
5. 쇠막대기
 */
public class Problem_5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String n = br.readLine();

        solution(n);
    }

    public static void solution(String n){
        Stack<Character> stack = new Stack<>();
        int count = 0;

        for(int i = 0; i < n.length(); i++){
            char c1 = n.charAt(i);
            if(c1 == '('){
                stack.push(c1);
            }else{
                //인접일 경우
                if(n.charAt(i-1) == '('){
                    stack.pop();
                    count += stack.size();
                }else{
                    stack.pop();
                    count += 1;
                }
            }
        }

        System.out.println(count);
    }
}
