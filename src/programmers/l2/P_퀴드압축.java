package programmers.l2;

/**
 * 분할정복
 * DP
 */
public class P_퀴드압축 {
    static int[] answer = new int[2];

    public static void main(String[] args) {
        P_퀴드압축 p = new P_퀴드압축();
        p.solution(new int[][]{{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}});
    }

    public int[] solution(int[][] arr) {
        DP(0, 0, arr.length, arr);
        return answer;
    }

    // 분할정복을 수행 > DP
    private static void DP(int sX, int sY, int size, int[][] arr) {
        //조건을 만족하거나 완전분할되거나
        if (check(sX, sY, size, arr)) {
            //arr[][] 값이 0 or 1 이다.
            answer[arr[sX][sY]]++;
            return;
        }

        // 4등분 !!
        DP(sX, sY, size / 2, arr);
        DP(sX + size / 2, sY, size / 2, arr);
        DP(sX, sY + size / 2, size / 2, arr);
        DP(sX + size / 2, sY + size / 2, size / 2, arr);
    }

    // 분할정복 체크
    private static boolean check(int x, int y, int size, int[][] arr) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[x][y] != arr[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}
