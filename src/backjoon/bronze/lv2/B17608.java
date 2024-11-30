package backjoon.bronze.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B17608 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack.add(Integer.parseInt(br.readLine()));
        }

        int visibleCount = 1;
        int tallestBar = stack.pop();

        while (!stack.isEmpty()) {
            int currentBar = stack.pop();
            if (tallestBar < currentBar) {
                tallestBar = currentBar;
                visibleCount++;
            }
        }

        System.out.println(visibleCount);
    }
}
