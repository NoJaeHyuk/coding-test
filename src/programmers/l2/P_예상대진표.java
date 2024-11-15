package programmers.l2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P_예상대진표 {
    public static void main(String[] args) {
        P_예상대진표 p = new P_예상대진표();
        //p.solution(8,4,7);
        p.solution(8,4);
    }

    public List<Integer> solution(int N, int M) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= N; i++){
            q.offer(i);
        }

        while(!q.isEmpty()){
            int q_size = q.size();

            if(q_size == 2){
                int c1 = q.poll();
                int c2 = q.poll();

                if(c1 == M){
                    answer.add(c2);
                }else if(c2 == M){
                    answer.add(c1);
                }

                break;
            }

            for(int j = 0; j < q_size/2; j++){
                int c1 = q.poll();
                int c2 = q.poll();

                if(c1 == M){
                    answer.add(c2);
                    q.offer(M);
                }else if(c2 == M){
                    answer.add(c1);
                    q.offer(M);
                }else{
                    q.offer(c1);
                }
            }
        }

        return answer;
    }

    /*public int solution(int n, int a, int b)
    {
        int answer = 0;

        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= n; i++){
            q.offer(i);
        }

        while(!q.isEmpty()){
            int q_leng = q.size();
            answer++;
            for(int i = 0; i < q_leng/2; i++){
                int c1 = q.poll();
                int c2 = q.poll();

                if((c1 == a || c2 == a) && (c1 == b || c2 == b)) {
                    q.clear();
                    break;
                }

                if(c1 == a || c2 == a){
                    q.offer(a);
                }else if(c1 == b || c2 == b){
                    q.offer(b);
                }else{
                    q.offer(c1);
                }
            }
        }

        return answer;
    }*/
}
