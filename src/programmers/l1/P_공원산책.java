package programmers.l1;

public class P_공원산책 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new String[]{"SOO","OOO","OOO"},new String[]{"E 2","S 2","W 1"});
    }

    static class Solution {
        public int[] solution(String[] park, String[] routes) {
            int[] dr = {-1, 0 , 1 , 0};
            int[] dc = {0, 1, 0, -1};
            char[] op = {'N','E','S','W'};

            int r = 0,c = 0;

            // string 배열 -> char 이차원 배열로 변경
            char[][] board = new char[park.length][];

            for(int i = 0; i < park.length; i++){
                board[i] = park[i].toCharArray();
                for(int j = 0; j < park[0].length(); j++){
                    if(board[i][j] == 'S'){
                        r = i;
                        c = j;
                    }
                }
            }

            for(String str : routes){
                char cmd = str.split(" ")[0].charAt(0);
                int dis = Integer.parseInt(str.split(" ")[1]);

                for(int i = 0; i < 4; i++){
                    if(cmd == op[i]){
                        int cr = r;
                        int cc = c;
                        boolean flag = true;
                        for(int j = 0; j < dis; j++){
                            cr = cr + dr[i];
                            cc = cc + dc[i];

                            if(cr < 0 || cr >= board.length || cc < 0 || cc >= board[0].length
                                || board[cr][cc] == 'X'){
                                flag = false;
                                break;
                            }
                        }

                        if(flag){
                            r = cr;
                            c = cc;
                        }
                    }
                }
            }

            return new int[]{r,c};
        }
    }
}
