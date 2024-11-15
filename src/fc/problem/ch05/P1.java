package fc.problem.ch05;

import java.util.LinkedList;
import java.util.Queue;

public class P1 {
    static class Solution {
        public int solution(int home){
            int[] ch = new int[10001];

            Queue<Integer> q = new LinkedList<>();
            q.offer(0);
            ch[0] = 1;
            int L = 0;
            while (!q.isEmpty()){
                int n = q.size();

                for(int i = 0; i < n; i++){
                    int v = q.poll();

                    for(int nv : new int[]{v+1, v+5, v-1}){
                        if(nv == home){
                            return L+1;
                        }
                        if(nv >= 0){
                            if(ch[nv] == 1){
                                continue;
                            }
                            ch[nv] = 1;
                            q.offer(nv);
                        }
                    }
                }
                L++;
            }

            return 0;
        }

        public static void main(String[] args){
            Solution T = new Solution();
            System.out.println(T.solution(10));
            System.out.println(T.solution(14));
            System.out.println(T.solution(25));
            System.out.println(T.solution(24));
            System.out.println(T.solution(345));
        }
    }
}
