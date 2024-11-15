package programmers.l2;

public class P_N진수게임 {
    public static void main(String[] args) {
        P_N진수게임 p = new P_N진수게임();
        p.solution(2,4,2,1);
    }


    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String result = "";
        int num = 0;

        //m명이 t번씩 말한다고 생각하면 m * t 길이의 게임에서 나올 문자를 미리 구한다.
        while(result.length() < t * m){
            //toString(int n, int radix)
            result += Integer.toString(num++, n);
        }

        // 튜브가 말해야 하는 숫자
        // result가 index 0 부터 시작
        // m*t 길이만큼 돌며 인원수 만큼 돌아야 자기 차례가 온다.
        for(int i = p-1; i < m*t; i += m){
            answer += result.charAt(i);
        }

        return answer.toUpperCase();
    }
}
