package programmers.l2;


public class P_NQueen {
    public static void main(String[] args) {
        P_NQueen p = new P_NQueen();
        System.out.println(p.solution(4));
    }

    static int[][] array;
    static int count = 0;
    public int solution(int n) {
        array = new int[n][n];
        nQueen(0,n);
        return count;
    }

    private static void nQueen(int depth, int n){
        if(depth == n){
            count++;
            return;
        }

       for(int i = 0; i < n; i++){
           //i : 행, depth : 열
           int[] idx = new int[]{i, depth};
           if (isPromising(idx,n)) {
               array[idx[0]][idx[1]] = 1;
               nQueen(depth + 1,n);
               array[idx[0]][idx[1]] = 0;
           }
       }
    }

    private static boolean isPromising(int[] idx, int n) {
        for (int i = 0; i < n; i++) {
            //열이 같은 경우, 행이 같은 경우 false 호출
            if (array[i][idx[1]] == 1 || array[idx[0]][i] == 1) {
                return false;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //대각선 체크
                //(열의 차와 행의 차가 같은 경우) 대각선상에 있는 경우이다.
                if (Math.abs(i - idx[0]) == Math.abs(j - idx[1])) {
                    if (array[i][j] == 1) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
