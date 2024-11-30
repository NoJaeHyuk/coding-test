package backjoon.silver.lv5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 페어프로그래밍 (드라이버)
 * 문제분석
 * 다솜이는 기호 1번
 * 다른 후보의 투표수를 파악해서 조작할 수 있다.
 * 조작하여 다솜이의 득표수가 가장 크게 해야 한다.
 * 입력은 다솜이를 포함한 후보의 투표수
 * 출력은 매수한 투표수
 *
 * 문제풀이
 * 가장 큰 수 뽑아낼 수 있어야 함으로 우선순위 큐를 사용한다.
 * 후보들(다숨이 제외) 득표수를 우선순이 큐에 넣고 
 * 큰 수부터 정렬해야한다. = 내림차순
 * 수를 비교해가면서 다솜이가 가장 많은 투표수를 가진 후보자의 값을 
 * 큐에서 빼내서 다솜이에 더해주고 후보는 투표수는 감소한다. 
 * 그런 다음 다솜이와 비교하여 다솜이가 제일 많은 투표수인지 확인하다.
 * 여기서 다솜이 조작한 투표수를 카운팅한다.
 * 최종적으론 그 카운터를 출혁한다.
 */
public class B1417_1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int dasom = Integer.parseInt(br.readLine());
        
        // 우선순위 큐 = 내림차순
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < n - 1; i++) {
            queue.add(Integer.parseInt(br.readLine()));
        }

        int count = 0;
        while (!queue.isEmpty() && dasom <= queue.peek()) {
            count++;
            dasom++;
            queue.add(queue.poll() - 1);
        }

        System.out.println(count);
    }
}
