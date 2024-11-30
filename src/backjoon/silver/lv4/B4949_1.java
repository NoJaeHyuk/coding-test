package backjoon.silver.lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 항해 페이 프로그램
 * 문제 분석
 * 1. 소괄호와 대괄호는 짝을 이뤄야한다.
 * 2. 모든 괄호는 1:1 매칭이 되어야 한다. (모든 오른쪽 괄호들은 자신과 짝을 이룰 수 있는 왼쪽 괄호가 존재)
 * 3. 매칭 된 문자열만 균형을 이룬다.
 * 4. 온점(.) 하나만 들어온 경우 종료된다.
 *
 * 풀이 방식
 * 1. stack -> list 풀어보기
 */
public class B4949_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String text = br.readLine();
            // 온점(.)을 만난 경우 종료한다.
            if(text.equals(".")){
                break;
            }

            List<Character> list = new ArrayList<>();
            boolean isChecked = true; // 완전하지 못한 괄호 처리

            for (char ch : text.toCharArray()) {
                if (ch == '(' || ch == '[') {
                    // 여는 괄호를 만났을 경우 리스트에 넣어준다.
                    list.add(ch);
                } else if (ch == ')' || ch == ']') { // 닫는 괄호를 만났을 때
                    // 리스트가 비어있는 경우 매칭할 괄호가 없는 것이므로 false
                    if (list.isEmpty()) {
                        isChecked = false;
                        break;
                    }

                    char lastCh = list.get(list.size() - 1); // peek() 리스트 마지막 값
                    if ((ch == ')' && lastCh == '(') || (ch == ']' && lastCh == '[')) {
                        // 올바른 괄호를 만나는 경우 마지막 값을 제거한다.
                        list.remove(list.size() - 1);
                    } else {
                        // 올바르지 못한 괄호를 만나는 경우
                        isChecked = false;
                        break;
                    }
                }
            }

            // 출력
            if(isChecked && list.isEmpty()) {
                System.out.println("yes");
            }else {
                System.out.println("no");
            }
        }

        br.close();
    }
}
