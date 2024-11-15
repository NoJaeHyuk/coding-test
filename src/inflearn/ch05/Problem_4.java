package inflearn.ch05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
4. 후위식 연산
 */
public class Problem_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String n = br.readLine();

        solution(n);
    }

    public static void solution(String n){

        Stack<Integer> stack = new Stack<>();
        int count = 0;

        for(char c : n.toCharArray()){
            int f;
            int l;
            switch (c){
                case '+':
                    f = stack.pop();
                    l = stack.pop();

                    count = (l + f);

                    stack.add(count);

                    continue;
                case '-':
                    f = stack.pop();
                    l = stack.pop();

                    count = (l - f);

                    stack.add(count);
                    continue;
                case '*':
                    f = stack.pop();
                    l = stack.pop();

                    count = (l * f);

                    stack.add(count);
                    continue;
                case '/':
                    f = stack.pop();
                    l = stack.pop();

                    count = (l / f);

                    stack.add(count);
                    continue;
                default:
                    stack.add(c- '0');
            }
        }

        System.out.println(count);

    }
}
