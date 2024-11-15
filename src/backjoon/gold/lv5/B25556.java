package backjoon.gold.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/25556
 * 포스택 골드 5
 * 스텍과 순열 문제
 */
public class B25556 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());  // 첫 번째 줄에서 정수 n 읽기
        int[] array = new int[n];  // 정수 n의 크기를 가진 배열 생성

        StringTokenizer st = new StringTokenizer(br.readLine());  // 두 번째 줄에서 정수 배열 읽기
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());  // 배열에 정수 저장
        }

        // 네개의 스텍이 존재한다.
        List<Stack<Integer>> stacks = new ArrayList<>();

        for(int i = 0; i < 4; i++){
            stacks.add(new Stack<>());
        }

        // 배열을 돌면서 스택에 데이터를 넣는다.
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < stacks.size(); j++) {
                if (stacks.get(j).size() == 0) {
                    stacks.get(j).push(array[i]);
                    break;
                }

                if (stacks.get(j).peek() < array[i]) {
                    stacks.get(j).push(array[i]);
                    break;
                }

                // 더 이상 넣을 값을 push 할 스택이 없으면 fail
                if (j == stacks.size() - 1) {
                    System.out.println("NO");
                    return;
                }
            }
        }

        System.out.println("YES");
    }
}
