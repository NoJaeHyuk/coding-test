package backjoon.gold.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B1863 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int buildingCount = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && stack.peek() > y) {
                stack.pop();
                buildingCount++;
            }

            while (stack.isEmpty() || stack.peek() < y) {
                stack.push(y);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.pop() > 0) {
                buildingCount++;
            }
        }

        System.out.println(buildingCount);
    }
}
