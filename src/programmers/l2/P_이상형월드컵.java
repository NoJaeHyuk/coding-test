package programmers.l2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P_이상형월드컵 {
    public static void main(String[] args) {
        P_이상형월드컵 p = new P_이상형월드컵();
        //p.solution(8,4,7);
        p.solution(4,1, new int[]{3,1,2,4});
    }

    public int[] solution(int N, int M, int[] A) {
        List<Integer> answer = new ArrayList<>();

        Queue<Point> q = new LinkedList<>();

        for(int i = 1; i <= N; i++){
            q.offer(new Point(i,A[i-1]));
        }

        while(!q.isEmpty()){
            int q_size = q.size();

            if(q_size == 2){
                Point c1 = q.poll();
                Point c2 = q.poll();

                if(c1.idx == M){
                    answer.add(c2.idx);
                }else if(c2.idx == M){
                    answer.add(c1.idx);
                }

                break;
            }

            for(int j = 0; j < q_size/2; j++){
                Point c1 = q.poll();
                Point c2 = q.poll();

                if(c1.idx == M){
                    answer.add(c2.idx);
                    q.offer(new Point(M,A[M-1]));
                }else if(c2.idx == M){
                    answer.add(c1.idx);
                    q.offer(new Point(M,A[M-1]));
                }else{
                    if(A[c1.idx-1] > A[c2.idx-1]){
                        //answer.add(c1.idx);
                        q.offer(new Point(c1.idx,A[c1.idx-1]));
                    }else if(A[c1.idx-1] < A[c2.idx-1]){
                        //answer.add(c2.idx);
                        q.offer(new Point(c2.idx,A[c2.idx-1]));
                    }else{
                        //answer.add(c1.idx);
                        q.offer(new Point(c1.idx,A[c1.idx-1]));
                    }
                }
            }
        }

        int[] arr = answer.stream()
                .mapToInt(i -> i)
                .toArray();

        return arr;
    }

    /*public List<Integer> solution(int N, int M) {
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
*/
    static class Point{
        private int idx;
        private int charm;

        Point(int idx, int charm){
            this.idx = idx;
            this.charm = charm;
        }
    }
}
