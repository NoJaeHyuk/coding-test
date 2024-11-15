package PCCP.p1;

public class P_유전법칙 {
    public static void main(String[] args) {
        P_유전법칙 p = new P_유전법칙();

        p.solution(new int[][]{{1,1}});
    }

    public String[] solution(int[][] queries) {
        String[] result = new String[queries.length];
        for(int i = 0; i < queries.length; i++){
            //1세대는 고정
            if(queries[i][0] == 1){
                result[i] = "Rr";
            }else{
                result[i] = recursive(queries[i][0], queries[i][1]);
            }
        }
        return result;
    }

    private String recursive(int n, int p) {
        //전체 값
        int cnt = (int) Math.pow(4, n-1);
        //RR,rr는 일차로 거르기 가능
        if(p <= cnt / 4) {
            return "RR";
        }
        if(p > cnt / 4 * 3) {
            return "rr";
        }

        //2세대일때는 위 조건에 안맞으면 무조건 Rr 이므로 고정값
        if(n == 2) {
            return "Rr";
        }

        //2비율의 첫 부분
        //p-cnt/4 (RR 비율인 1 제거)
        if(p > cnt / 4 && p <= cnt/2) {
            return recursive(n-1, p-cnt/4);
        }

        //2비율의 두번쨰 부분
        return recursive(n-1, p-cnt/2);
    }
}
