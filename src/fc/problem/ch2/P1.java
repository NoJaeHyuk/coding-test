package fc.problem.ch2;

/**
 * 웅덩이
 */
public class P1 {
    static class Solution {
        public int solution(int[][] nums){
            int[] dr = {-1,0,1,0};
            int[] dc = {0,1,0,-1};

            int answer = 0;

            for(int i = 0; i < nums.length; i++){
                for(int j = 0; j < nums.length; j++){
                    boolean flag = true;
                    for(int k = 0; k < dr.length; k++){
                        int nx = i + dr[k];
                        int ny = j + dc[k];

                        if(nx >= 0 && nx < nums.length && ny >= 0 && ny < nums.length && nums[nx][ny] <= nums[i][j]){
                            flag = false;
                            break;
                        }
                    }

                    if(flag){
                        answer++;
                    }

                }
            }

            return answer;
        }

        public static void main(String[] args){
            Solution T = new Solution();
            System.out.println(T.solution(new int[][]{{10, 20, 50, 30, 20}, {20, 30, 50, 70, 90}, {10, 15, 25, 80, 35}, {25, 35, 40, 55, 80}, {30, 20, 35, 40, 90}}));
            System.out.println(T.solution(new int[][]{{80, 25, 10, 65, 100}, {20, 10, 32, 70, 33}, {45, 10, 88, 9, 90}, {10, 35, 10, 55, 66}, {10, 84, 65, 88, 99}}));
            System.out.println(T.solution(new int[][]{{33, 22, 55, 65, 55}, {55, 88, 99, 12, 19}, {18, 33, 25, 57, 77}, {46, 78, 54, 55, 99}, {33, 25, 47, 85, 17}}));
        }
    }

}
