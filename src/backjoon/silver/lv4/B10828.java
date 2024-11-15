package backjoon.silver.lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B10828 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            String[] commands = br.readLine().split(" ");

            if (commands[0].equals("push")) {
                stack.push(Integer.valueOf(commands[1]));
            } else {
                stackPrint(commands[0], stack);
            }
        }
    }

    public static void stackPrint(String command, Stack<Integer> stack) {
        if (stack.empty()) {
            if (command.equals("pop") || command.equals("top")) {
                System.out.println(-1);
            } else if (command.equals("empty")) {
                System.out.println(1);
            }
            return;
        }

        switch (command) {
            case "pop":
                System.out.println(stack.pop());
                break;
            case "size":
                System.out.println(stack.size());
                break;
            case "empty":
                System.out.println(0);
                break;
            case "top":
                System.out.println(stack.peek());
                break;
        }
    }
}
