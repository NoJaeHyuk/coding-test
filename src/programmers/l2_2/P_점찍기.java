package programmers.l2_2;

public class P_점찍기 {

    public static void main(String[] args) {
        P_점찍기 p = new P_점찍기();
        p.solution(2,4);
    }

    public long solution(int k, int d) {
        long answer = 0;

        //피타고라스 정의의해
        //y2 = d2 - x2 유추 가능
        //가장 쉬운 방식은 이중 for 문을 활용하면 되지만
        //시간초과가 난다.
        //그래서 x 기준 으로 y 값을 찾아주는 것이다.
        //maxY / k + 1 에서 +1 은 (x,0) 의 값이다.
        for(long x = 0; x <= d; x += k){
            long dd = (long) d * d;
            long ii = (long) x * x;
            long maxY = (long) Math.sqrt(dd - ii);
            answer += maxY / k + 1;
        }

        return answer;
    }


}
