package backjoon.silver.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B25497 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String inputs = br.readLine();

        Stack<Character> sStack = new Stack<>(); // 'S' 사전 기술을 위한 스택
        Stack<Character> lStack = new Stack<>(); // 'L' 사전 기술을 위한 스택
        int count = 0;

        for (char ch : inputs.toCharArray()) {
            if (ch == 'L') {
                // 'L' 기술이 들어오면 lStack에 추가
                lStack.push(ch);
            } else if (ch == 'S') {
                // 'S' 기술이 들어오면 sStack에 추가
                sStack.push(ch);
            } else if (ch == 'R') {
                // 'R' 기술이 들어왔을 때, lStack에 'L'이 있는지 확인
                if (!lStack.isEmpty()) {
                    lStack.pop(); // 'L'을 사용하여 'R'과 연계 발동
                    count++;
                } else {
                    break; // 'L' 없이 'R'이 나오면 이후 기술 발동 중지
                }
            } else if (ch == 'K') {
                // 'K' 기술이 들어왔을 때, sStack에 'S'가 있는지 확인
                if (!sStack.isEmpty()) {
                    sStack.pop(); // 'S'를 사용하여 'K'와 연계 발동
                    count++;
                } else {
                    break; // 'S' 없이 'K'가 나오면 이후 기술 발동 중지
                }
            } else {
                // 숫자 기술은 연계 없이 단독 발동 가능
                count++;
            }
        }

        System.out.println(count);

        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String inputs = br.readLine();

        int count = 0;
        int lCount = 0; // 'L' 기술의 개수 (사전 기술)
        int sCount = 0; // 'S' 기술의 개수 (사전 기술)

        for (char ch : inputs.toCharArray()) {
            if (ch == 'L') {
                lCount++;
            } else if (ch == 'S') {
                sCount++;
            } else if (ch == 'R') {
                // 'R' 본 기술이 등장했을 때 'L'이 없으면 종료
                if (lCount > 0) {
                    lCount--;
                    count++;
                } else {
                    break;
                }
            } else if (ch == 'K') {
                // 'K' 본 기술이 등장했을 때 'S'가 없으면 종료
                if (sCount > 0) {
                    sCount--;
                    count++;
                } else {
                    break;
                }
            } else {
                // 숫자 기술은 단독으로 사용 가능
                count++;
            }
        }

        System.out.println(count);*/
    }
}
