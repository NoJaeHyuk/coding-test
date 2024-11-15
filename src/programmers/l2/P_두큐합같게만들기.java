package programmers.l2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P_두큐합같게만들기 {
    public static void main(String[] args) {
        P_두큐합같게만들기 p = new P_두큐합같게만들기();
        p.solution(new int[]{3, 2, 7, 2},new int[]{4, 6, 5, 1});
    }

    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;

        int q1_sum = Arrays.stream(queue1).sum();
        int q2_sum = Arrays.stream(queue2).sum();

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for(int i = 0; i < queue1.length; i++){
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
        }

        while (true){
            if(q1_sum > q2_sum){
                int q1_num = q1.poll();
                q1_sum -= q1_num;
                q2_sum += q1_num;

                q2.offer(q1_num);
                answer++;
            }else if(q1_sum < q2_sum){
                int q2_num = q2.poll();
                q2_sum -= q2_num;
                q1_sum += q2_num;

                q1.offer(q2_num);
                answer++;
            }else {
                break;
            }

            if(q1.isEmpty() || q2.isEmpty()){
                answer = -1;
                break;
            }
        }
        return answer;
    }

}
