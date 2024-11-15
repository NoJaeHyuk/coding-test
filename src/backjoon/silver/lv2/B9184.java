package backjoon.silver.lv2;

import java.io.*;

public class B9184 {
    static int[][][] memo = new int[21][21][21]; // 메모이제이션을 위한 배열

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        while (true) {
            String[] inputs = reader.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);
            int c = Integer.parseInt(inputs[2]);

            // 종료 조건
            if (a == -1 && b == -1 && c == -1) {
                break;
            }

            int result = w(a, b, c);
            output.append(String.format("w(%d, %d, %d) = %d\n", a, b, c, result));
        }

        System.out.print(output.toString()); // 한 번에 출력
    }

    public static int w(int a, int b, int c) {
        // 첫 번째 조건: a, b, c 중 하나라도 0 이하일 때
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        // 두 번째 조건: a, b, c 중 하나라도 20 초과일 때
        if (a > 20 || b > 20 || c > 20) {
            return w(20, 20, 20);
        }

        // 메모이제이션: 이미 계산된 값이 있을 경우 그 값을 반환
        if (memo[a][b][c] != 0) {
            return memo[a][b][c];
        }

        // 세 번째 조건: a < b < c일 때
        if (a < b && b < c) {
            memo[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        } else {
            // 네 번째 조건: 그 외의 경우
            memo[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        }

        return memo[a][b][c];
    }
}
