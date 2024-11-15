package fc.problem.ch2;

import java.util.Arrays;

public class P3 {
    static class Solution {
        public int[] solution(int n, String moves){
            int[] dr = {-1,0,1,0};
            int[] dc = {0,1,0,-1};
            int[] dir = {'U','R','D','L'};

            int r = 0, c = 0;

            for(char command : moves.toCharArray()){
                for(int k = 0; k < 4; k++){
                    if(command == dir[k]){
                        int cr = r + dr[k];
                        int cc = c + dc[k];

                        if(cr >= 0 && cr < n && cc >= 0 && cc < n){
                            r = cr;
                            c = cc;
                        }
                    }
                }
            }

            return new int[]{r,c};
        }

        public static void main(String[] args){
            Solution T = new Solution();
            System.out.println(Arrays.toString(T.solution(5, "RRRDDDUUUUUUL")));
            System.out.println(Arrays.toString(T.solution(7, "DDDRRRDDLL")));
            System.out.println(Arrays.toString(T.solution(5, "RRRRRDDDDDU")));
            System.out.println(Arrays.toString(T.solution(6, "RRRRDDDRRDDLLUU")));
        }
    }

}
