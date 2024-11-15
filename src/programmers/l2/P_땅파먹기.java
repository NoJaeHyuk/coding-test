package programmers.l2;

/**
 * DP 공부하고 다시 풀기
 */
public class P_땅파먹기 {
    static int m;
    static int[][] dp;
    static int MAX = Integer.MIN_VALUE;

    public static void main(String[] args) {

    }

    int solution(int[][] land) {
        m = land.length;
        dp = new int[land.length][land[0].length];
        DFS(0,0, land,0);

        return MAX;
    }

    //DP를 공부하고 다시 풀어보자
    private void DFS(int L, int sum, int[][] lan, int index) {
        if (L == m) {
            MAX = Math.max(MAX,sum);
            return;
        }else{
            for(int i = 0; i < lan[0].length; i++){
                if(i == index){
                    continue;
                }

                DFS(L+1,sum + lan[L][i], lan, i);
            }
        }
    }

}
