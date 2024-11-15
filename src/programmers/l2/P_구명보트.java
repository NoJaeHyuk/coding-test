package programmers.l2;

import java.util.Arrays;

public class P_구명보트 {

    public static void main(String[] args) {
        P_구명보트 p = new P_구명보트();
        p.solution(new int[]{70, 80, 50}, 100);
    }

    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        /*
        int start = 0;

        for(int end = people.length-1; end >= start; end--){
            if(people[start] + people[end] <= limit){
                start++;
            }
            answer++;
        }
        */

        /**
         * 투포인터의 포인터 지정이 중요한 문제
         * 정렬 후 끝점이 마지막 인덱스로 선언한다.
         * 그럼 두 수의 합이 같거나 작으면 선택조건이니 양쪽 포인터를 변화시킨다.
         * 반면에 크게 되면 큰 포인터 쪽을 감소시켜야 한다.
         */
        int start = 0;
        int end = people.length-1;
        while (start <= end){
            if(people[start] + people[end] <= limit){
                start++;
                end--;
                answer++;
            }else{
                end--;
                answer++;
            }
        }

        return answer;
    }
}
