package fc.problem.ch2;

import java.util.Arrays;
/*
청소로봇 ver 1
 */
public class P2 {
    static class Solution {
        public int[] solution(String moves){
            int[] dr = {-1,0,1,0};
            int[] dc = {0,1,0,-1};
            int[] dir = {'U','R','D','L'};

            int r = 0, c = 0;

            for(char command : moves.toCharArray()){
                for(int k = 0; k < 4; k++){
                    if(command == dir[k]){
                        r = r + dr[k];
                        c = c + dc[k];
                    }
                }
            }

            return new int[]{r,c};
        }

        public static void main(String[] args){
            Solution T = new Solution();
            System.out.println(Arrays.toString(T.solution("RRRDDDLU")));
            System.out.println(Arrays.toString(T.solution("DDDRRRDDLL")));
            System.out.println(Arrays.toString(T.solution("RRRRRRDDDDDDUULLL")));
            System.out.println(Arrays.toString(T.solution("RRRRDDDRRDDLLUU")));
        }
    }

}
