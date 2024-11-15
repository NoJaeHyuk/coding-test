package PCCP.p1;

public class P_체육대회 {
    static int[][] ability1;
    static int[] chk;
    static int MAX = Integer.MIN_VALUE;

    public static void main(String[] args) {
        P_체육대회 p = new P_체육대회();
        p.solution(new int[][]{{40, 10, 10},{20, 5, 0},{30, 30, 30},{70, 0, 70},{100, 100, 100}});
    }

    public int solution(int[][] ability) {
        ability1 = ability;
        chk = new int[ability.length];
        DFS(0,0);
        return MAX;
    }

    private void DFS(int L, int sum) {
        if(L == ability1[0].length){
            MAX = Math.max(MAX,sum);
        }else{
            for(int j = 0; j < ability1.length; j++){
                if(chk[j] == 0){
                    chk[j] = 1;
                    DFS(L+1, sum + ability1[j][L]);
                    chk[j] = 0;
                }
            }
        }
    }


}
