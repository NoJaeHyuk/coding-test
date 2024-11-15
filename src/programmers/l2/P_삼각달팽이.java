package programmers.l2;

public class P_삼각달팽이 {
    public static void main(String[] args) {
        P_삼각달팽이 p = new P_삼각달팽이();
        p.solution(4);
    }

    public int[] solution(int n) {
        int[] answer = new int[n*(n+1)/2];
        int[][] board = new int[n][n];

        //첫 동작은 아래로 내려가니깐 첫 인덱스 고려해 -1 로 설정
        int r = -1;
        int c = 0;
        int index = 1;

        //n이 4면 4,3,2,1 로 동작하는것을 알 수 있다.
        //n번 동작하며 하나씩 줄어들면서 것을 확인할 수 있다.
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                //3종류의 방법으로 동작한다.
                //1. 아래로 내려가며 동작
                //2. 오른쪽으로 이동하며 동작
                //3. 대각선 위로 이동하며 동작
                if(i%3 == 0){
                    r++;
                }

                if(i%3 == 1){
                    c++;
                }

                if(i%3 == 2){
                    c--;
                    r--;
                }

                board[r][c] = index++;
            }

        }

        int num = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 0) break;
                answer[num++] = board[i][j];
            }
        }

        return answer;
    }


}
