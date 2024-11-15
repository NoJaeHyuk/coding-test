package backjoon.silver.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B26042 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            if (Integer.parseInt(inputs[0]) == 1) {
                int value = Integer.parseInt(inputs[1]);
                queue.add(value);

                // 큐의 크기 업데이트 시 최대 크기와 최소 값 관리
                if(queue.size() > max) {
                    max = queue.size();
                    min = value; // 새로운 최대 크기 도달 시 최소 값 초기화
                } else if(queue.size() == max) {
                    min = Math.min(min, value); // 최대 크기와 동일한 경우 최소 값 업데이트
                }
            } else {
                queue.poll();
            }
        }

        System.out.println(max + " " + min);
    }
}
