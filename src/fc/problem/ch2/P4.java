package fc.problem.ch2;

import java.util.Arrays;

/**
 * 로봇의 이동
 */
public class P4 {
    static class Solution {
        public int[] solution(String moves){
            int[] dx = {-1,0,1,0};
            int[] dy = {0,1,0,-1};

            int r = 0,c = 0;
            // dx는 index 0,1,2,3 이며, 12시,3시,9시,6시 로 설정했다.
            // 문제를 보면 index 1 방향부터 시작한다.
            // 이런 경우 시계방향은 1 2 3 0 순으로 이동된다.
            // d = (d+1) % 4 로 구해주면 된다.
            // 반시계 방향은 1 0 3 2 이다.
            // d = (d+3) % 4 로 구하면 된다.
            int d = 1;

            for(char commend : moves.toCharArray()){
                if(commend == 'R'){
                    //시계방향
                    d = (d+1) % 4;
                }
                if(commend == 'L'){
                    //반시계방향
                    d = (d+3) % 4;
                }
                if(commend == 'G'){
                    int cr = r + dx[d];
                    int cy = c + dy[d];

                    if(cr >= 0 && cr < 100 && cy >= 0 && cy < 100){
                        r = cr;
                        c = cy;
                    }
                }
            }

            return new int[]{r,c};
        }

        public static void main(String[] args){
            Solution T = new Solution();
            System.out.println(Arrays.toString(T.solution("GGGRGGG")));
            System.out.println(Arrays.toString(T.solution("GGRGGG")));
            System.out.println(Arrays.toString(T.solution("GGGGGGGRGGGRGGRGGGLGGG")));
            System.out.println(Arrays.toString(T.solution("GGLLLGLGGG")));
        }
    }
}
