package fc.problem.ch05;

import java.util.LinkedList;
import java.util.Queue;

public class P2 {
    static class Solution {
        public int solution(int[][] board){
            int[] dr = {-1,0,1,0};
            int[] dc = {0,1,0,-1};

            Queue<int[]> q = new LinkedList<>();

            q.offer(new int[]{0,0});
            board[0][0] = 1;
            int L = 0;
            while (!q.isEmpty()){
                int n = q.size();

                for(int i = 0; i < n; i++){
                    int[] cur = q.poll();

                    for(int k = 0; k < 4; k++){
                        int nr = cur[0] + dr[k];
                        int nc = cur[1] + dc[k];

                        if(nr == 6 && nc == 6){
                            return L+1;
                        }

                        if(nr < 0 || nr >= 7 || nc < 0 || nc >= 7 || board[nr][nc] == 1){
                            continue;
                        }

                        board[nr][nc] = 1;
                        q.offer(new int[]{nr, nc});
                    }
                }

                L++;
            }

            return -1;
        }

        public static void main(String[] args){
            Solution T = new Solution();
            int[][] arr={{0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 0, 1, 1},
                {1, 1, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 0, 0, 0}};
            System.out.println(T.solution(arr));
        }
    }

}
