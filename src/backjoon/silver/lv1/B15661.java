package backjoon.silver.lv1;

import java.util.Scanner;

public class B15661 {
    static boolean visit[]; //방문기록
    static int[][] S;       //출력값배열
    static int MIN = Integer.MAX_VALUE; //최소값 초기화 = 초기값은 처음엔 최대값으로 지정

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int N = sc.nextInt();

        S = new int[N][N];
        visit = new boolean[N];

        for(int i = 0; i<N; i++){
            for (int j = 0; j<N; j++){
                S[i][j] = sc.nextInt();
            }
        }

        //count = 인덱스 0~3 탐색 수
        solve(N,0);

        System.out.println(MIN);
    }

    public static void solve(int N, int count){
        //탐색을 완료했을때만 로직 동작
        if(count == N){
            int start_team = 0;
            int link_team = 0;

            for(int i = 0; i < N; i++){
                for(int j = i+1; j < N; j++){
                    if(visit[i] == true && visit[j] == true){
                        start_team += S[i][j] + S[j][i];
                    }else if(visit[i] == false && visit[j] == false){
                        link_team += S[i][j] + S[j][i];
                    }
                }
            }

            int val = Math.abs(start_team - link_team);
            MIN = Math.min(val,MIN);

            //재귀나가기 위한 선언 = 방문이 끝난 재귀는 종료
            return;
        }


        // 4 - > 3 - > 2 - > 1 재귀를 돌며 전체 탐색 후 최소값 갱신 진행
        visit[count] = true;
        solve(N,count+1);
        visit[count] = false;
        solve(N,count+1);


    }
}
