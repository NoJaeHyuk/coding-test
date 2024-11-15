package inflearn.ch05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
6. 공주 구하기
 */
public class Problem_6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        solution(n,k);
    }

    public static void solution(int n, int k){
        Queue<Integer> queue = new LinkedList<>();

        //초기세팅
        for(int i = 0; i < n; i++){
            queue.add(i+1);
        }

        while (!queue.isEmpty()){
            //count k-1 까지 수는 다시 큐의 add 한다.
            //순환구조이므로
            for(int i = 1; i < k; i++){
                int cur_q = queue.poll();
                queue.add(cur_q);
            }
            //count 3 인 경우
            queue.poll();

            //큐의 사이즈 1 일때 최종 1개가 남는다는 의미
            if(queue.size() == 1){
                System.out.println(queue.peek());
                return;
            }
        }
    }
}
