package programmers.l2;

import java.util.ArrayList;
import java.util.List;

public class P_프렌즈4블록 {
    public static void main(String[] args) {
        P_프렌즈4블록 p = new P_프렌즈4블록();
        p.solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"});
    }

    static char[][] c_board;
    static int[] dx = {0, 1, 1};
    static int[] dy = {1, 0, 1};
    static List<int[]> list;
    static int answer = 0;
    static boolean flag;

    public int solution(int m, int n, String[] board) {
        c_board = new char[m][n];
        list = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            c_board[i] = board[i].toCharArray();
        }

        flag = true;

        while (flag) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // target 설정
                    char target = c_board[i][j];
                    // 탐색할 블록이 "-" 이면 탐색할 필요 없음
                    if (target == '-') {
                        continue;
                    }

                    // 블록 4개가 모두 같은지 확인할 변수
                    int cnt = 0;
                    for (int k = 0; k < dx.length; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if(nx < 0 || ny < 0 || nx >= c_board.length || ny >= c_board[0].length){
                            continue;
                        }

                        // target 블록과 같다면 cnt 증가
                        if (target == c_board[nx][ny]) {
                            cnt++;
                        }

                        // 제거해야할 4개의 블록이 모이면 target 좌표 저장
                        if (cnt == 3) {
                            list.add(new int[]{i, j});
                        }
                    }
                }
            }

            erase(m, n, list);
        }

        return answer;
    }

    // 블록 제거 메서드
    public static void erase(int m, int n, List<int[]> list) {
        for (int i = 0; i < list.size(); i++) {
            int x = list.get(i)[0];
            int y = list.get(i)[1];
            int[] temp = list.get(i);

            if (c_board[x][y] != '-') {
                c_board[x][y] = '-';
                answer++;
            }

            // 왼쪽, 아래, 대각선 블록 제거
            for (int j = 0; j < 3; j++) {
                int nx = temp[0] + dx[j];
                int ny = temp[1] + dy[j];
                if (c_board[nx][ny] != '-') {
                    c_board[nx][ny] = '-';
                    answer++;
                }
            }
        }

        // 만약 제거해야할 블록이 없다면 flag 상태 변경
        if(list.isEmpty()) {
            flag = false;
        }
        // 다음 탐색을 위해서 list clear
        list.clear();

        //블록 내리기 (윗블록과 스왑하기)
        for (int i = c_board.length-1; i >= 0; i--) {
            for (int j = 0; j < c_board[0].length; j++) {
                // 탐색하다 "-"을 만나면 같은열의 이전 행의 값을 가져오기
                if (c_board[i][j] == '-') {
                    for (int k = i; k >= 0; k--) {
                        if (c_board[k][j] != '-') {
                            c_board[i][j] = c_board[k][j];
                            c_board[k][j] = '-';
                            break;
                        }
                    }
                }
            }
        }
    }


}
