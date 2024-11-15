package fc.problem.ch2;

import java.util.Arrays;

/**
 * 청소로봇 v3
 */
public class P5 {

    static class Solution {
        public int[] solution(int[][] board, int k) {
            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, 1, 0, -1};

            int r = 0, c = 0, d = 1;
            int count = 0;
            while (count < k) {
                count++;
                int cx = r + dx[d];
                int cy = c + dy[d];

                if(cx < 0 || cx >= board.length || cy < 0 || cy >= board.length
                  || board[cx][cy] == 1){
                    d = (d+1) % 4;
                    continue;
                }

                r = cx;
                c = cy;
            }

            return new int[]{r,c};
        }

        public static void main(String[] args) {
            Solution T = new Solution();
            int[][] arr1 = {{0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0}};
            System.out.println(Arrays.toString(T.solution(arr1, 10)));
            int[][] arr2 = {{0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}};
            System.out.println(Arrays.toString(T.solution(arr2, 20)));
            int[][] arr3 = {{0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}};
            System.out.println(Arrays.toString(T.solution(arr3, 25)));

        }
    }
}
